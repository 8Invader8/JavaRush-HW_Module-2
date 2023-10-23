package core.animals.predators;


import core.IslandFormOfLife;
import core.animals.Animals;
import core.animals.herbivorous.Duck;
import core.animals.herbivorous.Mouse;
import core.animals.herbivorous.Rabbit;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Boa extends Predator {
    private static final Map<IslandFormOfLife, Integer> canEat = new HashMap<>();
    private final String animalIcon = "\uD83D\uDC0D";
    private final String animalName = "Boa";
    private final double weightOfAnimal = 15.0;
    private final int maxPopulationOnOneLocation = 30;
    private final int maxStepByMove = 1;
    private final double maxKiloCanEat = 3.0;
//    private final int animalLowHealth = 2;
//    private double stomachFullness = 7.0;
    private final int chanceToKillFox = 15;
    private final int chanceToKillRabbit = 20;
    private final int chanceToKillMouse = 40;
    private final int chanceToKillDuck = 10;



    {
        canEat.put(new Fox(), chanceToKillFox);
        canEat.put(new Mouse(), chanceToKillRabbit);
        canEat.put(new Rabbit(), chanceToKillMouse);
        canEat.put(new Duck(), chanceToKillDuck);
    }

    public Boa(){
        setAnimalName(animalName);
        setAnimalIcon(animalIcon);
        setWeightOfAnimal(weightOfAnimal);
        setMaxStepByMove(maxStepByMove);
        setMaxKiloCanEat(maxKiloCanEat);
    }
//    protected void getHungry(){
//        double hungry = getMaxKiloCanEat()/10;
//        setStomachFullness(getStomachFullness() - hungry);
//    }
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
