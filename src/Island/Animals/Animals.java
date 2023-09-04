package Island.Animals;

import Island.IslandFormOfLife;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public abstract class Animals implements IslandFormOfLife,Runnable {
    public static final Random RANDOM = new Random();
    private Map<IslandFormOfLife, Integer> canEat;
    private ArrayList<Animals> listOfAnimals;
    private String animalName;
    private double weightOfAnimal;
    private int maxPopulationOnOneLocation;
    private int maxStepByMove;
    private double maxKiloCanEat;
    private boolean isAlive = true;
    private int x;
    private int y;


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

    public Map<IslandFormOfLife, Integer> getCanEat() {
        return canEat;
    }

    public ArrayList<Animals> getListOfAnimals() {
        return listOfAnimals;
    }

    public void setListOfAnimals(ArrayList<Animals> listOfAnimals) {
        this.listOfAnimals = listOfAnimals;
    }

    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
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
    public abstract void eat();
    public abstract void reproduce();
    public abstract void move();
    public abstract void die();
    @Override
    public void run() {

    }
}
