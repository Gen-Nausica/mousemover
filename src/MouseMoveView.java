import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.plaf.basic.BasicButtonUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowEvent;

public class MouseMoveView extends JFrame {
    public MouseObserver serve;
    private JLabel frame, border, grip, exit, minimize;
    private Point initialClick;
    private MouseMovement model;

    public MouseMoveView(MouseMovement model){
        super("Jennys awesome Mousemover");
        this.model = model;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        JLabel label = new JLabel("Press button to start or stop the mousemover. Have fun:)!", SwingConstants.CENTER);
        label.setOpaque(true);
        label.setBackground(new Color(255, 255, 255, 255));
        label.setBounds(0, 0, 640, 480);
        label.setSize(400,300);
        add(label);
        JPanel panel = new JPanel(new GridLayout(2,1));
        JButton start  = new JButton("Start");
        start.setUI(new BasicButtonUI());
        start.setBackground(new Color(255, 255, 255, 255));
        start.setSize(600,100);
        start.setBorder(new LineBorder(Color.GRAY));
        panel.add(start);
        JButton stop = new JButton("Stop");
        stop.setUI(new BasicButtonUI());
        stop.setBackground(new Color(255, 255, 255, 255));
        stop.setSize(600,50);
        stop.setBorder(new LineBorder(Color.GRAY));
        panel.add(stop);
        panel.setBorder(new LineBorder(Color.GRAY));
        MouseController mousemove = new MouseController(model, label);
        MouseStopper stopper = new MouseStopper(model, label);

        start.addActionListener(mousemove);
        stop.addActionListener(stopper);
        add(panel);
        setLayout(new GridLayout(2,1));
        setLocation(300,50);
        setSize(600,400);
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
