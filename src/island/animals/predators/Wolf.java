package island.animals.predators;


import island.IslandFormOfLife;
import island.animals.Animals;
import island.animals.herbivorous.*;
import java.util.HashMap;
import java.util.Map;

public class Wolf  extends Predator{
    private static final Map<IslandFormOfLife, Integer> canEat = new HashMap<>();
    private final String animalIcon = "\uD83D\uDC3A";
    private final String animalName = "Wolf";
    private final double weightOfAnimal = 50.0;
    private final int maxPopulationOnOneLocation = 30;
    private final int maxStepByMove = 3;
    private final double maxKiloCanEat = 8.0;
    private final int animalLowHealth = 5;
    private double stomachFullness = 25.0;
    private final int chanceToKillHorse = 10;
    private final int chanceToKillDeer = 15;
    private final int chanceToKillRabbit = 60;
    private final int chanceToKillMouse = 80;
    private final int chanceToKillGoat = 60;
    private final int chanceToKillSheep = 70;
    private final int chanceToKillBoar = 15;
    private final int chanceToKillBuffalo = 10;
    private final int chanceToKillDuck = 40;

    {
        canEat.put(new Horse(), chanceToKillHorse);
        canEat.put(new Deer(), chanceToKillDeer);
        canEat.put(new Rabbit(), chanceToKillRabbit);
        canEat.put(new Mouse(), chanceToKillMouse);
        canEat.put(new Goat(), chanceToKillGoat);
        canEat.put(new Sheep(), chanceToKillSheep);
        canEat.put(new Boar(), chanceToKillBoar);
        canEat.put(new Buffalo(), chanceToKillBuffalo);
        canEat.put(new Duck(), chanceToKillDuck);
    }

    public Wolf(){
        setAnimalName(animalName);
        setAnimalIcon(animalIcon);
        setWeightOfAnimal(weightOfAnimal);
        setMaxStepByMove(maxStepByMove);
        setMaxKiloCanEat(maxKiloCanEat);
        setStomachFullness(stomachFullness);
    }
    protected void getHungry(){
        double hungry = getMaxKiloCanEat()/10;
        setStomachFullness(getStomachFullness() - hungry);
    }
    public boolean eat(Animals islandFormOfLife){
        int chanceOfEat;
        if(stomachFullness < maxKiloCanEat) {
            if (canEat.containsKey(islandFormOfLife)) {
                chanceOfEat = RANDOM.nextInt(100 + 1);
                if (chanceOfEat >= canEat.get(islandFormOfLife)) {
                    stomachFullness += islandFormOfLife.getWeightOfAnimal()/2;
                    islandFormOfLife.setAlive(false);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean eat(IslandFormOfLife islandFormOfLife) {
        return false;
    }

    @Override
    public void reproduce(Animals animals) {
        int chanceOfReproduce = RANDOM.nextInt(2);
        if(chanceOfReproduce == 1){
            if(!(animalsOnOneField.size() >= maxPopulationOnOneLocation)) {
                animalsOnOneField.add(new Bear());
            }
        }
    }


    public void die(IslandFormOfLife islandFormOfLife){
        if(weightOfAnimal == animalLowHealth){
            animalsOnOneField.remove(islandFormOfLife);
        }
    }

    @Override
    public void run(){
        setY(RANDOM.nextInt(island.getHeight()));
        setX(RANDOM.nextInt(island.getWidth()));

        island.fields[getY()][getX()].animalsOnOneField.add(this);
        while (isAlive()) {
            island.move(this);

            for (Animals animal : island.fields[getY()][getX()].animalsOnOneField){
                this.eat(animal);
            }

            for(Animals animal : island.fields[getY()][getX()].animalsOnOneField){
                this.reproduce(animal);
            }

            getHungry();
            die(this);

            try{
                Thread.sleep(3000);
            }catch (InterruptedException e){
                throw new RuntimeException("Thread was interrupted!");
            }
        }
    }
}
