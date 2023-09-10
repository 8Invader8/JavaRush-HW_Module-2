package island.animals.herbivorous;

import island.IslandFormOfLife;
import island.Plants;
import island.animals.Animals;
import island.animals.predators.Bear;
import java.util.HashMap;
import java.util.Map;

public class Duck extends Herbivorous {
    private final Map<IslandFormOfLife, Integer> canEat = new HashMap<>();
    private final String animalName = "Duck";
    private final String animalIcon = "\uD83E\uDD86";
    private final double weightOfAnimal = 1.0;
    private final int maxPopulationOnOneLocation = 200;
    private final int maxStepByMove = 4;
    private final double maxKiloCanEat = 0.15;
    private final int animalLowHealth = 40;
    private final int chanceToEatCaterpillar = 90;
    private final int chanceToEatPlants = 100;
    private double stomachFullness = 0.5;
    ;

    {
        canEat.put(new Plants(),chanceToEatPlants);
        canEat.put(new Caterpillar(), chanceToEatCaterpillar);
    }

    public Duck(){
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
