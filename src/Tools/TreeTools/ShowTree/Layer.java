package Tools.TreeTools.ShowTree;

import Algoritms.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Layer {
    private List<Cell> layerCells = new ArrayList<>();
    private Layer nextLayer = null;

    public void addNewCell(Cell cell) {
        layerCells.add(cell);
    }

    public List<Cell> getListCells() {
        return layerCells;
    }

    public static Layer createNewLayer(Layer firstWorkLayer) {
        Layer secondWorkLayer = new Layer();
        firstWorkLayer.nextLayer = secondWorkLayer;
        for (Cell cell : firstWorkLayer.getListCells()) {
            if (cell.getTreeNode().left != null) {
                Cell newCell = new Cell(secondWorkLayer, cell.getTreeNode().left, cell, Cell.SideOfParent.LEFT);
                secondWorkLayer.addNewCell(newCell);
                cell.setChildren(newCell, Cell.SideOfParent.LEFT);
            }
            if (cell.getTreeNode().right != null) {
                Cell newCell = new Cell(secondWorkLayer, cell.getTreeNode().right, cell, Cell.SideOfParent.RIGHT);
                secondWorkLayer.addNewCell(newCell);
                cell.setChildren(newCell, Cell.SideOfParent.RIGHT);
            }
        }
        return secondWorkLayer;
    }

    public static boolean checkLayerAtCollision(Layer argLayer) {
        for (int i = 0; i < argLayer.getListCells().size() - 1; i++) {
            if (argLayer.getListCells().get(i).getXCoordinates() >= argLayer.getListCells().get(i + 1).getXCoordinates()) {
                return true;
            }
        }
        return false;
    }

    public static List<Cell> getTwoCollidedCells(Layer argLayer) {
        for (int i = 0; i < argLayer.getListCells().size() - 1; i++) {
            if (argLayer.getListCells().get(i).getXCoordinates() >= argLayer.getListCells().get(i + 1).getXCoordinates()) {
                List<Cell> retArr = new ArrayList<>();
                retArr.add(argLayer.getListCells().get(i));
                retArr.add(argLayer.getListCells().get(i + 1));
                return retArr;
            }
        }
        return null;
    }

    public static Cell getCommonCell(Cell firstCell, Cell secondCell) { //pushApartChildrenCells
        while (firstCell != secondCell) {
            firstCell = firstCell.getParent();
            secondCell = secondCell.getParent();
        }
        return firstCell;
    }

    public static boolean checkAtLayerChildrens(Layer layer) {
        List<Cell> listCells = layer.getListCells();
        for (Cell cell : listCells) {
            if (cell.getTreeNode().left != null || cell.getTreeNode().right != null) {
                return true;
            } else {
                continue;
            }
        }
        return false;
    }

    public Layer getNextLayer() {
        return nextLayer;
    }

    @Override
    public String toString() {
        System.out.println("place for stop");
        return "Layer{" +
                "layerCells=" + layerCells +
                '}';
    }
}


