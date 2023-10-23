package core.animals.herbivorous;


import core.IslandFormOfLife;
import core.Plants;
import core.animals.Animals;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Duck extends Herbivorous {
    private final Map<IslandFormOfLife, Integer> canEat = new HashMap<>();
    private final String animalName = "Duck";
    private final String animalIcon = "\uD83E\uDD86";
    private final double weightOfAnimal = 1.0;
    private final int maxPopulationOnOneLocation = 200;
    private final int maxStepByMove = 4;
    private final double maxKiloCanEat = 1.0;
//    private final double maxKiloCanEat = 0.15;
//    private final int animalLowHealth = 40;
    private final int chanceToEatCaterpillar = 90;
    private final int chanceToEatPlants = 100;
//    private double stomachFullness = 0.5;


    {
        canEat.put(new Plants(), chanceToEatPlants);
        canEat.put(new Caterpillar(), chanceToEatCaterpillar);
    }

    public Duck(){
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
    public boolean eat(Animals animals) {
        return false;
    }

    public boolean eat(IslandFormOfLife f) {
        Animals animals = (Animals) f;
        int chanceOfEat;
        System.out.println("Zero if " + animals);
        for (Map.Entry<IslandFormOfLife, Integer> entry : canEat.entrySet()) {
            if (entry.getKey().equals(animals)) {
                System.out.println("1.5 if " + entry.getKey() + " Animals: " + animals);
//        if (canEat.containsKey(animals)) {
                chanceOfEat = RANDOM.nextInt(100 + 1);
                System.out.println("Enter first if" + chanceOfEat + " " + canEat.get(animals));
                if (chanceOfEat <= canEat.get(animals)) {
                    System.out.println("Enter second if");
//                    stomachFullness += animals.getWeightOfAnimal()/2;
                    animals.setAlive(false);


                    Animals akey = animals;
                    Integer avalue = island.fields[getY()][getX()].getFieldHashMap().get(animals);


                    System.out.println(" We have animals : " + animals);
                    for (Map.Entry<IslandFormOfLife, Integer> entry1 : island.fields[this.getY()][this.getX()].getFieldHashMap().entrySet()){
                        System.out.println("Class: " + entry1.getKey() + " , Value: " + entry1.getValue());
                    }


                    island.fields[getY()][getX()].getFieldHashMap().put(
                            akey,
                            (avalue - 1)
//                            (island.fields[this.getY()][this.getX()].getFieldHashMap().get(animals) - 1)
                    );
                    System.out.println("Omnomnom Animal!");
                    return true;
                }
            }
        }
        return false;
    }



    public boolean eatPlant(IslandFormOfLife plant) {
        if(island.fields[this.getY()][this.getX()].getFieldHashMap().get(plant) > 0) {
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
    public synchronized void run(){
        setY(RANDOM.nextInt(island.getHeight()));
        setX(RANDOM.nextInt(island.getWidth()));

//        island.fields[getY()][getX()].getFieldHashMap().put(
//                this,
//                (island.fields[getY()][getX()].getFieldHashMap().get(this) + 1)
//        );
        while (isAlive()) {
            island.move(this);

            for(Map.Entry<IslandFormOfLife, Integer> entry : island.fields[getY()][getX()].getFieldHashMap().entrySet()) {
                if (Objects.equals(entry.getKey().getClass(), Plants.class)){
                    this.eatPlant(entry.getKey());
                }else {
                    this.eat(entry.getKey());
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
