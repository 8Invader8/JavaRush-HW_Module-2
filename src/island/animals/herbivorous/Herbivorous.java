package island.animals.herbivorous;

import island.Plants;
import island.animals.Animals;


public abstract class Herbivorous extends Animals {

    private String animalName;
    private String animalIcon;
    private double weightOfAnimal;
    private int maxStepByMove;
    private double maxKiloCanEat;
    private double stomachFullness;

    public boolean eat(Plants plant) {
        if(getStomachFullness() < maxKiloCanEat){
            if(plant.isAlive()){
                setStomachFullness(getStomachFullness() + plant.getWeightOfPlants());
                plant.setAlive(false);
                return true;
            }
        }
        return false;
    }
}
