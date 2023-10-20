
import core.Island;
import core.IslandFormOfLife;
import core.Plants;
import core.animals.Animals;

import java.util.Map;
import java.util.Objects;


public class Menu implements Runnable {
    protected boolean isRunning = false;
    private final String welcomeMenu = "Welcome to the Wild Animals Island!!";



    {

        while (!isRunning) {
            System.out.println(welcomeMenu);

            isRunning = false;
            while (!isRunning) {
                this.run();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException("Thread was interrupted!");
                }
                Animals.getIsland().getStatistic();
//                isRunning = true;
            }
        }
    }

    public void run() {

        for (int i = 0; i < Animals.getIsland().fields.length; i++) {
            for (int j = 0; j < Animals.getIsland().fields[i].length; j++) {
                for (Map.Entry<IslandFormOfLife, Integer> entry : Animals.getIsland().fields[i][j].getFieldHashMap().entrySet()) {
                   for(int n = 0; n < entry.getValue(); n++){
                       if(Objects.equals(entry.getKey().getClass(), Plants.class)) {
                           continue;
                       }
                       Animals animals = (Animals) entry.getKey();
                       Thread thread = new Thread(animals);
                       thread.start();
                   }
                }
            }
        }
        isRunning = false;
        while (!isRunning) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                throw new RuntimeException("Thread was interrupted!");
            }
            Animals.getIsland().getStatistic();
//            if(island.fields[island.getHeight()][island.getHeight()].getFieldHashMap().get(Plants) > 0){
//                for(Plants plant : Plants.growPlants){
//                    Thread thread = new Thread(plant);
//                    thread.start();
//                }
//                Plants.growPlants.clear();
//            }
        }
    }
}
