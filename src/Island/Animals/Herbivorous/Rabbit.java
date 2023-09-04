package Island.Animals.Herbivorous;


import Island.IslandFormOfLife;
import Island.Plants;
import java.util.ArrayList;
import java.util.List;

public class Rabbit extends Herbivorous {
    private final int weightOfRabbit = 2;
    private final int maxPopulationOnOneLocation = 150;
    private final int maxStepByMove = 2;
    private final double maxKiloCanEat = 0.45;
    private final List<IslandFormOfLife> canEat = new ArrayList<>();

    public void canEat(){
        canEat.add(new Plants());
    }
}
