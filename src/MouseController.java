import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MouseController implements ActionListener {
    private MouseMovement mousemove;

    public MouseController (MouseMovement mousemove){
        this.mousemove = mousemove;
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        mousemove.startMouse();
    }
}
