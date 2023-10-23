package core.animals;

import core.IslandFormOfLife;
import core.Island;

import java.util.Objects;
import java.util.Random;

public abstract class Animals implements IslandFormOfLife,Runnable {
    public static final Random RANDOM = new Random();
    public static volatile Island island = new Island();
    private String animalName;
    private volatile String animalIcon;
    private double weightOfAnimal;
    private int maxPopulationOnOneLocation;
    private int maxStepByMove;
    private volatile double maxKiloCanEat;
//    private volatile double stomachFullness;
    private volatile boolean isAlive = true;
    private volatile int x;
    private volatile int y;


    public abstract boolean eat(Animals animals);
    public abstract void reproduce(Animals animals);
    public abstract void die(IslandFormOfLife islandFormOfLife);

    public static Island getIsland(){
        return island;
    }

    public static void setIsland(Island island){
//       this.island = island;
       Animals.island = island;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public String getAnimalIcon() {
        return animalIcon;
    }

    public void setAnimalIcon(String animalIcon) {
        this.animalIcon = animalIcon;
    }

    public double getWeightOfAnimal() {
        return weightOfAnimal;
    }

    public void setWeightOfAnimal(double weightOfAnimal) {
        this.weightOfAnimal = weightOfAnimal;
    }

    public int getMaxPopulationOnOneLocation() {
        return maxPopulationOnOneLocation;
    }

    public void setMaxPopulationOnOneLocation(int maxPopulationOnOneLocation) {
        this.maxPopulationOnOneLocation = maxPopulationOnOneLocation;
    }

    public int getMaxStepByMove() {
        return maxStepByMove;
    }

    public void setMaxStepByMove(int maxStepByMove) {
        this.maxStepByMove = maxStepByMove;
    }

    public double getMaxKiloCanEat() {
        return maxKiloCanEat;
    }

    public void setMaxKiloCanEat(double maxKiloCanEat) {
        this.maxKiloCanEat = maxKiloCanEat;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animals)) return false;
        Animals animals = (Animals) o;
        return maxPopulationOnOneLocation == animals.maxPopulationOnOneLocation && maxStepByMove == animals.maxStepByMove && Double.compare(animals.maxKiloCanEat, maxKiloCanEat) == 0 && isAlive == animals.isAlive && Objects.equals(animalName, animals.animalName) && Objects.equals(animalIcon, animals.animalIcon);
    }

    @Override
    public int hashCode() {
        return Objects.hash(animalName, animalIcon, maxPopulationOnOneLocation, maxStepByMove, maxKiloCanEat, isAlive);
    }

    @Override
    public void run() {
        System.out.println("Thread 1");
    }
}
