package island.animals.predators;


import island.IslandFormOfLife;
import island.animals.Animals;
import island.animals.herbivorous.*;
import java.util.*;

public class Bear extends Predator {
    private static final Map<IslandFormOfLife, Integer> canEat = new HashMap<>();
    private final String animalIcon = "\uD83D\uDC3B";
    private final String animalName = "Bear";
    private final double weightOfAnimal = 500.0;
    private final int maxPopulationOnOneLocation = 5;
    private final int maxStepByMove = 2;
    private final double maxKiloCanEat = 80.0;
    private final int animalLowHealth = 10;
    private double stomachFullness = 40.0;
    private boolean isAlive = true;
    private final int chanceToKillBoa = 80;
    private final int chanceToKillHorse = 40;
    private final int chanceToKillDeer = 80;
    private final int chanceToKillRabbit = 80;
    private final int chanceToKillMouse = 90;
    private final int chanceToKillGoat = 70;
    private final int chanceToKillSheep = 70;
    private final int chanceToKillBuffalo = 20;
    private final int chanceToKillDuck = 10;

    {

        canEat.put(new Boa(),chanceToKillBoa);
        canEat.put(new Horse(),chanceToKillHorse);
        canEat.put(new Deer(),chanceToKillDeer);
        canEat.put(new Rabbit(),chanceToKillRabbit);
        canEat.put(new Mouse(),chanceToKillMouse);
        canEat.put(new Goat(),chanceToKillGoat);
        canEat.put(new Sheep(),chanceToKillSheep);
        canEat.put(new Buffalo(),chanceToKillBuffalo);
        canEat.put(new Duck(),chanceToKillDuck);

    }


    public Bear(){
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
