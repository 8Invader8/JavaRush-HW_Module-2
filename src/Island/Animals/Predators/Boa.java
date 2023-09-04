package Island.Animals.Predators;


import Island.Animals.Animals;
import Island.Animals.Herbivorous.Duck;
import Island.Animals.Herbivorous.Mouse;
import Island.Animals.Herbivorous.Rabbit;
import Island.IslandFormOfLife;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Boa extends Predator {
    private final int weightOfBoa = 15;
    private final int maxPopulationOnOneLocation = 30;
    private final int maxStepByMove = 1;
    private final double maxKiloCanEat = 3.0;
    private final List<IslandFormOfLife> canEat = new ArrayList<>();


    public void canEat(){
        canEat.add(new Fox());
        canEat.add(new Mouse());
        canEat.add(new Rabbit());
        canEat.add(new Duck());
    }
}
