package Island.Animals.Predators;


import Island.Animals.Animals;
import Island.Animals.Herbivorous.*;
import Island.IslandFormOfLife;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Bear extends Predator {
    private static final Map<IslandFormOfLife, Integer> canEat = new HashMap<>();
    private final String animalName = "Bear";
    private final int weightOfBear = 500;
    private final int maxPopulationOnOneLocation = 5;
    private final int maxStepByMove = 2;
    private final double maxKiloCanEat = 80.0;
    private ArrayList<Animals> listOfAnimals = new ArrayList<>();
    private final int animalLowHealth = 10;
    private boolean isAlive = true;
    private int x;
    private int y;

    static {

        canEat.put(new Boa(),80);
        canEat.put(new Horse(),40);
        canEat.put(new Deer(),80);
        canEat.put(new Rabbit(),80);
        canEat.put(new Mouse(),90);
        canEat.put(new Goat(),70);
        canEat.put(new Sheep(),70);
        canEat.put(new Buffalo(),20);
        canEat.put(new Duck(),10);

    }


    public Bear(){
        setAnimalName(animalName);
        setWeightOfAnimal(weightOfBear);
        setMaxPopulationOnOneLocation(maxPopulationOnOneLocation);
        setMaxStepByMove(maxStepByMove);
        setMaxKiloCanEat(maxKiloCanEat);
        setListOfAnimals(listOfAnimals);

    }

    @Override
    public String getAnimalName() {
        return animalName;
    }

    public int getWeightOfBear() {
        return weightOfBear;
    }

    @Override
    public int getMaxPopulationOnOneLocation() {
        return maxPopulationOnOneLocation;
    }

    @Override
    public int getMaxStepByMove() {
        return maxStepByMove;
    }

    @Override
    public double getMaxKiloCanEat() {
        return maxKiloCanEat;
    }

    @Override
    public ArrayList<Animals> getListOfAnimals() {
        return listOfAnimals;
    }

    @Override
    public void setListOfAnimals(ArrayList<Animals> listOfAnimals) {
        this.listOfAnimals = listOfAnimals;
    }

    public int getAnimalLowHealth() {
        return animalLowHealth;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int y) {
        this.y = y;
    }

    public boolean eat(IslandFormOfLife islandFormOfLife){
        int chanceOfEat;
        if(canEat.containsKey(islandFormOfLife)){
            chanceOfEat = RANDOM.nextInt(canEat.get(islandFormOfLife)) + 1 ;
            if(chanceOfEat >= canEat.get(islandFormOfLife)/2){
                return true;
            }
        }
        return false;
    }

    @Override
    public void reproduce() {
        int chanceOfReproduce = RANDOM.nextInt(2);
        if(chanceOfReproduce == 1){
            if(!(listOfAnimals.size() >= maxPopulationOnOneLocation)) {
                listOfAnimals.add(new Bear());
            }
        }
    }

    public void move(Animals animals) {
        int x = animals.getX();
        int y = animals.getY();
        int step = RANDOM.nextInt(maxStepByMove + 1);

        while(step > 0){
            int direction = RANDOM.nextInt(5);
            switch (direction) {
                case 1:
                    y += 1;
                    step--;
                case 2:
                    x += 1;
                    step--;
                case 3:
                    y -= 1;
                    step--;
                case 4:
                    x -= 1;
                    step--;
            }
        }
    }

    public void die(Animals animals){
        if(weightOfBear == animalLowHealth){
            listOfAnimals.remove(animals);
        }
    }
}
