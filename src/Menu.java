import island.FirstInitialize;
import island.Plants;
import island.animals.Animals;
import island.map.Island;




public class Menu implements Runnable{
    protected boolean isRunning = false;
    protected volatile Island island;
    private final String welcomeMenu = "Welcome to the Wild Animals Island!!";
   public void start(){

       new FirstInitialize().start();

       Thread thread = new Thread(this);
       thread.start();
       while(!isRunning){
           System.out.println(welcomeMenu);

           isRunning = true;
       }
   }
    @Override
    public void run() {
//       for(int i = 0; i < island.animalsOnOneField.size(); i++) {
//
//           for (Animals animal : island.animalsOnOneField.get(i)) {
//               Thread thread = new Thread(animal);
//               thread.start();
//           }
//       }
        isRunning = false;
        while(!isRunning){
            try{
                Thread.sleep(3000);
            }catch (InterruptedException e){
                throw new RuntimeException("Thread was interrupted!");
            }
            island.getStatistic();
            if(island.plantsOnOneField.size() > 0){
                for(Plants plant : Plants.growPlants){
                    Thread thread = new Thread(plant);
                    thread.start();
                }
                Plants.growPlants.clear();
            }
        }
    }
}
