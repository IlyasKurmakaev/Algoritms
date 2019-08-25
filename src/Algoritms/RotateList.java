package Algoritms;
//Task 61 Medium. Rotate List   https://leetcode.com/problems/rotate-list/
//Success
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Rotate List.
//Memory Usage: 38.2 MB, less than 65.52% of Java online submissions for Rotate List.

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        ListNode firstNode = head;
        ListNode lastElement = null;
        int length = 0;
        while (head != null) {
            if (head.next == null) {
                lastElement = head;
            }
            head = head.next;
            length ++;
        }
        lastElement.next = firstNode;

        k = k % length;
        for (int i = 0; i < length - 1 - k; i++) {
            firstNode = firstNode.next;
        }
        ListNode newFirst = firstNode.next;
        firstNode.next = null;
        return newFirst;
    }
}
