package island;


import island.animals.Animals;
import island.animals.herbivorous.*;
import island.animals.predators.*;
import island.map.Field;
import island.map.Island;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class FirstInitialize {
    protected volatile Island island = new Island();
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
    private final int width = 20;
    private final int height = 100;
    protected volatile Field[][] fields = new Field[height][width];


    {
        for (int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                fields[i][j] = new Field();
                fields[i][j].getFieldHashMap().put(new Boar(),countOfBoars);
                fields[i][j].getFieldHashMap().put(new Buffalo(),countOfBuffaloes);
                fields[i][j].getFieldHashMap().put(new Caterpillar(),countOfCaterpillars);
                fields[i][j].getFieldHashMap().put(new Deer(),countOfDeer);
                fields[i][j].getFieldHashMap().put(new Duck(),countOfDucks);
                fields[i][j].getFieldHashMap().put(new Goat(),countOfGoats);
                fields[i][j].getFieldHashMap().put(new Horse(),countOfHorses);
                fields[i][j].getFieldHashMap().put(new Mouse(),countOfMouses);
                fields[i][j].getFieldHashMap().put(new Rabbit(),countOfRabbits);
                fields[i][j].getFieldHashMap().put(new Sheep(),countOfSheep);
                fields[i][j].getFieldHashMap().put(new Bear(),countOfBear);
                fields[i][j].getFieldHashMap().put(new Boa(),countOfBoas);
                fields[i][j].getFieldHashMap().put(new Eagle(),countOfEagles);
                fields[i][j].getFieldHashMap().put(new Fox(),countOfFoxes);
                fields[i][j].getFieldHashMap().put(new Wolf(),countOfWolfs);
                fields[i][j].getFieldHashMap().put(new Plants(),countOfPlants);
            }
        }


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
