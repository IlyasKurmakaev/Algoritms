package Algoritms;
//Task 86 Medium. Partition List    https://leetcode.com/problems/partition-list/submissions/
//Success
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Partition List.
//Memory Usage: 35.7 MB, less than 100.00% of Java online submissions for Partition List.
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyForSmall = new ListNode(0);
        ListNode startForSmall = dummyForSmall;

        ListNode dummyForBig = new ListNode(0);
        ListNode startForBig = dummyForBig;

        while (head != null) {
            if (head.val < x) {
                dummyForSmall.next = head;
                dummyForSmall = dummyForSmall.next;
            } else {
                dummyForBig.next = head;
                dummyForBig = dummyForBig.next;
            }
                head = head.next;
        }
        dummyForSmall.next = startForBig.next;
        dummyForBig.next = null;
        return startForSmall.next;
    }
}
