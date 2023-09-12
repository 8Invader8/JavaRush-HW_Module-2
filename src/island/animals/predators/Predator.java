package island.animals.predators;

import island.IslandFormOfLife;
import island.animals.Animals;

import java.util.ArrayList;

public abstract class Predator extends Animals {
    private String animalName;
    private String animalIcon;
    private double weightOfAnimal;
    private double maxKiloCanEat;
    private double stomachFullness;

    @Override
    public String getAnimalName() {
        return animalName;
    }

    @Override
    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    @Override
    public String getAnimalIcon() {
        return animalIcon;
    }

    @Override
    public void setAnimalIcon(String animalIcon) {
        this.animalIcon = animalIcon;
    }

    @Override
    public double getWeightOfAnimal() {
        return weightOfAnimal;
    }

    @Override
    public void setWeightOfAnimal(double weightOfAnimal) {
        this.weightOfAnimal = weightOfAnimal;
    }

    @Override
    public double getMaxKiloCanEat() {
        return maxKiloCanEat;
    }

    @Override
    public void setMaxKiloCanEat(double maxKiloCanEat) {
        this.maxKiloCanEat = maxKiloCanEat;
    }

    @Override
    public double getStomachFullness() {
        return stomachFullness;
    }

    @Override
    public void setStomachFullness(double stomachFullness) {
        this.stomachFullness = stomachFullness;
    }
}
