import java.sql.SQLOutput;
import java.util.List;
import java.util.Random;

public class Main {


    public static void main(String[] args) {
        int[][] inArr = new int[2][2];
        inArr[0][0] = 1;
        inArr[0][1] = 3;
        inArr[1][0] = 6;
        inArr[1][1] = 9;

        int[] secondArr = new int[2];
        secondArr[0] = 2;
        secondArr[1] = 5;
        Tools.printSquareArr(new Solution().insert(inArr, secondArr));
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
//        Tools.printSquareArr(new Solution().merge(inArr));

        //_________________________________________________
//        System.out.println(new Solution().canJump(new int[]{4,2,0,0,1,1,4,4,4,0,4,0}));
////        System.out.println(new Solution().canJump(new int[]{1,1,1,0}));
//        System.out.println(new Solution().canJump(new int[]{3,2,1,0,4}));

//____________________________________________________________________________________________________________________
//        int[][] inArr = Tools.createIntSquareArr(2,10);
//        Tools.printSquareArr(inArr);
//        List<Integer> res = new Solution().spiralOrder(inArr);
//        for (int intPartRes : res) {
//            System.out.print(intPartRes + " ");
//        }
        //____________________________________________________________
//        //List<List<String>> res = new Solution().groupAnagrams(new String[]{"tea","and","ace","ad","eat","dans"});
//        //List<List<String>> res = new Solution().groupAnagrams(new String[]{"tea","","eat","","tea",""});
//        List<List<String>> res = new Solution().groupAnagrams(new String[]{"abc","bca", "cba", "avc", "vca", "qqq", "", ""});
//        for (List<String> arrStr : res) {
//            for (String str : arrStr) {
//                System.out.print(str + " ");
//            }
//            System.out.println();
//        }
        //_________________________________________
        // System.out.println(new Solution().myPow(2.00000, -2147483648));
       //__________________________________________
        // System.out.println(new Solution().divide(-2147483648, -1));
        //___________________
//        new Solution().multiply("123", "456");
        //_________________
        // System.out.println(new Solution().isPalindrome(0));
//        __________________________________________
//        ListNode listNode1 = new ListNode(5);
//        ListNode listNode2 = new ListNode(5);
//        System.out.println(new Solution().addTwoNumbers2(ListNode.generateListNode(243), ListNode.generateListNode(564)));
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
//        int[] res = new Solution().searchRange(arr7, target7);
//        for (int re : res) {
//            System.out.print(re + " ");
//        }
//_____________________________________________

        //new Solution().printMatrix();
        //        System.out.println(new Solution().strStr("aaa", "aaaa"));
//        int[] a = {2,5};
//        System.out.println(new Solution().searchInsert(a, 1));


//        ListNode listNode = new ListNode(1);
//        ListNode start = listNode;
//        listNode.next = new ListNode(2);
////        listNode.next.next = new ListNode(3);
//       for (int i = 2; i <= 5; i++) {
//           listNode.next = new ListNode(i);
//           listNode = listNode.next;
//       }
//        System.out.println(start);
//        System.out.println(new Solution().reverseKGroup(start, 2));


        //        int[] catsNames = {-3,0,3,2,-1,-4};
//        System.out.println(new Solution().threeSum(catsNames));

//        System.out.println(new Solution().letterCombinations("2222"));


//        String[] catsNames = {"flower", "flow","flight"};
//        System.out.println(new Solution().longestCommonPrefix(catsNames));
        // System.out.println(new Solution().intToRoman(1994));
        // System.out.println(new Solution().maxArea(new int[] {1,8,6,2,5,4,8,3,7}));

        //  System.out.println(new Solution().myAtoi("9223372036854775808"));


//        System.out.println(new Solution().reverse2(321));
//


        // System.out.println(new Solution().convert("PAYPALISHIRING", 4));


        //  System.out.println(new Solution().longestPalindrome("aaaaaaaaaabcaaaa"));


        // Integer testInt = 0;
        // new Solution().changeInt(testInt);


//        int[] arr = new int[2];
//        arr[0] = 0;
//        arr[1] = 0;
//        new Solution().changeArrInt(arr);
//
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }
    }
}
