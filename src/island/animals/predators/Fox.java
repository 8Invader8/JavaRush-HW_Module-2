package island.animals.predators;


import island.animals.Animals;
import island.animals.herbivorous.Caterpillar;
import island.animals.herbivorous.Duck;
import island.animals.herbivorous.Mouse;
import island.animals.herbivorous.Rabbit;
import island.IslandFormOfLife;
import java.util.HashMap;
import java.util.Map;

public class Fox extends Predator {
    private static final Map<IslandFormOfLife, Integer> canEat = new HashMap<>();
    private final String animalIcon = "\uD83E\uDD8A";
    private final String animalName = "Fox";
    private final double weightOfAnimal = 8.0;
    private final int maxPopulationOnOneLocation = 30;
    private final int maxStepByMove = 2;
    private final double maxKiloCanEat = 2.0;
    private final int animalLowHealth = 1;
    private double stomachFullness = 4.0;
    private final int chanceToKillCaterpillar = 40;
    private final int chanceToKillRabbit = 70;
    private final int chanceToKillMouse = 90;
    private final int chanceToKillDuck = 60;


    {
        canEat.put(new Caterpillar(), chanceToKillCaterpillar);
        canEat.put(new Mouse(), chanceToKillMouse);
        canEat.put(new Rabbit(), chanceToKillRabbit);
        canEat.put(new Duck(), chanceToKillDuck);
    }

    public Fox(){
        setAnimalName(animalName);
        setAnimalIcon(animalIcon);
        setWeightOfAnimal(weightOfAnimal);
        setMaxStepByMove(maxStepByMove);
        setMaxKiloCanEat(maxKiloCanEat);
        setStomachFullness(stomachFullness);
    }

    public boolean eat(Animals islandFormOfLife){
        int chanceOfEat;
        if(stomachFullness < maxKiloCanEat) {
            if (canEat.containsKey(islandFormOfLife)) {
                chanceOfEat = RANDOM.nextInt(0,100 + 1);
                if (chanceOfEat >= canEat.get(islandFormOfLife)) {
                    stomachFullness += islandFormOfLife.getWeightOfAnimal()/2;
                    islandFormOfLife.setAlive(false);
                    return true;
                }
            }
        }
        return false;
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
        if(weightOfAnimal == animalLowHealth){
            animalsOnField.remove(islandFormOfLife);
        }
    }
}
