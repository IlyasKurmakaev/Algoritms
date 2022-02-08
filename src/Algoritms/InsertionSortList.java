package Algoritms;
//Task 147 Medium. Insertion Sort List https://leetcode.com/problems/insertion-sort-list/
//Success
//Runtime: 30 ms, faster than 46.07% of Java online submissions for Insertion Sort List.
//Memory Usage: 38.8 MB, less than 53.28% of Java online submissions for Insertion Sort List.
import java.util.HashMap;
import java.util.Map;

public class InsertionSortList {

    private Map<String, ListNode> startEndNodes = new HashMap<>();
    private String startKey = "start";
    private String endKey = "end";
    ListNode headOfResult = null;


    public ListNode insertionSortList(ListNode head) {
        ListNode temp;
        if (head == null) return null;
        while (head != null) {
            if (headOfResult == null) {
                headOfResult = new ListNode(head.val);
                head = head.next;
            } else {
                searchInsertStartEndPoint(head.val, headOfResult);
                temp = head;
                head = head.next;
                insertInList(startEndNodes.get(startKey), temp, startEndNodes.get(endKey));
            }
        }
        return headOfResult;
    }

    private void searchInsertStartEndPoint(int value, ListNode head) {
        while (head != null) {
            if (value >= head.val) {
                if (head.next != null) {
                    if (value <= head.next.val) {
                        startEndNodes.put(startKey, head);
                        startEndNodes.put(endKey, head.next);
                        break;
                    } else {
                        head = head.next;
                    }
                } else {
                    startEndNodes.put(startKey, head);
                    startEndNodes.put(endKey, null);
                    break;
                }
            } else {
                startEndNodes.put(startKey, null);
                startEndNodes.put(endKey, head);
                break;
            }
        }
    }

    private void insertInList(ListNode startNode, ListNode insertNode, ListNode endNode) {
        if (startNode == null) {
            insertNode.next = endNode;
            headOfResult = insertNode;
        } else if (endNode == null) {
            startNode.next = insertNode;
            insertNode.next = null;
        } else {
            startNode.next = insertNode;
            insertNode.next = endNode;
        }
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(4);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(10);
        ListNode listNode4 = new ListNode(2);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        System.out.println(new InsertionSortList().insertionSortList(listNode1));
    }
}