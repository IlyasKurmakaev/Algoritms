package Algoritms;
//Task 104 Easy. Maximum Depth of Binary Tree https://leetcode.com/problems/maximum-depth-of-binary-tree/
//Success
//Runtime: 1 ms, faster than 12.64% of Java online submissions for Maximum Depth of Binary Tree.
//Memory Usage: 39.2 MB, less than 94.62% of Java online submissions for Maximum Depth of Binary Tree.
import java.util.LinkedList;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int res = 0;
        LinkedList<TreeNode> current = new LinkedList<>();
        LinkedList<TreeNode> childrens = new LinkedList<>();
        current.add(root);

        while (!current.isEmpty()) {
            for (TreeNode tr : current) {
                if (tr.left != null) {
                    childrens.add(tr.left);
                }
                if (tr.right != null) {
                    childrens.add(tr.right);
                }
            }

            current = childrens;
            childrens = new LinkedList<>();
            res++;
        }
        return res;
    }
}
