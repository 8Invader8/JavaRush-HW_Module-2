package island.animals.predators;


import island.IslandFormOfLife;
import island.animals.Animals;
import island.animals.herbivorous.Caterpillar;
import island.animals.herbivorous.Duck;
import island.animals.herbivorous.Mouse;
import island.animals.herbivorous.Rabbit;
import java.util.HashMap;
import java.util.Map;

public class Fox extends Predator {
    private static final Map<IslandFormOfLife, Integer> canEat = new HashMap<>();
    private final String animalIcon = "\uD83E\uDD8A";
    private final String animalName = "Fox";
    private final double weightOfAnimal = 8.0;
    private final int maxPopulationOnOneLocation = 30;
    private final int maxStepByMove = 2;
    private final double maxKiloCanEat = 2.0;
    private final int animalLowHealth = 1;
    private double stomachFullness = 4.0;
    private final int chanceToKillCaterpillar = 40;
    private final int chanceToKillRabbit = 70;
    private final int chanceToKillMouse = 90;
    private final int chanceToKillDuck = 60;


    {
        canEat.put(new Caterpillar(), chanceToKillCaterpillar);
        canEat.put(new Mouse(), chanceToKillMouse);
        canEat.put(new Rabbit(), chanceToKillRabbit);
        canEat.put(new Duck(), chanceToKillDuck);
    }

    public Fox(){
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
