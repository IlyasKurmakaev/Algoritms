package Algoritms;
//Task 92 Medium. Reverse Linked List II https://leetcode.com/problems/reverse-linked-list-ii/
//Success
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
//Memory Usage: 34.5 MB, less than 100.00% of Java online submissions for Reverse Linked List II.

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode start = dummy;
        ListNode currentPosition = dummy;
        ListNode nextPosition = dummy;
        ListNode backPosition = null;
        ListNode preReverce = null;
        ListNode firstReverce = null;
        ListNode endReverce = null;
        int i = 0;

        while (true) {
            currentPosition = nextPosition;
            if (nextPosition == null) {
                preReverce.next = endReverce;
                break;
            }
            nextPosition = currentPosition.next;
            if (i == m - 1) {
                preReverce = currentPosition;
            }
            else if (i == m) {
                firstReverce = currentPosition;
                firstReverce.next = null;
            }
            else if (m < i && i <= n) {
                currentPosition.next = backPosition;
                if (i == n) {
                    endReverce = currentPosition;
                }
            }
            else if (i > n) {
                preReverce.next = endReverce;
                firstReverce.next = currentPosition;
                break;
            }
            i++;
            backPosition = currentPosition;
        }
        return start.next;
    }
}
