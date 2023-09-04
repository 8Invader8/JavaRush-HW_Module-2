package Island.Animals.Predators;


import Island.Animals.Herbivorous.Caterpillar;
import Island.Animals.Herbivorous.Duck;
import Island.Animals.Herbivorous.Mouse;
import Island.Animals.Herbivorous.Rabbit;
import Island.IslandFormOfLife;
import java.util.ArrayList;
import java.util.List;

public class Fox extends Predator {
    private final int weightOfFox = 8;
    private final int maxPopulationOnOneLocation = 30;
    private final int maxStepByMove = 2;
    private final double maxKiloCanEat = 2.0;
    private final List<IslandFormOfLife> canEat = new ArrayList<>();

    public void canEat(){
        canEat.add(new Caterpillar());
        canEat.add(new Mouse());
        canEat.add(new Rabbit());
        canEat.add(new Duck());
    }

}
