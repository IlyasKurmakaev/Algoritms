package Algoritms;
//Task 74 Medium.  Search a 2D Matrix https://leetcode.com/problems/search-a-2d-matrix/
//Success
//Runtime: 1 ms, faster than 11.70% of Java online submissions for Search a 2D Matrix.
//Memory Usage: 41.4 MB, less than 6.06% of Java online submissions for Search a 2D Matrix.

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        if (target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1]) {
            return false;
        }
        int numLine = 0;
        if (matrix.length > 1) {
            numLine = binarySearchInArr(matrix, new VerticalStrategi(), target);
        }
        if (matrix[0].length > 1)
        return binarySearchInArr(matrix, new HorizontalStrategi(numLine), target) != null;
        return matrix[numLine][0] == target;
    }

    public Integer binarySearchInArr(int[][] matrix, IInputReturnStrategy iInputReturn, int target) {
        int leftBorder = 0;
        int rightBorder = iInputReturn.getMatrixLength(matrix) - 1;
        while (rightBorder - leftBorder != 1) { // до тех пор, пока не останется всего 2 элемента
            if (iInputReturn.getMatrixLength(matrix) > 1) {
                int midBorder = (leftBorder + rightBorder) / 2;
                if (iInputReturn.getByIndex(midBorder, matrix) > target) {
                    rightBorder = midBorder;
                } else if (iInputReturn.getByIndex(midBorder, matrix) < target) {
                    leftBorder = midBorder;
                } else if (iInputReturn.getByIndex(midBorder, matrix) == target) {
                    return midBorder;
                } else {
                    System.out.println("Что-то пошло не так");
                }
            }
        }
        return iInputReturn.returnFunc(target, leftBorder, rightBorder, matrix);
    }


    private interface IInputReturnStrategy {
        int getByIndex(int i, int[][] matrix);

        Integer returnFunc(int target, int leftBorder, int rightBorder, int[][] matrix);

        int getMatrixLength(int[][] matrix);
    }

    public class VerticalStrategi implements IInputReturnStrategy {
        @Override
        public int getByIndex(int i, int[][] matrix) {
            return matrix[i][0];
        }

        @Override
        public Integer returnFunc(int target, int leftBorder, int rightBorder, int[][] matrix) {
            if (target >= getByIndex(leftBorder, matrix) && target < getByIndex(rightBorder, matrix)) {
                return leftBorder;
            } else if (target >= getByIndex(rightBorder, matrix)) {
                return rightBorder;
            } else {
                return null;
            }
        }

        @Override
        public int getMatrixLength(int[][] matrix) {
            return matrix.length;
        }
    }

    private class HorizontalStrategi implements IInputReturnStrategy {
        private Integer verticalLine;

        public HorizontalStrategi(Integer verticalLine) {
            this.verticalLine = verticalLine;
        }

        @Override
        public int getByIndex(int i, int[][] matrix) {
            return matrix[verticalLine][i];
        }

        @Override
        public Integer returnFunc(int target, int leftBorder, int rightBorder, int[][] matrix) {
            if (matrix[verticalLine][leftBorder] == target) {
                return leftBorder;
            } else if (matrix[verticalLine][rightBorder] == target) {
                return rightBorder;
            } else {
                return null;
            }
        }

        @Override
        public int getMatrixLength(int[][] matrix) {
            return matrix[0].length;
        }
    }

}
