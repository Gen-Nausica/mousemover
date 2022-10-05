import java.awt.*;
import java.util.Random;

public class Mouse extends Thread{
    public static final int FIVE_SECONDS = 5000;
    public static final int MAX_Y = 400;
    public static final int MAX_X = 400;

    private Robot robot;
    private boolean running;

    public Mouse(){
        this.running = true;
    }

    public void run(){
        try {
            this.robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        Random random = new Random();
        System.out.println("Robot running");
        while(running){
            robot.mouseMove(random.nextInt(MAX_X), random.nextInt(MAX_Y));
            System.out.println("Robot moving");
            try{
                sleep(FIVE_SECONDS);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        System.out.println("Robot stopped");
    }

    public synchronized void stopThread(){
        running = false;
    }
}
