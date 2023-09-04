package Island.Animals.Herbivorous;


import Island.IslandFormOfLife;
import Island.Plants;
import java.util.ArrayList;
import java.util.List;

public class Sheep extends Herbivorous {
    private final int weightOfSheep = 70;
    private final int maxPopulationOnOneLocation = 140;
    private final int maxStepByMove = 3;
    private final double maxKiloCanEat = 15.0;
    private final List<IslandFormOfLife> canEat = new ArrayList<>();

    public void canEat(){
        canEat.add(new Plants());
    }
}
