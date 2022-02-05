package Algoritms;
//Task 226 Invert Binary Tree https://leetcode.com/problems/invert-binary-tree/
//Success
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Invert Binary Tree.
//Memory Usage: 36.7 MB, less than 16.88% of Java online submissions for Invert Binary Tree.
import java.util.ArrayList;
import java.util.List;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        List<TreeNode> oldNodeList = new ArrayList<>();
        List<TreeNode> newNodeList = new ArrayList<>();
        TreeNode treeNode;
        TreeNode temp;
        oldNodeList.add(root);
        while (!oldNodeList.isEmpty()) {
            for (int i = 0; i < oldNodeList.size(); i++) {
                treeNode = oldNodeList.get(i);
                temp = treeNode.left;
                treeNode.left = treeNode.right;
                treeNode.right = temp;

                if (treeNode.left != null) newNodeList.add(treeNode.left);
                if (treeNode.right != null) newNodeList.add(treeNode.right);
            }
            oldNodeList = newNodeList;
            newNodeList = new ArrayList<>();
        }
        return root;
    }
}
