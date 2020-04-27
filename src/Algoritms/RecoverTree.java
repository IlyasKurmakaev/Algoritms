package Algoritms;
//Task 99 Hard. Recover Binary Search Tree https://leetcode.com/problems/recover-binary-search-tree/
//Success
//Runtime: 11 ms, faster than 5.82% of Java online submissions for Recover Binary Search Tree.
//Memory Usage: 39.7 MB, less than 80.77% of Java online submissions for Recover Binary Search Tree.
import java.util.ArrayList;
import java.util.List;

public class RecoverTree {
    public void recoverTree(TreeNode root) {
        isValidBST(root);
    }

    public void isValidBST(TreeNode root) {
        if (root == null) return;
        TreeNode startNode = root;
        BoundedTreeNode bRoot = new BoundedTreeNode(root, null, null, null);
        List<BoundedTreeNode> buffer = new ArrayList<>();
        List<TreeNode> wrongNodes = new ArrayList<>();

        while (bRoot != null) {
            if (bRoot.right != null) {
                if (bRoot.right.val > bRoot.tr.val && (bRoot.min == null || bRoot.right.val > bRoot.min) && (bRoot.max == null || bRoot.right.val < bRoot.max)) {
                    buffer.add(new BoundedTreeNode(bRoot.right, bRoot.tr.val, bRoot.max, bRoot));
                } else {
                    wrongNodes.add(bRoot.tr);
                    wrongNodes.add(bRoot.right);
                }
            }
            if (bRoot.left != null) {
                if (bRoot.left.val < bRoot.tr.val && (bRoot.min == null || bRoot.left.val > bRoot.min) && (bRoot.max == null || bRoot.left.val < bRoot.max)) {
                    bRoot = new BoundedTreeNode(bRoot.left, bRoot.min, bRoot.tr.val, bRoot);
                } else {
                    wrongNodes.add(bRoot.tr);
                    wrongNodes.add(bRoot.left);
                }
            } else {
                if (buffer.size() != 0) {
                    bRoot = buffer.get(0);
                    buffer.remove(0);
                }
                else {
                    bRoot = null;
                }
            }
            if (wrongNodes.size() == 2 || wrongNodes.size() == 4) {
                int temp = wrongNodes.get(0).val;
                wrongNodes.get(0).val = wrongNodes.get(1).val;
                wrongNodes.get(1).val = temp;
                bRoot = new BoundedTreeNode(startNode, null, null, null);
                wrongNodes.clear();
                buffer.clear();
            }
        }
    }

    class BoundedTreeNode {
        public final TreeNode tr;
        public final Integer min;
        public final Integer max;
        public final TreeNode left;
        public final TreeNode right;
        public final BoundedTreeNode back;
        public BoundedTreeNode(TreeNode treeNode, Integer min, Integer max, BoundedTreeNode back) {
            this.tr = treeNode;
            left = tr.left;
            right = tr.right;
            this.min = min;
            this.max = max;
            this.back = back;
        }

        @Override
        public String toString() {
            String val = tr.val + " ";
            val += tr.left != null ? "L" + tr.left.val + " " : "L.";
            val += tr.right != null ? "R" + tr.right.val : "R.";
            return val;
        }
    }

}
