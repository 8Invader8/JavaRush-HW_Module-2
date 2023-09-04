package Island.Animals.Herbivorous;

import Island.IslandFormOfLife;
import Island.Plants;
import java.util.ArrayList;
import java.util.List;

public class Caterpillar extends Herbivorous{
    private final double weightOfCaterpillar = 0.01;
    private final int maxPopulationOnOneLocation = 1000;
    private final int maxStepByMove = 0;
    private final double maxKiloCanEat = 0.0;
    private final List<IslandFormOfLife> canEat = new ArrayList<>();

    public void canEat(){
        canEat.add(new Plants());
    }
}
