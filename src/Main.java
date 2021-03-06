import Algoritms.*;
import Algoritms.GenerateTrees.GenerateTrees;
import Tools.TreeTools.ShowTree.DebugTools;
import Tools.TreeTools.ShowTree.Graphics.WindowManager;
import Tools.TreeTools.ShowTree.ShowTree;
import Tools.TreeTools.SmallTreeTools;

public class Main {


    public static void main(String[] args) throws InterruptedException {
// _____________________________________//Task 113 Medium________________________________________________________________
    TreeNode tn = new SmallTreeTools().makeTreeNodeFromLeetCodeString("[5,4,8,11,null,13,4,7,2,null,null,5,1]");
        DebugTools.showInCode(Main.class, tn);
        System.out.println(new PathSumTwo().pathSum(tn, 22));


// _____________________________________//Task 112 Easy________________________________________________________________
//        TreeNode tNString = new SmallTreeTools().makeTreeNodeFromLeetCodeString("1,-2,-3,1,3,-2,null,-1"); // ([-2,null,-3] -2)
//        new Thread(() -> WindowManager.createFrame("text", ShowTree.layerTreeNodeBuilder(tNString))).run();
//
//        Thread.sleep(200);
//
//        System.out.println(new HasPathSum().hasPathSum(tNString, -4));

//_______________________________________//Task 111 Easy________________________________________________________________
//        TreeNode tn = new SmallTreeTools().makeTreeNodeFromLeetCodeString("[3,9,20,null,null,15,7]");
//
//        System.out.println(new MinDepth().minDepth(tn));



// _____________________________________//Task 110 Easy________________________________________________________________
//        TreeNode tNString = new SmallTreeTools().makeTreeNodeFromLeetCodeString("[1,2,2,3,3,null,null,4,4]");
//        new Thread(() -> WindowManager.createFrame("text", ShowTree.layerTreeNodeBuilder(tNString))).run();
//
//        try {
//            Thread.sleep(200);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//
//        new IsBalanced().isBalanced(tNString);
// ____________________________________________________________________________________________________________________
//        int[] arr = new int[5];
//        arr[0] = -10;
//        arr[1] = -3;
//        arr[2] = 0;
//        arr[3] = 5;
//        arr[4] = 9;
//        TreeNode root  = new SortedArrayToBST().sortedArrayToBST(arr);
//        TreeNode tNString = new SmallTreeTools().makeTreeNodeFromLeetCodeString("[1,null,2,null,3]");
//        WindowManager.createFrame("text", ShowTree.layerTreeNodeBuilder(tNString));
//        System.out.println(new IsBalanced().isBalanced(tNString));



        //TreeNode tNString = new SmallTreeTools().makeTreeNodeFromLeetCodeString("[3,9,20,null,null,15,7]");
        //System.out.println(new ZigzagLevelOrder().zigzagLevelOrder(tNString));

        //______________________________________ isSymmetric
//        TreeNode root = new TreeNode(0);
//        root.left = new TreeNode(1);
//        TreeNode tNString = new SmallTreeTools().makeTreeNodeFromLeetCodeString("[1,2,2,3,4,4,3] "); // [1,2,2,3,4,4,3]  [2,4,3,null,null,null,5,1]
//        WindowManager.createFrame("1", ShowTree.layerTreeNodeBuilder(tNString));
//        System.out.println(new IsSymmetric().isSymmetric(tNString));
////        new RecoverTree().recoverTree(tNString);
//        System.out.println(tNString);
//        System.out.println(new GenerateTrees().numTrees(10));

          //________________________________________________________________________________
//        TreeNode head = new TreeNode(2);
//        head.left = new TreeNode(3);
//        head.right = new TreeNode(1);
//        new RecoverTree().recoverTree(head);

//        TreeNode head = new TreeNode(3);
//        head.left = new TreeNode(1);
//        head.right = new TreeNode(5);
//        head.left.left = new TreeNode(0);
//        head.left.right = new TreeNode(2);
//        head.right.left = new TreeNode(4);
//        head.right.right = new TreeNode(6);
//        head.left.right.right = new TreeNode(3);
//        head.left.right = new TreeNode(212);
//        head.right.left = new TreeNode(3);
//        head.right.left.right = new TreeNode(4);
//        head.right.left.right.left = new TreeNode(5);
     //   new IsValidBST().sout(head);
     //   System.out.println(new IsValidBST().isValidBST(head));
     //   WindowManager.createFrame(ShowTree.layerTreeNodeBuilder(head));







//        ShowTree.setI(new ShowTree().new GenRandomTreeNode(6, 75));
//        ShowTree.showTree();
//        for (int i  = 0; i < 100000; i++) {
//            ShowTree.repaintTree();
//            try {
//                Thread.sleep(300);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//
//





        //WindowManager.createFrame(ShowTree.layerTreeNodeBuilder(head));

//        System.out.println(Layer.layerTreeNodeBuilder(Tools.Tools.generateTreeNode("1 34")));
//________________________________________________________
//        int[][] matrix = new int[2][1];

//        matrix[0][0] = 1;
//        matrix[0][1] = 2;
//        matrix[0][2] = 3;
//        matrix[1][0] = 4;
//        matrix[1][1] = 5;
//        matrix[1][2] = 6;
//        matrix[2][0] = 7;
//        matrix[2][1] = 8;
//        matrix[2][2] = 9;
//        matrix[0][0] = 1;
//        matrix[1][0] = 3;

//        System.out.println(new SearchMatrix().searchMatrix(matrix, 3));
//        System.out.println(new IsIsomorphic().isIsomorphic("bar","foo"));
        //        System.out.println(new InorderTraversal().inorderTraversal(Tools.Tools.generateTreeNode("1 34")));
//        System.out.println(new ReverseBetween().reverseBetween(Tools.Tools.generateListNode("35"), 1, 2));

//        System.out.println(new SubsetsII().subsetsWithDup(new int[]{1,2,2}));
        // System.out.println(new PartitionList().partition(Tools.Tools.generateListNode("45389157"), 3));

        //        System.out.println(new DeleteDuplicates().deleteDuplicates(Tools.Tools.generateListNode("11233")));
        //        System.out.println(new RotateList().rotateRight(ListNode.generateListNode(4), 1));
//        System.out.println(new LengthOfLastWord().lengthOfLastWord("a"));

//        Tools.Tools.printSquareArr(new Algoritms.Solution().generateMatrix(3));

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
//        Tools.Tools.printSquareArr(new Algoritms.Solution().insert(inArr, secondArr));
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
//        //int[][] inArr = Tools.Tools.createIntSquareArr(5,2);
//        Tools.Tools.printSquareArr(new Algoritms.Solution().merge(inArr));

        //_________________________________________________
//        System.out.println(new Algoritms.Solution().canJump(new int[]{4,2,0,0,1,1,4,4,4,0,4,0}));
////        System.out.println(new Algoritms.Solution().canJump(new int[]{1,1,1,0}));
//        System.out.println(new Algoritms.Solution().canJump(new int[]{3,2,1,0,4}));

//____________________________________________________________________________________________________________________
//        int[][] inArr = Tools.Tools.createIntSquareArr(2,10);
//        Tools.Tools.printSquareArr(inArr);
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
