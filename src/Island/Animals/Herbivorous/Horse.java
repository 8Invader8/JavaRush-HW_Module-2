package Island.Animals.Herbivorous;

import Island.IslandFormOfLife;
import Island.Plants;
import java.util.ArrayList;
import java.util.List;

public class Horse extends Herbivorous {
    private static final List<IslandFormOfLife> canEat = new ArrayList<>();
    private final int weightOfHorse = 400;
    private final int maxPopulationOnOneLocation = 20;
    private final int maxStepByMove = 4;
    private final double maxKiloCanEat = 60.0;
    private final int animalLowHealth = 10;
    private boolean isAlive = true;
    private int x;
    private int y;

    static {
        canEat.add(new Plants());
    }

    @Override
    public void eat() {
        super.eat();
    }

    @Override
    public void reproduce() {
        super.reproduce();
    }

    @Override
    public void move() {
        super.move();
    }

    @Override
    public void die() {
        super.die();
    }
}
