package Tools.TreeTools.ShowTree.Graphics;

import Tools.TreeTools.ShowTree.Layer;

import javax.swing.*;
import java.awt.*;

public class WindowManager {
    private static int width = 1800;
    private static int height = 800;

    private static MyCanvas canvas = null;
    private static JFrame window;
    public static void createFrame(String name, Layer layer) {
        window = new JFrame("Tree node painter");
        window.setSize(width, height);
        window.setTitle(name);

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

    public static void setWidthAndHeight(int width, int height) {
        WindowManager.width = width;
        WindowManager.height = height;
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
