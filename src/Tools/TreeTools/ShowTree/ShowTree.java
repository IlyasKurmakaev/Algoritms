package Tools.TreeTools.ShowTree;

import Algoritms.TreeNode;
import Tools.TreeTools.RandomGenTree.RandomGenTree;
import Tools.TreeTools.ShowTree.Graphics.WindowManager;

import java.util.List;

public class ShowTree {
    private static IGeneratorTreeNode i = null;

    public static void showTree() {
        if (i == null) {
            System.out.println("Всё сломалось");
        }
        TreeNode treeNode = i.genTreeNode();
        Layer layer = layerTreeNodeBuilder(treeNode);
        WindowManager.createFrame(layer);
    }

    public static void repaintTree() {
        TreeNode treeNode = i.genTreeNode();
        Layer layer = layerTreeNodeBuilder(treeNode);
        WindowManager.repaintFrame(layer);
    }

    public static Layer layerTreeNodeBuilder(TreeNode firstTreeNode) {
        Layer firstLayer = new Layer();
        firstLayer.addNewCell(new Cell(firstLayer, firstTreeNode, null, null));
        Layer lastLayer = firstLayer;

        while (Layer.checkAtLayerChildrens(lastLayer)) { // до тех пор, пока у слоя есть дети
            lastLayer = Layer.createNewLayer(lastLayer); //создаём новый последний(нижний) слой на основе прежнего последнего
            Layer nextLayerForCheck = lastLayer; // слой с которого будем проверять на коллизии
            while (nextLayerForCheck != null) {
                if (Layer.checkLayerAtCollision(nextLayerForCheck)) {
                    List<Cell> collidedCells = Layer.getTwoCollidedCells(nextLayerForCheck); // два узла/ячейки которые пересеклись
                    Cell cell = Layer.getCommonCell(collidedCells.get(0), collidedCells.get(1));
                    cell.getChildren(Cell.SideOfParent.LEFT).addXCoordinateDeviation(-1);
                    cell.getChildren(Cell.SideOfParent.RIGHT).addXCoordinateDeviation(1);
                    nextLayerForCheck = cell.getChildren(Cell.SideOfParent.LEFT).getLayer();
                }
                nextLayerForCheck = nextLayerForCheck.getNextLayer();
            }
        }
        return firstLayer;
    }

    public interface IGeneratorTreeNode {
        public TreeNode genTreeNode();
    }

    public static void setI(IGeneratorTreeNode i) {
        ShowTree.i = i;
    }

    public class GenJustGetTreeNode implements IGeneratorTreeNode {
        private TreeNode treeNode;

        public GenJustGetTreeNode(TreeNode treeNode) {
            this.treeNode = treeNode;
        }

        @Override
        public TreeNode genTreeNode() {
            return treeNode;
        }
    }

    public class GenRandomTreeNode implements IGeneratorTreeNode {
        int levels;
        int percentOfChildren;

        public GenRandomTreeNode(int levels, int percentOfChildren) {
            this.levels = levels;
            this.percentOfChildren = percentOfChildren;
        }

        @Override
        public TreeNode genTreeNode() {
            return new RandomGenTree().createRandomTreeNode(levels, percentOfChildren);
        }
    }
}
