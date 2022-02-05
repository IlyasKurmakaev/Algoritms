package Algoritms;
//129 Medium. Sum Root to Leaf Numbers https://leetcode.com/problems/sum-root-to-leaf-numbers/
//Success
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum Root to Leaf Numbers.
//Memory Usage: 36.9 MB, less than 17.95% of Java online submissions for Sum Root to Leaf Numbers.
import Tools.TreeTools.ShowTree.DebugTools;
import Tools.TreeTools.SmallTreeTools;
import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;

public class SumNumbers {
    public int sumNumbers(TreeNode root) {
        LinkedList<TreeNode> buffer = new LinkedList<>();
        LinkedList<Integer> sumBuffer = new LinkedList<>();
        Integer currentSum = root != null ? root.val : null;
        int resSum = 0;
        while (root != null) {
            if (root.right != null) {
                buffer.add(root.right);
                sumBuffer.add(currentSum * 10 + root.right.val);
            }
            if (root.left != null) {
                currentSum = currentSum * 10 + root.left.val;
                root = root.left;
                continue;
            }

            if (root.right == null) {
                resSum += currentSum;
            }

            root = buffer.pollFirst();
            currentSum = sumBuffer.pollFirst();

        }
        return resSum;
    }

    @Test
    public void testSumNumbers(){
        TreeNode root = new SmallTreeTools().makeTreeNodeFromLeetCodeString("[1,2,3]");
        Assert.assertEquals(25, new SumNumbers().sumNumbers(root));
        root = new SmallTreeTools().makeTreeNodeFromLeetCodeString("[4,9,0,5,1]");
        Assert.assertEquals(1026, new SumNumbers().sumNumbers(root));

    }

    public static void main(String[] args) {
        TreeNode root = new SmallTreeTools().makeTreeNodeFromLeetCodeString("[4,9,0,5,1]");
        DebugTools.showInCode(SumNumbers.class, root);
        System.out.println(new SumNumbers().sumNumbers(root));
    }
}
