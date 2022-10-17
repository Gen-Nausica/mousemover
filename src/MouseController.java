import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MouseController implements ActionListener {
    private MouseMovement mousemove;
    private JLabel label;

    public MouseController(MouseMovement mousemove, JLabel label){
        this.label = label;
        this.mousemove = mousemove;
    }

    public MouseController (MouseMovement mousemove){
        this.mousemove = mousemove;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        mousemove.startMouse();
        label.setText("Mouse moving");
    }
}
