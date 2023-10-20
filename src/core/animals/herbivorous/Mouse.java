package core.animals.herbivorous;

import core.IslandFormOfLife;
import core.Plants;
import core.animals.Animals;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Mouse extends Herbivorous  {
    private final Map<IslandFormOfLife, Integer> canEat = new HashMap<>();
    private final String animalName = "Mouse";
    private final String animalIcon = "\uD83D\uDC01";
    private final double weightOfAnimal = 0.05;
    private final int maxPopulationOnOneLocation = 500;
    private final int maxStepByMove = 1;
    private final double maxKiloCanEat = 0.01;
//    private final int animalLowHealth = 40;
    private final int chanceToEatCaterpillar = 90;
    private final int chanceToEatPlants = 100;
//    private double stomachFullness = 0.005;


    {
        canEat.put(new Plants(), chanceToEatPlants);
        canEat.put(new Caterpillar(), chanceToEatCaterpillar);
    }

    public Mouse(){
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
    @Override
    public boolean eat(Animals animals){
        int chanceOfEat;
        if (canEat.containsKey(animals)) {
            chanceOfEat = RANDOM.nextInt(100 + 1);
            if (chanceOfEat >= canEat.get(animals)) {
//                    stomachFullness += animals.getWeightOfAnimal()/2;
                animals.setAlive(false);
                island.fields[animals.getY()][animals.getX()].getFieldHashMap().put(
                        animals,
                        (island.fields[animals.getY()][animals.getX()].getFieldHashMap().get(animals) - 1)
                );
                return true;
            }
        }
        return false;
    }


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
                if (Objects.equals(entry.getKey().getClass(), Animals.class)){
                    this.eat((Animals) entry.getKey());
                }
            }

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
