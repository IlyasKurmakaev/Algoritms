package Algoritms;
//169 Majority Element https://leetcode.com/problems/majority-element/
//Success
//Runtime: 9 ms, faster than 30.13% of Java online submissions for Majority Element.
//Memory Usage: 43.9 MB, less than 39.95% of Java online submissions for Majority Element.
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums.length == 0) return 0;
        Map<Integer, Integer> countOfNumsMap = new HashMap<>();
        int tempNum;
        for (int i = 0; i < nums.length; i++) {
            tempNum = nums[i];
            if (! countOfNumsMap.containsKey(tempNum)) {
                countOfNumsMap.put(tempNum, 1);
            } else {
                countOfNumsMap.put(tempNum, countOfNumsMap.get(tempNum) + 1);
            }
        }
        Map.Entry<Integer, Integer> tempEntry = null;
        for (Map.Entry<Integer, Integer> entry : countOfNumsMap.entrySet()) {
            if (tempEntry == null) {
                tempEntry = entry;
            } else {
                if (tempEntry.getValue() < entry.getValue()) {
                    tempEntry = entry;
                }
            }
        }
        return tempEntry.getKey();
    }

    public static void main(String[] args) {
        System.out.println(new MajorityElement().majorityElement(new int[] {3, 2, 3}));
    }
}
