package Algoritms;
//Task 114 Easy. Flatten Binary Tree to Linked List https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
//Success
//Runtime: 1 ms, faster than 30.29% of Java online submissions for Flatten Binary Tree to Linked List.
//Memory Usage: 39.5 MB, less than 14.54% of Java online submissions for Flatten Binary Tree to Linked List.
import Tools.TreeTools.ShowTree.DebugTools;

import java.util.LinkedList;

public class Flatten {
    public void flatten(TreeNode root) {
        if (root == null) return;

        LinkedList<TreeNode> stackTr = new LinkedList<>();
        TreeNode current = root;

        while (current != null || !stackTr.isEmpty()) {
            if (current.right != null) {
                stackTr.add(current.right);
            }

            if (current.left != null) {
                current.right = current.left;
                current.left = null;
                current = current.right;
                continue;
            } else {
                if (!stackTr.isEmpty()) {
                    current.right = stackTr.pollLast();
                    current.left = null;
                    current = current.right;
                } else {
                    current = null;
                }
            }
        }
        return;
    }

    public static void main(String[] args) {
        TreeNode tr = DebugTools.getTreeNode("[1,2,5,3,4,null,6]");
        DebugTools.showInCode(Flatten.class, tr);
        new Flatten().flatten(tr);
        DebugTools.showInCode(Class.class.getClasses(), tr);
        System.out.println("end");
    }
}