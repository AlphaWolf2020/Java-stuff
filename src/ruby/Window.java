package ruby;

import javax.swing.JFrame;

public class Window extends JFrame implements Runnable {

    private static Window window = null;

    public Window() {
        this.setSize(1280, 720);
        this.setTitle("Geometry Dash");
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public void init() {

    }

    public static Window getWindow() {
        if (Window.window == null) {
            Window.window = new Window();
        }

        return Window.window;
    }

    @Override
    public void run() {

    }
}












