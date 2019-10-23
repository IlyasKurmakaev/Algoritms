import Algoritms.ListNode;
import Algoritms.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Tools {
    public static int[][] createIntSquareArr(int y, int x) {
        int[][] res = new int[y][x];
        int nums = 1;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                res[i][j] = nums;
                nums++;
            }
        }
//        System.out.println(res.length);
//        System.out.println(res[0].length);
        return res;
    }

    public static void printSquareArr(int[][] argArr) {
        for (int i = 0; argArr.length > i; i++) {
            for (int j = 0; argArr[0].length > j; j++) {
                System.out.print(argArr[i][j]);
                for (int iSpace = 0; iSpace < getLengthOfInt(argArr.length * argArr[0].length) + 1 - getLengthOfInt(argArr[i][j]); iSpace++) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println("_____________");
    }

    public static ListNode generateListNode(String str) {
        ListNode res = new ListNode(0);
        ListNode start = res;
        for (int i = 0; i < str.length(); i++) {
            res.next = new ListNode(Integer.parseInt(str.substring(i, i + 1)));
            res = res.next;
        }
        return start.next;
    }

    public static TreeNode generateTreeNode(String str) {
        if (str == null || str.equals("")) {
            return null;
        }
        List<TreeNode> oldLineList = new ArrayList<>();
        TreeNode head = new TreeNode(Integer.valueOf(str.substring(0, 1)));
        oldLineList.add(head);
        str = str.substring(1);

        while (true) {
            if (!str.equals("")) {
                if (!str.substring(0, 1).equals(" ")) {
                    TreeNode left = new TreeNode(Integer.valueOf(str.substring(0, 1)));
                    oldLineList.add(left);
                    oldLineList.get(0).left = left;
                    str = str.substring(1);
                } else {
                    str = str.substring(1);
                }
            } else return head;
            if (!str.equals("")) {
                if (!str.substring(0, 1).equals(" ")) {
                    TreeNode right = new TreeNode(Integer.valueOf(str.substring(0, 1)));
                    oldLineList.add(right);
                    oldLineList.get(0).right = right;
                    str = str.substring(1);
                    oldLineList.remove(0);
                } else {
                    str = str.substring(1);
                }
            } else return head;
        }
    }

    private static int getLengthOfInt(int arg) {
        return arg == 0 ? 1 : (int) Math.log10(arg) + 1;
    }

    public static void main(String[] args) {
        System.out.println(getLengthOfInt(0));
    }
}
