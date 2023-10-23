package core;


import core.animals.Animals;
import core.animals.herbivorous.*;
import core.animals.predators.*;
import core.map.Field;

import java.util.*;

public class Island {

    private final String nameOfIsland = "Paradise";
    private final static int width = 5;
    private final static int height = 10;
    private final int UP = 1;
    private final int RIGHT = 2;
    private final int DOWN = 3;
    private final int LEFT = 4;
    public static volatile Field[][] fields = new Field[height][width];
    private static int countOfBoars = 1;
    private static int countOfBuffaloes = 1;
    private static int countOfCaterpillars = 10;
    private static int countOfDeer = 1;
    private static int countOfDucks = 1;
    private static int countOfGoats = 1;
    private static int countOfHorses = 1;
    private static int countOfMouses = 1;
    private static int countOfRabbits = 1;
    private static int countOfSheep = 1;
    private static int countOfBear = 1;
    private static int countOfBoas = 1;
    private static int countOfEagles = 1;
    private static int countOfFoxes = 1;
    private static int countOfWolfs = 1;
    private static int countOfPlants = 200;


    static  {

        for(int i = 0; i < fields.length; i++) {
            for (int j = 0; j < fields[i].length; j++) {
                fields[i][j] = new Field();
            }
        }
        for(int i = 0; i < fields.length; i++){
            for(int j = 0; j < fields[i].length; j++){

//                fields[i][j].getFieldHashMap().put(new Boar(), countOfBoars);
//                fields[i][j].getFieldHashMap().put(new Buffalo(), countOfBuffaloes);
                fields[i][j].getFieldHashMap().put(new Caterpillar(), countOfCaterpillars);
//                fields[i][j].getFieldHashMap().put(new Deer(), countOfDeer);
                fields[i][j].getFieldHashMap().put(new Duck(), countOfDucks);
//                fields[i][j].getFieldHashMap().put(new Goat(), countOfGoats);
//                fields[i][j].getFieldHashMap().put(new Horse(), countOfHorses);
//                fields[i][j].getFieldHashMap().put(new Mouse(), countOfMouses);
//                fields[i][j].getFieldHashMap().put(new Rabbit(), countOfRabbits);
//                fields[i][j].getFieldHashMap().put(new Sheep(), countOfSheep);
//                fields[i][j].getFieldHashMap().put(new Bear(), countOfBear);
//                fields[i][j].getFieldHashMap().put(new Boa(), countOfBoas);
//                fields[i][j].getFieldHashMap().put(new Eagle(), countOfEagles);
//                fields[i][j].getFieldHashMap().put(new Fox(), countOfFoxes);
//                fields[i][j].getFieldHashMap().put(new Wolf(), countOfWolfs);
                fields[i][j].getFieldHashMap().put(new Plants(), countOfPlants);
            }
        }

    }

    public String getNameOfIsland() {
        return nameOfIsland;
    }

    public static int getWidth() {
        return width;
    }

    public static int getHeight() {
        return height;
    }

    public Field[][] getFields() {
        return fields;
    }
    public Field getFields(Integer newX, Integer newY){
        return fields[newY][newX];
    }

    public void setFields(Field[][] fields) {
        this.fields = fields;
    }

    public void move(Animals animals){
        int newX = animals.getX();
        int newY = animals.getY();
        int step = Animals.RANDOM.nextInt(animals.getMaxStepByMove() + 1);

        while (step > 0){
            int direction = Animals.RANDOM.nextInt(5);
            if (isAvailableMove(newX, newY, width, height)){
                    if(newX < (height - 1) || newY < (width - 1)) {
                        switch (direction) {
                            case UP:
                                if(newY == 0){
                                    continue;
                                }
                                newY -= 1;
                                step--;
                            case RIGHT:
                                if(newX == (width - 1)){
                                    continue;
                                }
                                newX += 1;
                                step--;
                            case DOWN:
                                if(newY == (height - 1)){
                                    continue;
                                }
                                newY += 1;
                                step--;
                            case LEFT:
                                if(newX == 0){
                                    continue;
                                }
                                newX -= 1;
                                step--;

                        }
                    }


                fields[animals.getY()][animals.getX()].getFieldHashMap().put(
                        animals,
                        (fields[animals.getY()][animals.getX()].getFieldHashMap().get(animals) - 1)
                );

                animals.setX(newX);
                animals.setY(newY);

                fields[animals.getY()][animals.getX()].getFieldHashMap().put(
                        animals,
                        (fields[animals.getY()][animals.getX()].getFieldHashMap().get(animals) + 1)
                );
            }
        }
    }

    private boolean isAvailableMove(int newX, int newY, int maxX, int maxY){
        if((newX >= 0) && (newX < maxX )&& (newY >= 0) && (newY < maxY)){
            return true;
        }
        return false;
    }

    public void getStatistic(){
        int countOfAnimals = 0;
        for(int i = 0; i < fields.length; i++){
            for(int j = 0; j < fields[i].length; j++){
                for (var entry: fields[i][j].getFieldHashMap().entrySet()) {
                    if (Objects.equals(entry.getKey().getClass(), Plants.class)){
                        continue;
                    }
                    countOfAnimals += entry.getValue();
                }
            }
        }
        System.out.println("Count of animals = " + countOfAnimals);

        int countOfPlants = 0;
        for(int i = 0; i < fields.length; i++){
            for(int j = 0; j < fields[i].length; j++){
                for (Map.Entry<IslandFormOfLife, Integer> entry: fields[i][j].getFieldHashMap().entrySet()) {
                    if (Objects.equals(entry.getKey().getClass(), Plants.class)){
                        countOfPlants += entry.getValue();
                    }

                }
            }
        }
        System.out.println("Count of plants = " + countOfPlants);
    }
}
