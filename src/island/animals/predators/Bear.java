package island.animals.predators;


import island.animals.Animals;
import island.animals.herbivorous.*;
import island.IslandFormOfLife;
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


    public boolean eat(Animals islandFormOfLife){
        int chanceOfEat;
        if(stomachFullness < maxKiloCanEat) {
            if (canEat.containsKey(islandFormOfLife)) {
                chanceOfEat = RANDOM.nextInt(0,100 + 1);
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
            if(!(animalsOnField.size() >= maxPopulationOnOneLocation)) {
                animalsOnField.add(new Bear());
            }
        }
    }


    public void die(IslandFormOfLife islandFormOfLife){
        if(weightOfAnimal == animalLowHealth){
            animalsOnField.remove(islandFormOfLife);
        }
    }
}
