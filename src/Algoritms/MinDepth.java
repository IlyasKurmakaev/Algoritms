package Algoritms;
//Task 111 Easy. Minimum Depth of Binary Tree https://leetcode.com/problems/minimum-depth-of-binary-tree/
//Runtime: 1 ms, faster than 9.63% of Java online submissions for Minimum Depth of Binary Tree.
//Memory Usage: 41.4 MB, less than 6.25% of Java online submissions for Minimum Depth of Binary Tree.
import java.util.LinkedList;

public class MinDepth {
    public int minDepth(TreeNode root) {
        if(root == null) return 0;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        TreeNode tNCurrent;
        int size;
        int height = 1;
        while (true) {
            size = stack.size();
            for (int i = 0; i < size; i++) {
                tNCurrent = stack.pollFirst();
                if (tNCurrent.left != null) stack.addLast(tNCurrent.left);
                if (tNCurrent.right != null) stack.addLast(tNCurrent.right);
                if (tNCurrent.left == null && tNCurrent.right == null) return height;
            }
            height++;
        }
    }
}
