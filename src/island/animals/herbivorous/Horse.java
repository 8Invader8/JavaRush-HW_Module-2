package island.animals.herbivorous;

import island.IslandFormOfLife;
import island.Plants;
import island.animals.Animals;
import island.animals.predators.Bear;
import java.util.HashMap;
import java.util.Map;

public class Horse extends Herbivorous {
    private final Map<IslandFormOfLife, Integer> canEat = new HashMap<>();
    private final String animalName = "Goat";
    private final String animalIcon = "\uD83D\uDC0E";
    private final double weightOfAnimal = 400.0;
    private final int maxPopulationOnOneLocation = 20;
    private final int maxStepByMove = 4;
    private final double maxKiloCanEat = 60.0;
    private final int animalLowHealth = 40;
    private final int chanceToEatPlants = 100;
    private double stomachFullness = 30.0;


    {
        canEat.put(new Plants(), chanceToEatPlants);
    }

    public Horse(){
        setAnimalName(animalName);
        setAnimalIcon(animalIcon);
        setWeightOfAnimal(weightOfAnimal);
        setMaxKiloCanEat(maxKiloCanEat);
        setStomachFullness(stomachFullness);
        setMaxStepByMove(maxStepByMove);
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
