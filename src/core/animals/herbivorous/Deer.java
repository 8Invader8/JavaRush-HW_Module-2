package core.animals.herbivorous;


import core.IslandFormOfLife;
import core.Plants;
import core.animals.Animals;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Deer extends Herbivorous{
    private final Map<IslandFormOfLife, Integer> canEat = new HashMap<>();
    private final String animalName = "Deer";
    private final String animalIcon = "\uD83E\uDD8C";
    private final double weightOfAnimal = 300.0;
    private final int maxPopulationOnOneLocation = 20;
    private final int maxStepByMove = 4;
    private final double maxKiloCanEat = 50.0;
//    private final int animalLowHealth = 30;
    private final int chanceToEatPlants = 100;
//    private double stomachFullness = 150.0;


    {
        canEat.put(new Plants(), chanceToEatPlants);
    }

    public Deer(){
        setAnimalName(animalName);
        setAnimalIcon(animalIcon);
        setWeightOfAnimal(weightOfAnimal);
        setMaxKiloCanEat(maxKiloCanEat);
        setMaxStepByMove(maxStepByMove);
    }
//    protected void getHungry(){
//        double hungry = getMaxKiloCanEat()/10;
//        setStomachFullness(getStomachFullness() - hungry);
//    }

    public boolean eat(Plants plant) {
        if(island.fields[this.getY()][this.getX()].getFieldHashMap().get(Plants.class) > 0) {
            island.fields[this.getY()][this.getX()].getFieldHashMap().put(
                    plant,
                    (island.fields[this.getY()][this.getX()].getFieldHashMap().get(plant) - 1)
            );
            return true;
        }
        return false;
    }

    @Override
    public boolean eat(Animals animals) {
        return false;
    }

    @Override
    public void reproduce(Animals animals) {
        HashMap<IslandFormOfLife, Integer> localField = island.fields[animals.getY()][animals.getX()].getFieldHashMap();
        int chanceOfReproduce = RANDOM.nextInt(2);
        if(chanceOfReproduce == 1){
            if(!(localField.get(animals) >= maxPopulationOnOneLocation)) {
                localField.put(animals, localField.get(animals) + 1);
            }
        }
    }


    public void die(IslandFormOfLife islandFormOfLife){

    }

    public void die(Animals animals){
        int chanceToDie = RANDOM.nextInt(2);
        if (chanceToDie == 1){
            island.fields[animals.getY()][animals.getX()].getFieldHashMap().put(
                    animals,
                    island.fields[animals.getY()][animals.getX()].getFieldHashMap().get(animals) - 1
            );
        }
//        if(weightOfAnimal == animalLowHealth){
//            island.fields[animals.getY()][animals.getX()].getFieldHashMap().put(animals,
//                    island.fields[animals.getY()][animals.getX()].getFieldHashMap().get(animals) - 1);
//        }
    }
    @Override
    public void run(){
        setY(RANDOM.nextInt(island.getHeight()));
        setX(RANDOM.nextInt(island.getWidth()));

        island.fields[getY()][getX()].getFieldHashMap().put(
                this,
                (island.fields[getY()][getX()].getFieldHashMap().get(this) + 1)
        );
        while (isAlive()) {
            island.move(this);

            for(Map.Entry<IslandFormOfLife, Integer> entry : island.fields[getY()][getX()].getFieldHashMap().entrySet()) {
                if (Objects.equals(entry.getKey().getClass(), Plants.class)){
                    this.eat((Plants) entry.getKey());
                }
            }

            for(Map.Entry<IslandFormOfLife, Integer> entry : island.fields[getY()][getX()].getFieldHashMap().entrySet()) {
                if (Objects.equals(entry.getKey().getClass(), Animals.class)) {
                    this.reproduce((Animals) entry.getKey());
                }
            }


//            getHungry();
            die(this);

            try{
                Thread.sleep(3000);
            }catch (InterruptedException e){
                throw new RuntimeException("Thread was interrupted!");
            }
        }
    }
}
