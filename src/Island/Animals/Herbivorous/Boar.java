package Island.Animals.Herbivorous;

import Island.IslandFormOfLife;
import Island.Plants;
import java.util.ArrayList;
import java.util.List;

public class Boar extends Herbivorous {
    private final int weightOfBoar = 400;
    private final int maxPopulationOnOneLocation = 50;
    private final int maxStepByMove = 2;
    private final double maxKiloCanEat = 50.0;
    private final List<IslandFormOfLife> canEat = new ArrayList<>();

    public void canEat(){
        canEat.add(new Mouse());
        canEat.add(new Caterpillar());
        canEat.add(new Plants());
    }
}
