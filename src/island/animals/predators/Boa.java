package island.animals.predators;


import island.animals.Animals;
import island.animals.herbivorous.Duck;
import island.animals.herbivorous.Mouse;
import island.animals.herbivorous.Rabbit;
import island.IslandFormOfLife;
import java.util.HashMap;
import java.util.Map;

public class Boa extends Predator {
    private static final Map<IslandFormOfLife, Integer> canEat = new HashMap<>();
    private final String animalIcon = "\uD83D\uDC0D";
    private final String animalName = "Boa";
    private final double weightOfAnimal = 15.0;
    private final int maxPopulationOnOneLocation = 30;
    private final int maxStepByMove = 1;
    private final double maxKiloCanEat = 3.0;
    private final int animalLowHealth = 2;
    private double stomachFullness = 7.0;
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
