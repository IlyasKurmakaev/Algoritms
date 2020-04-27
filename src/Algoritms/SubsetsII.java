package Algoritms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SubsetsII { //неправильно понял задание https://leetcode.com/problems/subsets-ii/
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        for (int iStart = 0; iStart < nums.length; iStart++) {                     //выдаём плавающее начало
            for (int iEnd = nums.length - 1; iEnd >= iStart ; iEnd--) {            // выдаём плавающий конец
                List<Integer> subRes = new ArrayList<>();
                for (int iAdd = iStart; iAdd <= iEnd; iAdd++) {                    // добавляем число начиная с плавающего начала
                    subRes.add(nums[iAdd]);
                }
                set.add(subRes);
            }
        }
        set.add(new ArrayList<>());

        return new ArrayList<>(set);
    }
}
