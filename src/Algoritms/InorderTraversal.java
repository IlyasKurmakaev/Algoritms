package Algoritms;
//Task 94 Binary Tree Inorder Traversal   https://leetcode.com/problems/binary-tree-inorder-traversal/
//Success
//Runtime: 1 ms, faster than 56.82% of Java online submissions for Binary Tree Inorder Traversal.
//Memory Usage: 34.8 MB, less than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<TreeNode> stack = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        stack.add(root);
        TreeNode currentTree = null;
        while (!stack.isEmpty()) {
            currentTree = stack.get(0);
            if (currentTree.left != null) {
                stack.add(0, currentTree.left);
                continue;
            } else if (currentTree.left == null) {
                stack.remove(currentTree); // index 0
                res.add(currentTree.val);
                if (!stack.isEmpty() && stack.get(0).left != null) { //самый тонкий момент задачи, удаление текущего из ветки родительского тела. если левый элемент уже удалён, то текущий элемент является потомком уже удалённого родителя
                    stack.get(0).left = null;                        // а ещё тут двоеное и критически важно )
                }
                if (currentTree.right != null) {
                    stack.add(0, currentTree.right);
                }
            }
        }
        return res;
    }
}