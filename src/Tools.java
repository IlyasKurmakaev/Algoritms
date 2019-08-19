public class Tools {
    public static int[][] createIntSquareArr(int y, int x) {
        int[][] res = new int[y][x];
        int nums = 1;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                res[i][j] = nums;
                nums++;
            }
        }
//        System.out.println(res.length);
//        System.out.println(res[0].length);
        return res;
    }

    public static void printSquareArr(int[][] argArr) {
        for (int i = 0; argArr.length > i; i++) {
            for (int j = 0; argArr[0].length > j; j++) {
                System.out.print(argArr[i][j]);
                for (int iSpace = 0; iSpace < getLengthOfInt(argArr.length * argArr[0].length) + 1 - getLengthOfInt(argArr[i][j]); iSpace++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("_____________");
    }

    private static int getLengthOfInt(int arg) {
        return arg == 0 ? 1 : (int)Math.log10(arg) + 1;
    }

    public static void main(String[] args) {
        System.out.println(getLengthOfInt(0));
    }
}
