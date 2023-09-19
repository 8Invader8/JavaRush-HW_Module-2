package island.animals;

import island.IslandFormOfLife;
import island.map.Island;

import java.util.ArrayList;
import java.util.Random;

public abstract class Animals implements IslandFormOfLife,Runnable {
    public static final Random RANDOM = new Random();
    public volatile static ArrayList<Animals> animalsOnOneField = new ArrayList<>();
    protected volatile static Island island;
    private String animalName;
    private volatile String animalIcon;
    private double weightOfAnimal;
    private int maxPopulationOnOneLocation;
    private int maxStepByMove;
    private volatile double maxKiloCanEat;
    private volatile double stomachFullness;
    private volatile boolean isAlive = true;
    private volatile int x;
    private volatile int y;


    public abstract boolean eat(IslandFormOfLife islandFormOfLife);
    public abstract void reproduce(Animals animals);
    public abstract void die(IslandFormOfLife islandFormOfLife);

    public static Island getIsland(){
        return island;
    }

    public static void setIsland(Island island){
        Animals.island = island;
    }

    public static ArrayList<Animals> getAnimalsOnOneField() {
        return animalsOnOneField;
    }

    public static void setAnimalsOnOneField(ArrayList<Animals> animalsOnOneField) {
        Animals.animalsOnOneField = animalsOnOneField;
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

    public double getStomachFullness() {
        return stomachFullness;
    }

    public void setStomachFullness(double stomachFullness) {
        this.stomachFullness = stomachFullness;
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


}
