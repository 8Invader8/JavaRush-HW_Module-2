package island.animals.predators;


import island.animals.Animals;
import island.animals.herbivorous.Duck;
import island.animals.herbivorous.Mouse;
import island.animals.herbivorous.Rabbit;
import island.IslandFormOfLife;
import java.util.HashMap;
import java.util.Map;

public class Eagle extends Predator {
    private static final Map<IslandFormOfLife, Integer> canEat = new HashMap<>();
    private final String animalIcon = "\uD83E\uDD85";
    private final String animalName = "Eagle";
    private final double weightOfAnimal = 6.0;
    private final int maxPopulationOnOneLocation = 20;
    private final int maxStepByMove = 3;
    private final double maxKiloCanEat = 1.0;
    private final int animalLowHealth = 1;
    private double stomachFullness = 1.0;
    private final int chanceToKillFox = 10;
    private final int chanceToKillRabbit = 90;
    private final int chanceToKillMouse = 90;
    private final int chanceToKillDuck = 80;



    {
        canEat.put(new Fox(),chanceToKillFox);
        canEat.put(new Mouse(), chanceToKillMouse);
        canEat.put(new Rabbit(), chanceToKillRabbit);
        canEat.put(new Duck(), chanceToKillDuck);
    }

    public Eagle(){
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
