package Algoritms;
//Task 113 Medium. Path Sum II https://leetcode.com/problems/path-sum-ii/
//Success
//Runtime: 2 ms, faster than 34.05% of Java online submissions for Path Sum II.
//Memory Usage: 39.4 MB, less than 40.91% of Java online submissions for Path Sum II.

import java.util.LinkedList;
import java.util.List;

public class PathSumTwo {
    public List<List<Integer>> pathSum(TreeNode root, int sum) { //ODO сделать альтернативный вариант с поиском пути в двусвязном варианте
        if (root == null) return new LinkedList<>();
        TreeNode currentTr = root;
        LinkedList<TreeNode> trStack = new LinkedList<>();

        List<List<Integer>> res = new LinkedList<>();

        ListNode headPath = new ListNode(root.val);
        ListNode currentLn = headPath;
        LinkedList<ListNode> lnStack = new LinkedList<>();

        int currentSum = root.val;
        LinkedList<Integer> sumStack = new LinkedList<>();

        while (currentTr != null || !trStack.isEmpty()) {
            if (currentTr.right != null) {
                trStack.add(currentTr.right);
                lnStack.add(currentLn);
                sumStack.add(currentSum + currentTr.right.val);
            }
            if (currentTr.left != null) {
                currentTr = currentTr.left;
                currentLn.next = new ListNode(currentTr.val);
                currentLn = currentLn.next;
                currentSum += currentTr.val;
                continue;
            }
            if (currentTr.left == null && currentTr.right == null && currentSum == sum) {
                addListFromNodes(res, headPath);
            }

            if (!trStack.isEmpty()) {
                currentTr = trStack.pollLast();
                currentLn = lnStack.pollLast(); // родительский узел
                currentLn.next = new ListNode(currentTr.val);
                currentLn = currentLn.next;
                currentSum = sumStack.pollLast();;
            } else {
                currentTr = null;
            }

        }

        return res;
    }

    private void addListFromNodes(List<List<Integer>> res, ListNode head) {
        LinkedList<Integer> subRes = new LinkedList<>();
        while (head != null) {
            subRes.add(head.val);
            head = head.next;
        }
        res.add(subRes);
    }

    public class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            if (next != null) {
                return val + " " + next.toString();
            } else {
                return val + " ";
            }
        }
    }
}


