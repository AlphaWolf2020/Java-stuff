package ruby;

import util.Time;

import javax.swing.JFrame;
import java.awt.event.KeyEvent;

public class Window extends JFrame implements Runnable {

    public ML mouseListener;
    public KL keyListener;

    private static Window window = null;
    private boolean isRunning = true;
    private Scene currentScene = null;

    public Window() {
        this.mouseListener = new ML();
        this.keyListener = new KL();

        this.setSize(1280, 720);
        this.setTitle("Geometry Dash");
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addMouseListener(mouseListener);
        this.addKeyListener(keyListener);
        this.addMouseMotionListener(mouseListener);
        this.setLocationRelativeTo(null);
    }

    public void init() {
    changeScene(0);
    }


    public void changeScene(int scene) {
        switch (scene){
            case 0:
                currentScene = new LevelEditorScene("LevelEditor");
                break;
            default:
                System.out.println("Do not know wtf this scene is.");
                currentScene = null;
        }
    }



    public static Window getWindow() {
        if (Window.window == null) {
            Window.window = new Window();
        }

        return Window.window;
    }

    public void update(double dt) {
       currentScene.update(dt);
    }



    @Override
    public void run() {
        double lastFrameTime = 0.0;
        try{
            while(isRunning) {
                double time = Time.getTime();
                double deltaTime = time - lastFrameTime;
                lastFrameTime = time;

                update(deltaTime);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }
}












