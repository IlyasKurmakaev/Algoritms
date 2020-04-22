package Algoritms;
//Task 102 Medium. Binary Tree Level Order Traversal https://leetcode.com/problems/binary-tree-level-order-traversal/
//Success
//Runtime: 1 ms, faster than 56.29% of Java online submissions for Binary Tree Level Order Traversal.
//Memory Usage: 39.4 MB, less than 5.33% of Java online submissions for Binary Tree Level Order Traversal.

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LevelOrder {
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        if (root == null) return new LinkedList<>();
//        LinkedList<List<Integer>> res = new LinkedList<>();
//        LinkedList<TreeNode> current = new LinkedList<>();
//        LinkedList<TreeNode> childrens = new LinkedList<>();
//
//        current.add(root);
//
//        while (!current.isEmpty()) {
//            for (TreeNode tr : current) {
//                if (tr.left != null) {
//                    childrens.add(tr.left);
//                }
//                if (tr.right != null) {
//                    childrens.add(tr.right);
//                }
//            }
//
//            res.add(current.stream().map(p -> p.val).collect(Collectors.toList()));
////            res.add(new LinkedList<>()); //без стримов
////            for (TreeNode tr : current) {
////                res.peekLast().add(tr.val);
////            }
//
//            current = childrens;
//            childrens = new LinkedList<>();
//        }
//        return res;
//    }
}
