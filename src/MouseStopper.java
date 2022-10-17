import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MouseStopper implements ActionListener {
    private MouseMovement mousemove;
    private JLabel label;
    //private MouseMoveView mv;
    private Point lastPoint;

    public MouseStopper (MouseMovement mousemove, JLabel label/*, MouseMoveView mv*/){
        this.label = label;
        this.mousemove = mousemove;
        //this.mv = mv;
    }

    public MouseStopper(MouseMovement mousemove){
        this.mousemove = mousemove;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        mousemove.stopMouse();
        label.setText("Mouse stopped");
        //mv.stopObserver();
    }

}
