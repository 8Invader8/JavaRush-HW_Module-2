package island.animals.herbivorous;

import island.IslandFormOfLife;
import island.Plants;
import island.animals.Animals;
import island.animals.predators.Bear;

public class Caterpillar extends Herbivorous{
    private final String animalName = "Caterpillar";
    private final String animalIcon = "\uD83D\uDC1B";
    private final double weightOfAnimal = 0.01;
    private final int maxPopulationOnOneLocation = 1000;
    private final int maxStepByMove = 0;
    private final double maxKiloCanEat = 0.0;
    private double stomachFullness = 350.0;




    public Caterpillar(){
        setAnimalName(animalName);
        setAnimalIcon(animalIcon);
        setWeightOfAnimal(weightOfAnimal);
        setMaxKiloCanEat(maxKiloCanEat);
        setStomachFullness(stomachFullness);
        setMaxStepByMove(maxStepByMove);
    }

    @Override
    public boolean eat(Plants plant) {
        super.eat(plant);
        return true;
    }

    @Override
    public boolean eat(IslandFormOfLife islandFormOfLife) {
        return false;
    }

    @Override
    public void reproduce(Animals animals) {
        int chanceOfReproduce = RANDOM.nextInt(2);
        if(chanceOfReproduce == 1){
            if(!(animalsOnField.size() >= maxPopulationOnOneLocation)) {
                animalsOnField.add(new Bear());
            }
        }
    }


    public void die(IslandFormOfLife islandFormOfLife){
        if(weightOfAnimal == 0){
            animalsOnField.remove(islandFormOfLife);
        }
    }
}
