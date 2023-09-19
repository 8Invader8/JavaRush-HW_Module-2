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
            if(!(animalsOnOneField.size() >= maxPopulationOnOneLocation)) {
                animalsOnOneField.add(new Bear());
            }
        }
    }


    public void die(IslandFormOfLife islandFormOfLife){
        if(weightOfAnimal == 0){
            animalsOnOneField.remove(islandFormOfLife);
        }
    }

    @Override
    public void run(){
        setY(RANDOM.nextInt(island.getHeight()));
        setX(RANDOM.nextInt(island.getWidth()));

        island.fields[getY()][getX()].animalsOnOneField.add(this);
        while (isAlive()) {
            island.move(this);

            for (Plants plant : island.fields[getY()][getX()].plantsOnOneField) {
                this.eat(plant);
            }

            for (Animals animal : island.fields[getY()][getX()].animalsOnOneField) {
                this.reproduce(animal);
            }

            die(this);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                throw new RuntimeException("Thread was interrupted!");
            }
        }
    }
}
