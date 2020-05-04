package Tools.TreeTools.ShowTree;

import Algoritms.TreeNode;
import Tools.TreeTools.ShowTree.Graphics.WindowManager;

public class DebugTools {
    public static void showInCode(Object obj, TreeNode tr) {
        WindowManager.setWidthAndHeight(500, 500);
        new Thread(() -> WindowManager.createFrame(obj.getClass().toString(), ShowTree.layerTreeNodeBuilder(tr))).run();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
