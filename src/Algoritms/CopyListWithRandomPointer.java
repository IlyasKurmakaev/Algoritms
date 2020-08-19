package Algoritms;
//Success
//138 Medium. Copy List with Random Pointer https://leetcode.com/problems/copy-list-with-random-pointer/
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Copy List with Random Pointer.
//Memory Usage: 39.1 MB, less than 82.48% of Java online submissions for Copy List with Random Pointer.

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class CopyListWithRandomPointer {
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Map<Node, Integer> firstNumNodeMap = new HashMap<>();
        int i = 0;
        Node firstINode = head;
        while (firstINode != null) {
            firstNumNodeMap.put(firstINode, i);
            i++;
            firstINode = firstINode.next;
        }

        List<Node> secondListNodes = new ArrayList<>();
        Node secondHead = new Node(head.val);
        Node secondFirstNode = secondHead;
        secondListNodes.add(secondHead);
        firstINode = head.next;
        while (firstINode != null) {
            secondFirstNode.next = new Node(firstINode.val);
            secondFirstNode = secondFirstNode.next;
            secondListNodes.add(secondFirstNode);
            firstINode = firstINode.next;
        }

        firstINode = head;
        Node secondINode = secondHead;
        while (firstINode != null) {
            int numOfPointer;
            if (firstINode.random != null) {
                numOfPointer = firstNumNodeMap.get(firstINode.random);
                secondINode.random = secondListNodes.get(numOfPointer);
            }
            firstINode = firstINode.next;
            secondINode = secondINode.next;
        }
        return secondHead;
    }

    private Node makeRandomTestCase(int lengthOfNodesStreak) {
        if (lengthOfNodesStreak == 0) return null;
        Node head = new Node(0);
        List<Node> listNodes = new ArrayList<>();
        listNodes.add(head);

        Node newNode;
        Node previousNode = head;
        for (int i = 0; i < lengthOfNodesStreak - 1; i++) {
            newNode = new Node(i + 1); // так как head.val уже занял индекс 0
            previousNode.next = newNode;
            previousNode = newNode;
            listNodes.add(newNode);
        }

        for (int i = 0; i < lengthOfNodesStreak; i++) {
            int rand = new Random().nextInt(lengthOfNodesStreak + 1);
            if (rand != lengthOfNodesStreak) { //если не указывает на null
                listNodes.get(i).random = listNodes.get(rand);
            }
        }
        return head;
    }

    @Test
    public void bruteForceTest() {
        Node head;
        for (int i = 0; i < 100000; i++) {
            head = makeRandomTestCase(new Random().nextInt(100));
            compareNodesStreack(copyRandomList(head), head);
        }
    }

    @Test
    public void testFromLeetCode() {
        List<Node> listNodes = new ArrayList<>();
        listNodes.add(new Node(7));
        listNodes.add(new Node(13));
        listNodes.add(new Node(11));
        listNodes.add(new Node(10));
        listNodes.add(new Node(1));

        for (int i = 0; i < listNodes.size() - 1; i++) {
            listNodes.get(i).next = listNodes.get(i + 1);
        }

        listNodes.get(1).random = listNodes.get(0);
        listNodes.get(2).random = listNodes.get(4);
        listNodes.get(3).random = listNodes.get(2);
        listNodes.get(4).random = listNodes.get(0);

        compareNodesStreack(copyRandomList(listNodes.get(0)), listNodes.get(0));
    }

    private void compareNodesStreack(Node firstNode, Node secondNode) {
        while (firstNode != null) {
            if (firstNode == secondNode) {
                Assert.fail("Ссылки указывают на один и тот же объект (это не копия)");
            }
            if (secondNode == null) {
                Assert.fail("Вторая последовательность закончилась, когда первая была на позиции: " + firstNode.val);
            }
            if (firstNode.val != secondNode.val) {
                Assert.fail("Значения не равны, первая последовательность: " + firstNode.val + " Вторая последовательнсоть: " + secondNode.val);
            }

            if ((firstNode.random != null) && (secondNode.random != null)) {
               if (firstNode.random.val != secondNode.random.val) {
                   Assert.fail("Значения рандомных частей не равны: " + firstNode.random.val + " " + secondNode.random.val);
               }
            } else if ((firstNode.random == null) != (secondNode.random == null)){
                Assert.fail("Одна из рандомных частей равна null, другая нет: " + firstNode.random + "  " + secondNode.random);
            }

            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }

        if (secondNode != null) {
            Assert.fail("Вторая последовательность длиннее первой, первый \"выпирающий\" элемент; " + secondNode.val);
        }
    }
}
