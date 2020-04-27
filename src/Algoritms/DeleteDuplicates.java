package Algoritms;
//Task 83 Easy. Remove Duplicates from Sorted List   https://leetcode.com/problems/remove-duplicates-from-sorted-list/
//Success
//Runtime: 1 ms, faster than 24.98% of Java online submissions for Remove Duplicates from Sorted List.
//Memory Usage: 36.2 MB, less than 100.00% of Java online submissions for Remove Duplicates from Sorted List.
public class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode start = head;
        ListNode nodeForSearchDuplicates = null;
        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                nodeForSearchDuplicates = head;
                while (nodeForSearchDuplicates.next != null &&  nodeForSearchDuplicates.val == nodeForSearchDuplicates.next.val) {
                    nodeForSearchDuplicates = nodeForSearchDuplicates.next;
                }
                head.next = nodeForSearchDuplicates.next;
            }
            else {
                head = head.next;
            }
        }
        return start;
    }
}
