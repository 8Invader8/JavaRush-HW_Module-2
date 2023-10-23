package core.animals.predators;


import core.IslandFormOfLife;
import core.animals.Animals;
import core.animals.herbivorous.*;
import java.util.*;

public class Bear extends Predator {
    private static final Map<IslandFormOfLife, Integer> canEat = new HashMap<>();
    private final String animalIcon = "\uD83D\uDC3B";
    private final String animalName = "Bear";
    private final double weightOfAnimal = 500.0;
    private final int maxPopulationOnOneLocation = 5;
    private final int maxStepByMove = 2;
    private final double maxKiloCanEat = 80.0;
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
    }
//    protected void getHungry(){
//        int chanceToDie = RANDOM.nextInt(2);
//        if (chanceToDie == 1){
//            island.fields[][]
//        }
//        double hungry = getMaxKiloCanEat()/10;
//        setStomachFullness(getStomachFullness() - hungry);
//    }
    @Override
    public boolean eat(Animals animals){
        int chanceOfEat;
            if (canEat.containsKey(animals)) {
                chanceOfEat = RANDOM.nextInt(100 + 1);
                if (chanceOfEat >= canEat.get(animals)) {
//                    stomachFullness += animals.getWeightOfAnimal()/2;
                    animals.setAlive(false);
                    island.fields[animals.getY()][animals.getX()].getFieldHashMap().put(
                            animals,
                            (island.fields[animals.getY()][animals.getX()].getFieldHashMap().get(animals) - 1)
                    );
                    return true;
                }
            }
        return false;
    }

    @Override
    public void reproduce(Animals animals) {
        HashMap<IslandFormOfLife, Integer> localField = island.fields[animals.getY()][animals.getX()].getFieldHashMap();
        int chanceOfReproduce = RANDOM.nextInt(2);
        if(chanceOfReproduce == 1){
            if(!(localField.get(animals) >= maxPopulationOnOneLocation)) {
                localField.put(animals, localField.get(animals) + 1);
            }
        }
    }

    @Override
    public void die(IslandFormOfLife islandFormOfLife) {

    }

    public void die(Animals animals){
        int chanceToDie = RANDOM.nextInt(2);
        if (chanceToDie == 1){
            island.fields[animals.getY()][animals.getX()].getFieldHashMap().put(
                    animals,
                    island.fields[animals.getY()][animals.getX()].getFieldHashMap().get(animals) - 1
            );
        }
//        if(weightOfAnimal == animalLowHealth){
//            island.fields[animals.getY()][animals.getX()].getFieldHashMap().put(animals,
//                    island.fields[animals.getY()][animals.getX()].getFieldHashMap().get(animals) - 1);
//        }
    }

    @Override
    public void run(){
        setY(RANDOM.nextInt(island.getHeight()));
        setX(RANDOM.nextInt(island.getWidth()));

        island.fields[getY()][getX()].getFieldHashMap().put(
                this,
                (island.fields[getY()][getX()].getFieldHashMap().get(this) + 1)
        );

        while (isAlive) {
            island.move(this);

            for(Map.Entry<IslandFormOfLife, Integer> entry : island.fields[getY()][getX()].getFieldHashMap().entrySet()) {
                if (Objects.equals(entry.getKey().getClass(), Animals.class)){
                        this.eat((Animals) entry.getKey());
                }
            }

            for(Map.Entry<IslandFormOfLife, Integer> entry : island.fields[getY()][getX()].getFieldHashMap().entrySet()) {
                if (Objects.equals(entry.getKey().getClass(), Animals.class)) {
                        this.reproduce((Animals) entry.getKey());
                }
            }

//            getHungry();
            die(this);

            try{
                Thread.sleep(3000);
            }catch (InterruptedException e){
                throw new RuntimeException("Thread was interrupted!");
            }
        }
    }
}
