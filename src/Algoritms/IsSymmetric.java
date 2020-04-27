package Algoritms;
//Task 101 Easy. Symmetric Tree https://leetcode.com/problems/symmetric-tree/
//Success
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Symmetric Tree.
//Memory Usage: 37.7 MB, less than 73.47% of Java online submissions for Symmetric Tree.

import java.util.LinkedList;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        TreeNode leftTree = null;
        TreeNode rightTree = null;

        LinkedList<TreeNode> buffer = new LinkedList<>();
        if (!((root.left == null) == (root.right == null))) return false; //если null асиметричен

        if (root.left != null && root.right != null) { //если оба не null
            leftTree = root.left;
            rightTree = root.right;
        }


        while (!buffer.isEmpty() || leftTree != null) {
            if (leftTree.val != rightTree.val) return false;

            if (leftTree.right != null) {
                if (rightTree.left != null) {
                    buffer.add(leftTree.right);
                    buffer.add(rightTree.left);
                } else return false;
            } else {
                if (rightTree.left != null) {
                    return false;
                }
            }

            if (leftTree.left != null) {
                if (rightTree.right != null) {
                    leftTree = leftTree.left;
                    rightTree = rightTree.right;
                } else return false;
            } else {
                if (rightTree.right == null) {
                    leftTree = buffer.pollFirst();
                    rightTree = buffer.pollFirst();
                }
                else return false;
            }
        }
        return true;
    }
}
