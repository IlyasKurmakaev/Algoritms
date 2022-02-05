package Algoritms;
//130 Medium. Surrounded Regions https://leetcode.com/problems/surrounded-regions/
//Success
//Runtime: 68 ms, faster than 5.20% of Java online submissions for Surrounded Regions.
//Memory Usage: 44.6 MB, less than 11.32% of Java online submissions for Surrounded Regions.


import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board.length == 0) return;
        HashSet<YXPair> alreadyProcessedCells = new HashSet<>();
        YXPair tempYX = new YXPair(0, 0);
        for (int vertI = 0; vertI < board.length; vertI++) {
            tempYX.y = vertI;
            for (int horI = 0; horI < board[0].length; horI++) {
                tempYX.x = horI;
                BooleanContayner connectedToEdge = new BooleanContayner(false);
                if (!alreadyProcessedCells.contains(tempYX) && board[vertI][horI] == 'O') {
                    Set<YXPair> area = markRegion(board, alreadyProcessedCells, connectedToEdge, tempYX);
                    if (connectedToEdge.var == false) {
                        makeXRegion(board, area);
                    }
                }
            }
        }
    }

    private class BooleanContayner {
        public BooleanContayner (boolean arg) {
            var = arg;
        }
        public boolean var; // гет и сет излишни
    }

    public Set<YXPair> markRegion(char[][] board, Set<YXPair> alreadyProcessedCells, BooleanContayner borderConnectedAreaFlag, YXPair yx) {
        Map<YXPair, Cell> bufferCellsMap = new HashMap();
        Set<YXPair> result = new HashSet<>();
        borderConnectedAreaFlag.var = false;
        bufferCellsMap.put(yx, createFirstCell(board, yx));
        if (bufferCellsMap.get(yx).isOnBorder) {
            borderConnectedAreaFlag.var = true;
        }
        result.add(yx);
        
        while (!bufferCellsMap.isEmpty()) {
            Map.Entry<YXPair, Cell> cellEntry = bufferCellsMap.entrySet().iterator().next();
            bufferCellsMap.remove(cellEntry.getKey());
            Cell currentCell = cellEntry.getValue();
            Cell tempNewCell;
            YXPair tempNewYX;
            if (currentCell.up == null) {
                tempNewYX = new YXPair(cellEntry.getKey().y - 1, cellEntry.getKey().x);
                tempNewCell = processCell(board, bufferCellsMap, Sides.UP, tempNewYX);
                bufferCellsMap.put(tempNewYX, tempNewCell);
                result.add(tempNewYX);
                if (tempNewCell.isOnBorder) {
                    borderConnectedAreaFlag.var = true;
                }
            }

            if (currentCell.right == null) {
                tempNewYX = new YXPair(cellEntry.getKey().y, cellEntry.getKey().x + 1);
                tempNewCell = processCell(board, bufferCellsMap, Sides.RIGHT, tempNewYX);
                bufferCellsMap.put(tempNewYX, tempNewCell);
                result.add(tempNewYX);
                if (tempNewCell.isOnBorder) {
                    borderConnectedAreaFlag.var = true;
                }
            }

            if (currentCell.down == null) {
                tempNewYX = new YXPair(cellEntry.getKey().y + 1, cellEntry.getKey().x);
                tempNewCell = processCell(board, bufferCellsMap, Sides.DOWN, tempNewYX);
                bufferCellsMap.put(tempNewYX, tempNewCell);
                result.add(tempNewYX);
                if (tempNewCell.isOnBorder) {
                    borderConnectedAreaFlag.var = true;
                }
            }

            if (currentCell.left == null) {
                tempNewYX = new YXPair(cellEntry.getKey().y, cellEntry.getKey().x - 1);
                tempNewCell = processCell(board, bufferCellsMap, Sides.LEFT, tempNewYX);
                bufferCellsMap.put(tempNewYX, tempNewCell);
                result.add(tempNewYX);
                if (tempNewCell.isOnBorder) {
                    borderConnectedAreaFlag.var = true;
                }
            }
        }

        alreadyProcessedCells.addAll(result);

        return result;
    }

    private Cell createFirstCell(char[][] board, YXPair yx) {
        Cell newCell = new Cell();
        if (yx.y - 1 >= 0) { // up side
            if (board[yx.y - 1][yx.x] == 'X') {
                newCell.up = StateSides.ON_BORDER_OR_X;
            } else {
                // up = null
            }
        } else {
            newCell.isOnBorder = true;
            newCell.up = StateSides.ON_BORDER_OR_X;
        }

        if (yx.x + 1 < board[0].length) { // right side
            if (board[yx.y][yx.x + 1] == 'X') {
                newCell.right = StateSides.ON_BORDER_OR_X;
            } else {
                // up = null
            }
        } else {
            newCell.isOnBorder = true;
            newCell.right = StateSides.ON_BORDER_OR_X;
        }

        if (yx.y + 1 < board.length) { // down side
            if (board[yx.y + 1][yx.x] == 'X') {
                newCell.down = StateSides.ON_BORDER_OR_X;
            } else {
                // up = null
            }
        } else {
            newCell.isOnBorder = true;
            newCell.down = StateSides.ON_BORDER_OR_X;
        }

        if (yx.x - 1 >= 0) { // left side
            if (board[yx.y][yx.x - 1] == 'X') {
                newCell.left = StateSides.ON_BORDER_OR_X;
            } else {
                // up = null
            }
        } else {
            newCell.isOnBorder = true;
            newCell.left = StateSides.ON_BORDER_OR_X;
        }
        return newCell;
    }

    private Cell processCell(char[][] board, Map<YXPair, Cell> bufferCells, Sides side, YXPair endYX) {
        if (endYX.y == 2 && endYX.x == 2) {
            System.out.println();
        }
        Cell cell = new Cell();
        switch (side) {
            case UP:
                cell.down = StateSides.EXIST;
                break;
            case RIGHT:
                cell.left = StateSides.EXIST;
                break;
            case DOWN:
                cell.up = StateSides.EXIST;
                break;
            case LEFT:
                cell.right = StateSides.EXIST;
                break;
        }

        cell.isOnBorder = isOnBorder(board, endYX);

        //bufferCells.put(endYX, cell);

        Cell tempCell;
        YXPair tempYX = new YXPair(endYX.y - 1, endYX.x);
        if (cell.up == null) { //сразу две функциональности: 1) определить текущую клетку 2) определить соседнюю клетку. Ниже аналогично
            if (!outOfBounds(board, tempYX)) {
                if (bufferCells.containsKey(tempYX)) {
                    tempCell = bufferCells.get(tempYX);
                    tempCell.down = StateSides.EXIST;
                    cell.up = StateSides.EXIST;
                } else if (board[tempYX.y][tempYX.x] == 'X') {
                    cell.up = StateSides.ON_BORDER_OR_X;
                }
            } else {
                cell.up = StateSides.ON_BORDER_OR_X;
            }
        }


        tempYX = new YXPair(endYX.y, endYX.x + 1);
        if (cell.right == null) {
            if (!outOfBounds(board, tempYX)) {
                if (bufferCells.containsKey(tempYX)) {
                    tempCell = bufferCells.get(tempYX);
                    tempCell.left = StateSides.EXIST;
                    cell.right = StateSides.EXIST;
                } else if (board[tempYX.y][tempYX.x] == 'X') {
                    cell.right = StateSides.ON_BORDER_OR_X;
                }
            } else {
                cell.right = StateSides.ON_BORDER_OR_X;
            }
        }

        tempYX = new YXPair(endYX.y + 1, endYX.x);
        if (cell.down == null) {
            if (!outOfBounds(board, tempYX)) {
                if (bufferCells.containsKey(tempYX)) {
                    tempCell = bufferCells.get(tempYX);
                    tempCell.up = StateSides.EXIST;
                    cell.down = StateSides.EXIST;
                } else if (board[tempYX.y][tempYX.x] == 'X') {
                    cell.down = StateSides.ON_BORDER_OR_X;
                }
            } else {
                cell.down = StateSides.ON_BORDER_OR_X;
            }
        }

        tempYX = new YXPair(endYX.y, endYX.x - 1);
        if (cell.left == null) { //сразу две функциональности: 1) определить текущую клетку 2) определить соседнюю клетку. Ниже аналогично
            if (!outOfBounds(board, tempYX)) {
                if (bufferCells.containsKey(tempYX)) {
                    tempCell = bufferCells.get(tempYX);
                    tempCell.right = StateSides.EXIST;
                    cell.left = StateSides.EXIST;
                } else if (board[tempYX.y][tempYX.x] == 'X') {
                    cell.left = StateSides.ON_BORDER_OR_X;
                }
            } else {
                cell.left = StateSides.ON_BORDER_OR_X;
            }
        }
        return cell;
    }

    private void makeXRegion(char[][] board, Set<YXPair> regionToX) { /////////////////////////////////////////////////////////////////////////////
        for (YXPair yx : regionToX) {
            board[yx.y][yx.x] = 'X';
        }
    }

    private boolean outOfBounds(char[][] board, YXPair yx) {
        if (board.length - 1 < yx.y || yx.y < 0 || board[0].length - 1 < yx.x || yx.x < 0) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isOnBorder(char[][] board, YXPair yx) {
        if (outOfBounds(board, new YXPair(yx.y - 1, yx.x))) { // up
            return true;
        }
        if (outOfBounds(board, new YXPair(yx.y, yx.x + 1))) { //right
            return true;
        }
        if (outOfBounds(board, new YXPair(yx.y + 1, yx.x))) { //down
            return true;
        }
        if (outOfBounds(board, new YXPair(yx.y, yx.x - 1))) { //left
            return true;
        }
        return false;
    }

    class YXPair {
        public int y; //в простых структурах предпочитаю паблик методы
        public int x;

        public YXPair(int y, int x) {
            this.y = y;
            this.x = x;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            YXPair yxPair = (YXPair) o;
            return y == yxPair.y &&
                    x == yxPair.x;
        }

        @Override
        public int hashCode() {
            return Objects.hash(y, x);
        }
    }


    class Cell {
        public StateSides up = null;
        public StateSides right = null;
        public StateSides down = null;
        public StateSides left = null;
        public boolean isOnBorder = false;
        //public YXPair yx;
    }


    public enum StateSides {
        EXIST, ON_BORDER_OR_X
    }

    public enum Sides {
        UP, RIGHT, DOWN, LEFT
    }

    static char[][] testCaseOneInput = {{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
    static char[][] testCaseOneExpected  = {{'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'}, {'X', 'O', 'X', 'X'}};

    @Test
    public void test() {
        solve(testCaseOneInput);
        Assert.assertEquals(testCaseOneInput, testCaseOneExpected);
    }

    public static void main(String[] args) {
       new SurroundedRegions().solve(testCaseOneInput);
        Tools.Tools.printSquareArr(testCaseOneInput);
        System.out.println(Arrays.asList(testCaseOneInput));
    }

}


