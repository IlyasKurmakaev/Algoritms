package Algoritms;
//Task 120 Medium. Triangle //https://leetcode.com/problems/triangle/
//Success
//Runtime: 4 ms, faster than 33.25% of Java online submissions for Triangle.
//Memory Usage: 39.9 MB, less than 8.16% of Java online submissions for Triangle.

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        ArrayList<Integer> previousWeights;
        ArrayList<Integer> currentWeights = new ArrayList<>();

        currentWeights.add(triangle.get(0).get(0));

        List<Integer> currentTriangleLvl;

        for (int vertI = 1; vertI < triangle.size(); vertI++) {
            currentTriangleLvl = triangle.get(vertI);

            previousWeights = currentWeights;
            currentWeights = new ArrayList();
            int localWeight = previousWeights.get(0);
            currentWeights.add(localWeight + currentTriangleLvl.get(0));

            for (int horI = 1; horI < currentTriangleLvl.size() - 1; horI++) {
                if (previousWeights.get(horI - 1) < previousWeights.get(horI)) {
                    currentWeights.add(previousWeights.get(horI - 1) + currentTriangleLvl.get(horI));
                } else { // > || ==
                    currentWeights.add(previousWeights.get(horI) + currentTriangleLvl.get(horI));
                }
            }

            localWeight = previousWeights.get(previousWeights.size() - 1);
            currentWeights.add(localWeight + currentTriangleLvl.get(currentTriangleLvl.size() - 1));

        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < currentWeights.size(); i++) {
            if (min > currentWeights.get(i)) min = currentWeights.get(i);
        }
        return min;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(new ArrayList<>(Arrays.asList(1)));
        triangle.add(new ArrayList<>(Arrays.asList(2,3)));
        triangle.add(new ArrayList<>(Arrays.asList(4,1,6)));
        System.out.println(new MinimumTotal().minimumTotal(triangle));
    }
}
