package Algoritms;
//Task 136 Easy. Single Number https://leetcode.com/problems/single-number/
//Success
//Runtime: 100 ms, faster than 5.04% of Java online submissions for Single Number.
//Memory Usage: 39.7 MB, less than 96.30% of Java online submissions for Single Number.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        List<Integer> arr =  Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Integer> alreadyExist = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (alreadyExist.contains(arr.get(i))) {
                alreadyExist.remove(arr.get(i));
            }
            else {
                alreadyExist.add(arr.get(i));
            }
        }
        return alreadyExist.get(0);
    }
}
