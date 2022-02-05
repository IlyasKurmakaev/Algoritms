//package Algoritms;
//
//public class DetectCycle {
//    public ListNode detectCycle(ListNode head) { //O(1)
//        if (head == null) {
//            return null;
//        }
//        if (head == head.next) {
//            return head;
//        }
//
//        ListNode current = head;
//        ListNode anchor = head.next;
//        int currentStep = 1;
//        Number distanceOffCircle = new Number(0); //0 - placeholder
//
//        while (true) {
//            current = getNextNodeByStep(current, currentStep);
//            if (checkNodes(current, currentStep, distanceOffCircle) != null) {
//                //TODO
//            } else {
//                currentStep += currentStep;
//            }
//        }
//
//        return null;
//    }
//
//    private ListNode getNextNodeByStep(ListNode node, int step) {
//        for (int i = 0; i < step; i++) {
//            if (node == null) throw new RuntimeException("Итерация по односвязному списку закончилась null-ом");
//            node = node.next;
//        }
//        return node;
//    }
//
//    private ListNode checkNodes(ListNode node, int distance, Number distanceOffCircle) {
//        ListNode head = node;
//        if (head == head.next) {
//            return node;
//        }
//        for (int i = 0; i < distance; i++) {
//            node = node.next;
//            if (head == node) {
//                distanceOffCircle.num = i + 1;
//                return head;
//            }
//        }
//        return null;
//    }
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//    public static void main(String[] args) {
//        new DetectCycle().detectCycle(null);
//    }
//
//    class Number {
//        public int num; //здесь инкапсуляция не нужна
//        public Number(int num) {
//            this.num = num;
//        }
//    }
//}
