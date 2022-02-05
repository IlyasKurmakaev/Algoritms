package Algoritms;
//Task 160 Intersection of Two Linked Lists https://leetcode.com/problems/intersection-of-two-linked-lists/
//Success but bad results
//Runtime: 8 ms, faster than 13.07% of Java online submissions for Intersection of Two Linked Lists.
//Memory Usage: 43.2 MB, less than 12.96% of Java online submissions for Intersection of Two Linked Lists.
import Tools.TreeTools.SmallTreeTools;

import java.util.HashSet;
import java.util.Set;

public class GetIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> alreadyPassedNodes = new HashSet<>();
        ListNode tempHeadB = headB;
        while (headA != null) {
            alreadyPassedNodes.add(headA);
            headA = headA.next;

            if (headB != null) {
                if (alreadyPassedNodes.contains(headB)) {
                    return researchInAlreadyPassedNodes(alreadyPassedNodes, headB);
                }
                headB = headB.next;
            } else {
                headB = tempHeadB;
            }
        }
        return researchInAlreadyPassedNodes(alreadyPassedNodes, tempHeadB);
    }

    private ListNode researchInAlreadyPassedNodes(Set<ListNode> alreadyPassedNodes, ListNode headB) {
        while (headB != null) {
            if (alreadyPassedNodes.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode headA = new SmallTreeTools().makeLinkedListFromLeetCodeString("[1,9,1,2,4]");
        ListNode headB = new SmallTreeTools().makeLinkedListFromLeetCodeString("[3,2,4]");
        System.out.println(new GetIntersectionNode().getIntersectionNode(headA, headB));
    }
}
