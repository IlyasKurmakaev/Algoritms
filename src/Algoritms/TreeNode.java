package Algoritms;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        String strLeft = left != null ? left.val + "" : "null";
        String strRight = right != null ? right.val + "" : "null";
        return "TreeNode{" +
                "val=" + val +
                ", left=" + strLeft +
                ", right=" + strRight +
                '}';
    }
}
