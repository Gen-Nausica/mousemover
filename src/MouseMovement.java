
public class MouseMovement {
    Mouse mouse;

    public MouseMovement(){
        mouse = new Mouse();
    }

    public boolean startMouse(){
        if (this.mouse.isAlive()) {
            this.mouse.stopThread();
        }
        this.mouse = new Mouse();
        mouse.start();
        return true;
    }

    public boolean stopMouse(){
        if(this.mouse.isAlive()){
            mouse.stopThread();
        }
        return true;
    }

    public static void main(String [] args){
        MouseMovement test = new MouseMovement();
        try {
            test.startMouse();
            Thread.sleep(10000);
            test.stopMouse();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
