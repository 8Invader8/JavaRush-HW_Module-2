package island;


import island.animals.Animals;
import island.animals.herbivorous.*;
import island.animals.predators.*;
import island.map.Island;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class FirstInitialize {
    protected volatile Island island = new Island();
    protected volatile Map<IslandFormOfLife, Integer> availableFormOfLife = new HashMap<>();
    private int countOfBoars = 1;
    private int countOfBuffaloes = 1;
    private int countOfCaterpillars = 1;
    private int countOfDeer = 1;
    private int countOfDucks = 1;
    private int countOfGoats = 1;
    private int countOfHorses = 1;
    private int countOfMouses = 1;
    private int countOfRabbits = 1;
    private int countOfSheep = 1;
    private int countOfBear = 1;
    private int countOfBoas = 1;
    private int countOfEagles = 1;
    private int countOfFoxes = 1;
    private int countOfWolfs = 1;
    private int countOfPlants = 200;
//    public volatile ArrayList<Animals> animalsOnOneField;
//    public volatile ArrayList<Plants> plantsOnOneField;

    {

        availableFormOfLife.put(new Boar(), countOfBoars);
        availableFormOfLife.put(new Buffalo(), countOfBuffaloes);
        availableFormOfLife.put(new Caterpillar(), countOfCaterpillars);
        availableFormOfLife.put(new Deer(), countOfDeer);
        availableFormOfLife.put(new Duck(), countOfDucks);
        availableFormOfLife.put(new Goat(), countOfGoats);
        availableFormOfLife.put(new Horse(), countOfHorses);
        availableFormOfLife.put(new Mouse(), countOfMouses);
        availableFormOfLife.put(new Rabbit(), countOfRabbits);
        availableFormOfLife.put(new Sheep(), countOfSheep);
        availableFormOfLife.put(new Bear(), countOfBear);
        availableFormOfLife.put(new Boa(), countOfBoas);
        availableFormOfLife.put(new Eagle(), countOfEagles);
        availableFormOfLife.put(new Fox(), countOfFoxes);
        availableFormOfLife.put(new Wolf(), countOfWolfs);
        availableFormOfLife.put(new Plants(), countOfPlants);
//

//        animalsOnOneField.add(new Boar());
//        animalsOnOneField.add(new Buffalo());
//        animalsOnOneField.add(new Caterpillar());
//        animalsOnOneField.add(new Deer());
//        animalsOnOneField.add(new Duck());
//        animalsOnOneField.add(new Goat());
//        animalsOnOneField.add(new Horse());
//        animalsOnOneField.add(new Mouse());
//        animalsOnOneField.add(new Rabbit());
//        animalsOnOneField.add(new Sheep());
//        animalsOnOneField.add(new Bear());
//        animalsOnOneField.add(new Boa());
//        animalsOnOneField.add(new Eagle());
//        animalsOnOneField.add(new Fox());
//        animalsOnOneField.add(new Wolf());
//        for(int i = 0; i < Plants.getMaxPopulationOnOneLocation();i++){
//            plantsOnOneField.add(new Plants());
//        }


    }
    public void start() {

        for(int i = 0; i < island.fields.length; i++){
            for(int j = 0; j < island.fields[i].length; j++){

//                island.fields[i][j].setAnimalsOnOneField(animalsOnOneField);
//                island.fields[i][j].setPlantsOnOneField(plantsOnOneField);
                for(Map.Entry<IslandFormOfLife, Integer> entry : availableFormOfLife.entrySet()){
                    if (entry instanceof Animals) {
                        island.fields[i][j].animalsOnOneField.add((Animals) entry.getKey());
                    } else if (entry instanceof Plants) {
                        island.fields[i][j].plantsOnOneField.add((Plants) entry.getKey());
                    }
                }
            }
        }

    }
}
