import javax.swing.*;
import java.awt.*;

public class MouseMoveView extends JFrame {
    public MouseObserver serve;

    public MouseMoveView(MouseMovement model){
        super("Jennys awesome Mousemover");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        JLabel label = new JLabel("hier bewegt sich was");
        add(label);
        JButton start  = new JButton("Start");
        add(start);
        JButton stop = new JButton("Stop");
        add(stop);
        MouseController mousemove = new MouseController(model, label);
        //MouseStopper stopper = new MouseStopper(model, label, this);
        MouseStopper stopper = new MouseStopper(model, label);
        //this.serve = new MouseObserver(model, label);

        start.addActionListener(mousemove);
        stop.addActionListener(stopper);
        setLayout(new GridLayout(3,1));
        setLocation(300,50);
        setSize(400,100);
        setVisible(true);
    }

    public void stopObserver(){
        this.serve.stopThread();
    }

    public static void main(String []args){

        MouseMovement mm = new MouseMovement();
        MouseMoveView mv = new MouseMoveView(mm);
    }
}
