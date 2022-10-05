import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MouseStopper implements ActionListener {
    private MouseMovement mousemove;

    public MouseStopper(MouseMovement mousemove){
        this.mousemove = mousemove;
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        mousemove.stopMouse();
    }
}
