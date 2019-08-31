import Algoritms.*;
import com.sun.javafx.scene.traversal.Algorithm;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
        System.out.println(new PartitionList().partition(Tools.generateListNode("45389157"), 3));

        //        System.out.println(new DeleteDuplicates().deleteDuplicates(Tools.generateListNode("11233")));
        //        System.out.println(new RotateList().rotateRight(ListNode.generateListNode(4), 1));
//        System.out.println(new LengthOfLastWord().lengthOfLastWord("a"));

//        Tools.printSquareArr(new Algoritms.Solution().generateMatrix(3));

//___________________________________________
//        int[][] inArr = new int[2][2];
//        inArr[0][0] = 1;
//        inArr[0][1] = 3;
//        inArr[1][0] = 6;
//        inArr[1][1] = 9;
//
//        int[] secondArr = new int[2];
//        secondArr[0] = 2;
//        secondArr[1] = 5;
//        Tools.printSquareArr(new Algoritms.Solution().insert(inArr, secondArr));
        //______________________________________________
//        int[][] inArr = new int[3][2];
////        inArr[0][0] = 1;
////        inArr[0][1] = 4;
////        inArr[1][0] = 0;
////        inArr[1][1] = 2;
////        inArr[2][0] = 3;
////        inArr[2][1] = 5;
//        inArr[0][0] = 0;
//        inArr[0][1] = 1;
//        inArr[1][0] = 1;
//        inArr[1][1] = 4;
//        inArr[2][0] = 5;
//        inArr[2][1] = 6;
//        //int[][] inArr = Tools.createIntSquareArr(5,2);
//        Tools.printSquareArr(new Algoritms.Solution().merge(inArr));

        //_________________________________________________
//        System.out.println(new Algoritms.Solution().canJump(new int[]{4,2,0,0,1,1,4,4,4,0,4,0}));
////        System.out.println(new Algoritms.Solution().canJump(new int[]{1,1,1,0}));
//        System.out.println(new Algoritms.Solution().canJump(new int[]{3,2,1,0,4}));

//____________________________________________________________________________________________________________________
//        int[][] inArr = Tools.createIntSquareArr(2,10);
//        Tools.printSquareArr(inArr);
//        List<Integer> res = new Algoritms.Solution().spiralOrder(inArr);
//        for (int intPartRes : res) {
//            System.out.print(intPartRes + " ");
//        }
        //____________________________________________________________
//        //List<List<String>> res = new Algoritms.Solution().groupAnagrams(new String[]{"tea","and","ace","ad","eat","dans"});
//        //List<List<String>> res = new Algoritms.Solution().groupAnagrams(new String[]{"tea","","eat","","tea",""});
//        List<List<String>> res = new Algoritms.Solution().groupAnagrams(new String[]{"abc","bca", "cba", "avc", "vca", "qqq", "", ""});
//        for (List<String> arrStr : res) {
//            for (String str : arrStr) {
//                System.out.print(str + " ");
//            }
//            System.out.println();
//        }
        //_________________________________________
        // System.out.println(new Algoritms.Solution().myPow(2.00000, -2147483648));
       //__________________________________________
        // System.out.println(new Algoritms.Solution().divide(-2147483648, -1));
        //___________________
//        new Algoritms.Solution().multiply("123", "456");
        //_________________
        // System.out.println(new Algoritms.Solution().isPalindrome(0));
//        __________________________________________
//        Algoritms.ListNode listNode1 = new Algoritms.ListNode(5);
//        Algoritms.ListNode listNode2 = new Algoritms.ListNode(5);
//        System.out.println(new Algoritms.Solution().addTwoNumbers2(Algoritms.ListNode.generateListNode(243), Algoritms.ListNode.generateListNode(564)));
        //___________________________________________________
        //        int[] arr1 = new int[]{5, 7, 7, 8, 8, 10};
//        int target1 = 8;
//
//        int[] arr2 = new int[]{5,7,7,8,8,10};
//        int target2 = 6;
//
//        int[] arr3 = new int[]{1};
//        int target3 = 1;
//
//        int[] arr4 = new int[]{2, 2};
//        int target4 = 1;
//
//        int[] arr5 = new int[]{1, 4};
//        int target5 = 4;
//
//        int[] arr6 = new int[]{3,3,3};
//        int target6 = 3;
//
//        int[] arr7 = new int[]{1,2,3,3,3,3,4,5,9};
//        int target7 = 3;
//        int[] res = new Algoritms.Solution().searchRange(arr7, target7);
//        for (int re : res) {
//            System.out.print(re + " ");
//        }
//_____________________________________________

        //new Algoritms.Solution().printMatrix();
        //        System.out.println(new Algoritms.Solution().strStr("aaa", "aaaa"));
//        int[] a = {2,5};
//        System.out.println(new Algoritms.Solution().searchInsert(a, 1));


//        Algoritms.ListNode listNode = new Algoritms.ListNode(1);
//        Algoritms.ListNode start = listNode;
//        listNode.next = new Algoritms.ListNode(2);
////        listNode.next.next = new Algoritms.ListNode(3);
//       for (int i = 2; i <= 5; i++) {
//           listNode.next = new Algoritms.ListNode(i);
//           listNode = listNode.next;
//       }
//        System.out.println(start);
//        System.out.println(new Algoritms.Solution().reverseKGroup(start, 2));


        //        int[] catsNames = {-3,0,3,2,-1,-4};
//        System.out.println(new Algoritms.Solution().threeSum(catsNames));

//        System.out.println(new Algoritms.Solution().letterCombinations("2222"));


//        String[] catsNames = {"flower", "flow","flight"};
//        System.out.println(new Algoritms.Solution().longestCommonPrefix(catsNames));
        // System.out.println(new Algoritms.Solution().intToRoman(1994));
        // System.out.println(new Algoritms.Solution().maxArea(new int[] {1,8,6,2,5,4,8,3,7}));

        //  System.out.println(new Algoritms.Solution().myAtoi("9223372036854775808"));


//        System.out.println(new Algoritms.Solution().reverse2(321));
//


        // System.out.println(new Algoritms.Solution().convert("PAYPALISHIRING", 4));


        //  System.out.println(new Algoritms.Solution().longestPalindrome("aaaaaaaaaabcaaaa"));


        // Integer testInt = 0;
        // new Algoritms.Solution().changeInt(testInt);


//        int[] arr = new int[2];
//        arr[0] = 0;
//        arr[1] = 0;
//        new Algoritms.Solution().changeArrInt(arr);
//
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
    }
}
