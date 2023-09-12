public class Menu {
    protected boolean isRunning = false;
    private final String welcomMenu = "Welcom to the Wild Animals Island!!";
   public void run(){
       while(!isRunning){
           System.out.println(welcomMenu);

           isRunning = true;
       }
   }

}
