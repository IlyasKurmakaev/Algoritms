package Algoritms;
//Task 112 Easy. Path Sum https://leetcode.com/problems/path-sum/
//Success
//Runtime: 1 ms, faster than 16.18% of Java online submissions for Path Sum.
//Memory Usage: 39.4 MB, less than 5.88% of Java online submissions for Path Sum.
import java.util.LinkedList;

public class HasPathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        LinkedList<TreeNode> tnStack = new LinkedList<>();

        LinkedList<Integer> sumStack = new LinkedList<>();

        TreeNode currentTree = root;
        int currentSum = root.val;
        while (currentTree != null) {
            if (currentTree.right != null) {
                int rightSum = currentSum + currentTree.right.val;
                if (rightSum <= sum) {
                    tnStack.add(currentTree.right);
                    sumStack.add(rightSum);
                }
            }

            if (currentTree.left != null) {
                currentSum += currentTree.left.val;
                currentTree = currentTree.left;
                continue;
            }

            if (currentTree.left == null && currentTree.right == null) {
                if (currentSum == sum) {
                    return true;
                }
            }

            if (!tnStack.isEmpty()) {
                currentTree = tnStack.pollLast();
                currentSum = sumStack.pollLast();
            } else {
                currentTree = null;
            }
        }
        return false;
    }
}
