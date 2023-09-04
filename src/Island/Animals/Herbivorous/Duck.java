package Island.Animals.Herbivorous;

import Island.IslandFormOfLife;
import Island.Plants;
import java.util.ArrayList;
import java.util.List;

public class Duck extends Herbivorous {
    private final int weightOfDuck = 1;
    private final int maxPopulationOnOneLocation = 200;
    private final int maxStepByMove = 4;
    private final double maxKiloCanEat = 0.15;
    private final List<IslandFormOfLife> canEat = new ArrayList<>();

    public void canEat(){
        canEat.add(new Plants());
        canEat.add(new Caterpillar());
    }
}
