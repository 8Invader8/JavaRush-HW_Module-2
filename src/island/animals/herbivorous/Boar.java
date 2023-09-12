package island.animals.herbivorous;

import island.IslandFormOfLife;
import island.Plants;
import island.animals.Animals;
import island.animals.predators.Bear;
import java.util.HashMap;
import java.util.Map;

public class Boar extends Herbivorous {
    private final Map<IslandFormOfLife, Integer> canEat = new HashMap<>();
    private final String animalName = "Boar";
    private final String animalIcon = "\uD83D\uDC17";
    private final double weightOfAnimal = 400.0;
    private final int maxPopulationOnOneLocation = 50;
    private final int maxStepByMove = 2;
    private final double maxKiloCanEat = 50.0;
    private final int animalLowHealth = 40;
    private final int chanceToEatMouse = 50;
    private final int chanceToEatCaterpillar = 90;
    private final int chanceToEatPlants = 100;
    private double stomachFullness = 200.0;

    {
        canEat.put(new Mouse(),chanceToEatMouse);
        canEat.put(new Caterpillar(),chanceToEatCaterpillar);
        canEat.put(new Plants(),chanceToEatPlants);
    }

    public Boar(){
        setAnimalName(animalName);
        setAnimalIcon(animalIcon);
        setWeightOfAnimal(weightOfAnimal);
        setMaxKiloCanEat(maxKiloCanEat);
        setStomachFullness(stomachFullness);
        setMaxStepByMove(maxStepByMove);
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
    public boolean eat(Plants plant) {
        if(canEat.containsKey(plant)) {
            super.eat(plant);
        }
        return true;
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
