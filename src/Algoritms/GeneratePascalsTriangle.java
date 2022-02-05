package Algoritms;
//Task 118 Easy. Pascal's Triangle https://leetcode.com/problems/pascals-triangle/
//Success
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Pascal's Triangle.
//Memory Usage: 37.5 MB, less than 6.02% of Java online submissions for Pascal's Triangle.
import java.util.LinkedList;
import java.util.List;

public class GeneratePascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        LinkedList<List<Integer>> res = new LinkedList<>();
        if (numRows == 0) return res;
        res.add(new LinkedList<>());
        res.getLast().add(1);
        if (numRows == 1) return res;
        res.add(new LinkedList<>());
        res.getLast().add(1);
        res.getLast().add(1);
        if (numRows == 2) return res;
        List<Integer> prev = res.getLast();
        List<Integer> current;

        for (int iVert = 2; iVert < numRows; iVert++) {
            current = new LinkedList<>();
            current.add(1);
            System.out.println(1);//DEBUG
            current.add(1, iVert);

            for (int j = 2; j < prev.size() - 1; j++) {
                current.add(prev.get(j - 1) + prev.get(j));
            }
            if ((prev.size() - 1) == current.size() - 1) {
                current.set(prev.size() - 1, iVert);
            } else {
                current.add(prev.size() - 1, iVert);
            }
            current.add(1);

            prev = current;
            res.add(current);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new GeneratePascalsTriangle().generate(4));
    }

}
