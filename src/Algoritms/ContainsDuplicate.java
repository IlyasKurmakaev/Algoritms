package Algoritms;
//Task 217 Contains Duplicate  https://leetcode.com/problems/contains-duplicate/
//Success
//Runtime: 3 ms, faster than 99.76% of Java online submissions for Contains Duplicate.
//Memory Usage: 42.1 MB, less than 87.45% of Java online submissions for Contains Duplicate.
import java.util.Arrays;

public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new ContainsDuplicate().containsDuplicate(new int[]{1,2,3,1}));
    }
}
