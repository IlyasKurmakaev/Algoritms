package Tools.TreeTools.ShowTree;

import Algoritms.TreeNode;

public class Cell {
    private TreeNode treeNode;
    private int xCoordinateDeviation;
    private Cell parent;
    private SideOfParent side;
    private Layer layer;
    private Cell leftChildren = null;
    private Cell rightChildren = null;


    public Cell(Layer layer, TreeNode treeNode, Cell parent, SideOfParent side) {
        this.treeNode = treeNode;
        this.parent = parent;
        this.side = side;
        this.layer = layer;
    }

    public void addXCoordinateDeviation(int x) {
        xCoordinateDeviation += x;
    }

    public void setChildren(Cell cell, SideOfParent sideOfParent) {
        if (sideOfParent == SideOfParent.LEFT) {
            leftChildren = cell;
        } else if (sideOfParent == SideOfParent.RIGHT){
            rightChildren = cell;
        }
        else {
            System.out.println("Всё сломалось");
        }
    }

    public Cell getChildren(SideOfParent side) {
        if (side == SideOfParent.LEFT) {
            return leftChildren;
        } else if (side == SideOfParent.RIGHT) {
            return rightChildren;
        } else {
            System.out.println("Всё сломалось");
            return null;
        }
    }

    public TreeNode getTreeNode() {
        return treeNode;
    }

    public Cell getParent() {
        return parent;
    }

    public Layer getLayer() {
        return layer;
    }

    public int getXCoordinates() {
        if (parent != null) {
            if (side == SideOfParent.LEFT) {
                return parent.getXCoordinates() - 1 + xCoordinateDeviation;
            } else if (side == SideOfParent.RIGHT) {
                return parent.getXCoordinates() + 1 + xCoordinateDeviation;
            } else {
                System.out.println("Всё сломалось");
                return -1;
            }
        } else {
            return 0; // 0 - это координата первого узла
        }
    }

    public enum SideOfParent {
        RIGHT,
        LEFT
    }
}