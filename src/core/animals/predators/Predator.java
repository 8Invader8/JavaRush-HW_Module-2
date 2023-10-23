package core.animals.predators;

import core.animals.Animals;

public abstract class Predator extends Animals {
    private String animalName;
    private String animalIcon;
    private double weightOfAnimal;
    private double maxKiloCanEat;

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
}
