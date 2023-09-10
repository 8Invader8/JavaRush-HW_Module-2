package island.animals.herbivorous;


import island.IslandFormOfLife;
import island.Plants;
import island.animals.Animals;
import island.animals.predators.Bear;
import java.util.HashMap;
import java.util.Map;

public class Buffalo extends Herbivorous{
    private final Map<IslandFormOfLife, Integer> canEat = new HashMap<>();
    private final String animalName = "Buffalo";
    private final String animalIcon = "\uD83D\uDC03";
    private final double weightOfAnimal = 700.0;
    private final int maxPopulationOnOneLocation = 10;
    private final int maxStepByMove = 3;
    private final double maxKiloCanEat = 100.0;
    private final int animalLowHealth = 40;
    private final int chanceToEatPlants = 100;
    private double stomachFullness = 350.0;

    {
        canEat.put(new Plants(), chanceToEatPlants);
    }

    public Buffalo(){
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
