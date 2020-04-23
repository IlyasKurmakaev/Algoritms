package Algoritms;
//Task 107 Easy. Binary Tree Level Order Traversal II https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
//Success
//Runtime: 1 ms, faster than 81.52% of Java online submissions for Binary Tree Level Order Traversal II.
//Memory Usage: 39.7 MB, less than 5.00% of Java online submissions for Binary Tree Level Order Traversal II.

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LevelOrderBottom {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return new LinkedList<>();
        LinkedList<List<Integer>> res = new LinkedList<>();
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

//            res.add(current.stream().map(p -> p.val).collect(Collectors.toList()));
            res.addFirst(new LinkedList<>()); //без стримов
            for (TreeNode tr : current) {
                res.peekFirst().add(tr.val);
            }

            current = childrens;
            childrens = new LinkedList<>();
        }
        return res;
    }
}
