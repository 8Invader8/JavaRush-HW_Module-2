package Island.Animals.Predators;


import Island.Animals.Herbivorous.*;
import Island.IslandFormOfLife;
import java.util.ArrayList;
import java.util.List;

public class Wolf  extends Predator{
    private final int weightOfWolf = 50;
    private final int maxPopulationOnOneLocation = 30;
    private final int maxStepByMove = 3;
    private final double maxKiloCanEat = 8.0;
    private final List<IslandFormOfLife> canEat = new ArrayList<>();

    public void canEat(){
        canEat.add(new Horse());
        canEat.add(new Deer());
        canEat.add(new Rabbit());
        canEat.add(new Mouse());
        canEat.add(new Goat());
        canEat.add(new Sheep());
        canEat.add(new Boar());
        canEat.add(new Buffalo());
        canEat.add(new Duck());
    }
}
