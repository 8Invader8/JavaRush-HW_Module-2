package island;


import java.util.ArrayList;

public class Plants implements IslandFormOfLife, Runnable {
    public static ArrayList<Plants> growPlants = new ArrayList<>();
    private final String nameOfPlant = "Grass";
    private final int weightOfPlants = 1;
    private static final int MAX_POPULATION_ON_ONE_LOCATION = 200;
    private boolean isAlive = true;


    public static ArrayList<Plants> getGrowPlants() {
        return growPlants;
    }

    public static void setGrowPlants(ArrayList<Plants> growPlants) {
        Plants.growPlants = growPlants;
    }

    public String getNameOfPlant() {
        return nameOfPlant;
    }

    public int getWeightOfPlants() {
        return weightOfPlants;
    }

    public static int getMaxPopulationOnOneLocation() {
        return MAX_POPULATION_ON_ONE_LOCATION;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public void run() {

    }
}
