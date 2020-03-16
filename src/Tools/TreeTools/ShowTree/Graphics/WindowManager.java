package Tools.TreeTools.ShowTree.Graphics;

import Tools.TreeTools.ShowTree.Layer;

import javax.swing.*;
import java.awt.*;

public class WindowManager {
    private static final int WIDTH = 1800;
    private static final int HEIGHT = 800;

    private static MyCanvas canvas = null;
    private static JFrame window;
    public static void createFrame(Layer layer) {
        window = new JFrame("Tree node painter");
        window.setSize(WIDTH, HEIGHT);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.setLayout(new BorderLayout(1, 1));

        canvas = new MyCanvas();
        canvas.setLayer(layer);
        window.add(canvas);
        window.add(new RefreshButton(), BorderLayout.NORTH);
        window.setVisible(true);
    }

    public static void repaintFrame(Layer layer){
        canvas.setLayer(layer);
        canvas.repaint();
    }

    public static int getWidth () {
        if (window == null) System.out.println("Всё сломалось");
        return window.getWidth();
    }

    public static int getHeight () {
        if (window == null) System.out.println("Всё сломалось");
        return window.getHeight();
    }
}
