package Tools.TreeTools.ShowTree.Graphics;

import Tools.TreeTools.ShowTree.Layer;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class MyCanvas extends JComponent {
    private Layer layer = null;
    public static final int DIAMETR = 50; // диаметр также выступает в роли пространства между узлами
    public static final int RADIUS = DIAMETR / 2; // радиус используется для смещения окружностей в центр указываемых с точек

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(Color.GRAY);
        g2d.fillRect(0, 0, WindowManager.getWidth(), WindowManager.getHeight());
        g2d.setColor(Color.BLACK);
        g2d.setStroke(new BasicStroke(5f));
        paintTree(g2d);
        // repaint();
    }

    public void paintTree(Graphics2D g2d) {
        //Map<String, Integer> minAndMax = searchHorizontalLengthOfTree(layer);
        Layer localCopyLayer = layer;
        int level = 0;
        while (localCopyLayer != null) {
            for (int i = 0; i < localCopyLayer.getListCells().size(); i++) {

                g2d.drawOval(WindowManager.getWidth()/2 + localCopyLayer.getListCells().get(i).getXCoordinates() * DIAMETR - RADIUS, level * DIAMETR + RADIUS - RADIUS, DIAMETR, DIAMETR);
                g2d.drawString(Integer.toString(localCopyLayer.getListCells().get(i).getTreeNode().val), WindowManager.getWidth()/2 + localCopyLayer.getListCells().get(i).getXCoordinates() * DIAMETR, level * DIAMETR + RADIUS + 40);
                if (localCopyLayer.getListCells().get(i).getParent() != null) {
                    g2d.drawLine(WindowManager.getWidth()/2 + localCopyLayer.getListCells().get(i).getParent().getXCoordinates() * DIAMETR, (level - 1) * DIAMETR + 25, WindowManager.getWidth()/2 + localCopyLayer.getListCells().get(i).getXCoordinates() * DIAMETR, level * DIAMETR + 25);
                }
            }
            level++;
            localCopyLayer = localCopyLayer.getNextLayer();
        }
    }
    @Deprecated
    private Map<String, Integer> searchHorizontalLengthOfTree(Layer layer) {
        Map<String, Integer> res = new HashMap<>();
        int min = 0;
        int max = 0;
        while (layer != null) {
            for (int i = 0; i < layer.getListCells().size(); i++) {
                int x = layer.getListCells().get(i).getXCoordinates();
                if (x < min) {
                    min = x;
                } else if (x > max) {
                    max = x;
                }
            }
            layer = layer.getNextLayer();
        }
        res.put("min", min);
        res.put("max", max);
        return res;
    }

    public void setLayer(Layer layer) {
        this.layer = layer;
    }
}
