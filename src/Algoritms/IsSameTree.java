package Algoritms;
//Task 100 Easy. Same Tree https://leetcode.com/problems/same-tree/
//Success
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Same Tree.
//Memory Usage: 36.9 MB, less than 5.75% of Java online submissions for Same Tree.
import java.util.LinkedList;

public class IsSameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if ( p == null || q == null) {
            if ((p == null) && (q == null)) {
                return true;
            }
            else {
                return false;
            }
        }

        LinkedList<TreeNode> bufferP = new LinkedList<>();
        LinkedList<TreeNode> bufferQ = new LinkedList<>();

        while (p != null || !bufferP.isEmpty()) {
            if (p.val != q.val) {
                return false;
            }

            if (p.right != null) { //добавление правых ветвей в буффер
                if (q.right != null) {
                    bufferP.add(p.right);
                    bufferQ.add(q.right);
                } else return false;
            } else {
                if (q.right != null) return false;
            }

            if (p.left != null) {
                if (q.left != null) {
                    p = p.left;
                    q = q.left;
                } else return false;

            } else { // (p.left == null)
                if (q.left == null) {
                    p = bufferP.pollFirst();
                    q = bufferQ.pollFirst();
                } else return false;
            }
        }
        return true;
    }
}