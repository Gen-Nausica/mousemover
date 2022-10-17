import javax.swing.*;
import java.awt.*;

public class MouseObserver extends Thread{
    private MouseMovement mousemove;
    private JLabel label;
    private static final int DELAY = 5;
    private boolean first;
    public boolean running;

    public MouseObserver(MouseMovement mousemove, JLabel label){
        this.mousemove = mousemove;
        this.label = label;
        System.out.println("Observer");
        this.first = true;
        this.running = true;
        this.start();
    }
    public void run(){
        while (running){
            checkPos();
            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void checkPos() {
        first = false;
        System.out.println("fired");
        Point point = MouseInfo.getPointerInfo().getLocation();
        if(point.getX() != mousemove.getX() || point.getY() != mousemove.getY()){
            mousemove.stopMouse();
            label.setText("Mouse stopped by User");
        }
    }

    public void stopThread(){
        running = false;
    }
}
