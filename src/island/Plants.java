package island;


import java.util.ArrayList;

public class Plants implements IslandFormOfLife {
    protected static ArrayList<Plants> growPlants = new ArrayList<>();
    private final String nameOfPlant = "Grass";
    private final int weightOfPlants = 1;
    private final int maxPopulationOnOneLocation = 200;
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

    public int getMaxPopulationOnOneLocation() {
        return maxPopulationOnOneLocation;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }
}
