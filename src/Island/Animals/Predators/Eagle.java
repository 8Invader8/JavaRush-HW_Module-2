package Island.Animals.Predators;


import Island.Animals.Herbivorous.Duck;
import Island.Animals.Herbivorous.Mouse;
import Island.Animals.Herbivorous.Rabbit;
import Island.IslandFormOfLife;
import java.util.ArrayList;
import java.util.List;

public class Eagle extends Predator {
    private final int weightOfEagle = 6;
    private final int maxPopulationOnOneLocation = 20;
    private final int maxStepByMove = 3;
    private final double maxKiloCanEat = 1.0;
    private final List<IslandFormOfLife> canEat = new ArrayList<>();

    public void canEat(){
        canEat.add(new Fox());
        canEat.add(new Mouse());
        canEat.add(new Rabbit());
        canEat.add(new Duck());
    }
}
