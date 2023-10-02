package island.map;


import island.IslandFormOfLife;
import island.Plants;
import island.animals.Animals;
import island.animals.herbivorous.*;
import island.animals.predators.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static island.Plants.setGrowPlants;

public class Island {

    private final String nameOfIsland = "The Paradise";
    private final int width = 20;
    private final int height = 100;
    private final int UP = 1;
    private final int RIGHT = 2;
    private final int DOWN = 3;
    private final int LEFT = 4;
    private final Random random = new Random();
    public volatile Field[][] fields;
    protected volatile Island island = new Island();


    public Island getIsland() {
        return island;
    }
    public void setIsland(Island island) {
        this.island = island;
    }

    public String getNameOfIsland() {
        return nameOfIsland;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Island[][] getFields() {
        return fields;
    }

    public void setFields(Field[][] fields) {
        this.fields = fields;
    }

    public void move(Animals animals){
        int newX = animals.getX();
        int newY = animals.getY();
        int step = random.nextInt(animals.getMaxStepByMove() + 1);

        while (step > 0){
            int direction = random.nextInt(5);
            if (isAvailableMove(newX, newY, width, height)){
                switch (direction) {
                    case UP:
                        newY += 1;
                        step--;
                    case RIGHT:
                        newX += 1;
                        step--;
                    case DOWN:
                        newY -= 1;
                        step--;
                    case LEFT:
                        newX -= 1;
                        step--;
                }

                fields[animals.getY()][animals.getX()].getFieldHashMap().remove(animals, (fields[animals.getY()][animals.getX()].getFieldHashMap().get(animals) - 1));

                animals.setX(newX);
                animals.setY(newY);

                fields[animals.getY()][animals.getX()].getFieldHashMap().put(animals, (fields[animals.getY()][animals.getX()].getFieldHashMap().get(animals) + 1));
            }

        }
    }

    private boolean isAvailableMove(int newX, int newY, int maxX, int maxY){
        if(newX >= 0 && newX < maxX && newY >= 0 && newY < maxY){
            return true;
        }
        return false;
    }

    public void getStatistic(){
        int countOfAnimals = 0;
        for(int i = 0; i < fields.length; i++){
            for(int j = 0; j < fields[i].length; j++){
                for(int n = 0; n < fields[i][j].getFieldHashMap(). !!!!!!!.size(); n++){
                    countOfAnimals++;
                }
            }
        }
        System.out.println("Count of animals = " + countOfAnimals);

        int countOfPlants = 0;
        for(int i = 0; i < fields.length; i++){
            for(int j = 0; j < fields[i].length; j++){
                for(int n = 0; n < fields[i][j].plantsOnOneField.size(); n++){
                    countOfPlants++;
                }
            }
        }
        System.out.println("Count of plants = " + countOfPlants);
    }
}
