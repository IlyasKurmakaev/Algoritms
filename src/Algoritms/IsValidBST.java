//Task 98 Validate Binary Search Tree https://leetcode.com/problems/validate-binary-search-tree/
//Sucess
//Runtime: 2 ms, faster than 9.00% of Java online submissions for Validate Binary Search Tree.
//Memory Usage: 41.1 MB, less than 5.58% of Java online submissions for Validate Binary Search Tree.
package Algoritms;

import java.util.ArrayList;
import java.util.List;

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        BoundedTreeNode bRoot = new BoundedTreeNode(root, null, null);
        List<BoundedTreeNode> buffer = new ArrayList<>();

        while (bRoot != null) {
            if (bRoot.right != null) {
                if (bRoot.right.val > bRoot.tr.val && (bRoot.min == null || bRoot.right.val > bRoot.min) && (bRoot.max == null || bRoot.right.val < bRoot.max)) {
                    buffer.add(new BoundedTreeNode(bRoot.right, bRoot.tr.val, bRoot.max));
                } else {
                    return false;
                }
            }
            if (bRoot.left != null) {
                if (bRoot.left.val < bRoot.tr.val && (bRoot.min == null || bRoot.left.val > bRoot.min) && (bRoot.max == null || bRoot.left.val < bRoot.max)) {
                    bRoot = new BoundedTreeNode(bRoot.left, bRoot.min, bRoot.tr.val);
                } else {
                    return false;
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
        }
        return true;
    }

//    @Deprecated
//    public boolean isValidBST(TreeNode root) {
//        if (root == null) {
//            return true;
//        }
//        List<TreeNode> buffer = new ArrayList<>();
//        while (true) {
//            if (root.left != null) {
//                if (root.left.val >= root.val) {
//                    return false;
//                }
//            }
//
//            if (root.right != null) {
//                if (root.right.val <= root.val) {
//                    return false;
//                }
//            }
//
//            if (root.left != null) {
//                if (root.right != null) {
//                    buffer.add(root.right);
//                }
//                root = root.left;
//            } else {
//                if (buffer.size() == 0) {
//                    return true;
//                }
//                root = buffer.get(0);
//                buffer.remove(0);
//            }
//        }
//    }


    class BoundedTreeNode {
        public final TreeNode tr;
        public final Integer min;
        public final Integer max;
        public final TreeNode left;
        public final TreeNode right;

        public BoundedTreeNode(TreeNode treeNode, Integer min, Integer max) {
            this.tr = treeNode;
            left = tr.left;
            right = tr.right;
            this.min = min;
            this.max = max;
        }

        @Override
        public String toString() {
            String val = tr.val + " ";
            val += tr.left != null ? "L" + tr.left.val + " " : "L.";
            val += tr.right != null ? "R" + tr.right.val : "R.";
            return val;
        }
    }

    public void sout(TreeNode treeNode) {

        List<TreeNode> buffer = new ArrayList<>();
        buffer.add(treeNode);
        int sizeOfBuffer = buffer.size();
        while (buffer.size() != 0) {
            for (int i = 0; i < sizeOfBuffer; i++) {
                System.out.print("|" + treeNode.val + " ");

                if (treeNode.left != null) {
                    buffer.add(treeNode.left);
                    System.out.print(treeNode.left.val + " ");
                }
                if (treeNode.right != null) {
                    buffer.add(treeNode.right);
                    System.out.print(treeNode.right.val + " ");
                }
                System.out.print("|");

                buffer.remove(0);

                if (buffer.size() != 0 && buffer.get(0) != null) {
                    treeNode = buffer.get(0);
                }
            }
            System.out.println();
            sizeOfBuffer = buffer.size();
        }
    }
}
