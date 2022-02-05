package Algoritms;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        if (next != null) {
            return val + "_" + next.toString();
        }
        else {
            return val + "";
        }
    }

    public static ListNode generateListNode (int num) {
        ListNode dummy = new ListNode(0);
        ListNode start = dummy;
        for (int i = 0; i < num; i++) {
            dummy.next = new ListNode(i + 1);
            dummy = dummy.next;
        }
        return start.next;
    }
}
