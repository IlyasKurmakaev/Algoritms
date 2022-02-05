package Algoritms;
//Task 167 Two Sum II - Input array is sorted  https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
//Success
//Runtime: 2 ms, faster than 23.18% of Java online submissions for Two Sum II - Input array is sorted.
//Memory Usage: 39.1 MB, less than 53.43% of Java online submissions for Two Sum II - Input array is sorted.
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int secondNum;
        Integer secondNumIndex;
        for (int i = 0; i < numbers.length; i++) {
            secondNum = target - numbers[i];
            secondNumIndex = binarySearch(numbers, i + 1, numbers.length - 1, secondNum);
            if (secondNumIndex != null) {
                return new int[]{i + 1, secondNumIndex + 1};
            }
        }
        return null;
    }


    private Integer binarySearch(int[] numbers, int leftBorder, int rightBorder, int target) {
        if (numbers[leftBorder] == target) return leftBorder;
        if (numbers[rightBorder] == target) return rightBorder;
        int midBorder;
        while (rightBorder - leftBorder != 1) {
            midBorder = (leftBorder + rightBorder) / 2;
            if (numbers[midBorder] != target) {
                if (numbers[midBorder] > target) {
                    rightBorder = midBorder;
                } else {
                    leftBorder = midBorder;
                }
            } else {
                return midBorder;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int []res1 = new TwoSum().twoSum(new int[]{2,3,4}, 6);
        System.out.println(res1[0] + "  " + res1[1]);

        int []res2 = new TwoSum().twoSum(new int[]{0,0,3,4}, 0);
        System.out.println(res2[0] + "  " + res2[1]);
    }
}
