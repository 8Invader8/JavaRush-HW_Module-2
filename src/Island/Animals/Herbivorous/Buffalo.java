package Island.Animals.Herbivorous;


import Island.IslandFormOfLife;
import Island.Plants;
import java.util.ArrayList;
import java.util.List;

public class Buffalo extends Herbivorous{
    private final int weightOfBuffalo = 700;
    private final int maxPopulationOnOneLocation = 10;
    private final int maxStepByMove = 3;
    private final double maxKiloCanEat = 100.0;
    private final List<IslandFormOfLife> canEat = new ArrayList<>();

    public void canEat(){
        canEat.add(new Plants());
    }
}
