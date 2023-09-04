package Island.Animals.Herbivorous;


import Island.IslandFormOfLife;
import Island.Plants;
import java.util.ArrayList;
import java.util.List;

public class Mouse extends Herbivorous  {
    private final double weightOfMouse = 0.05;
    private final int maxPopulationOnOneLocation = 500;
    private final int maxStepByMove = 1;
    private final double maxKiloCanEat = 0.01;
    private final List<IslandFormOfLife> canEat = new ArrayList<>();

    public void canEat(){
        canEat.add(new Plants());
        canEat.add(new Caterpillar());
    }
}
