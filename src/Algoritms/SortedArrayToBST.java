package Algoritms;
//Task 108 Easy. Convert Sorted Array to Binary Search Tree https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
//Success
//Runtime: 3 ms, faster than 10.45% of Java online submissions for Convert Sorted Array to Binary Search Tree.
//Memory Usage: 39.8 MB, less than 5.16% of Java online submissions for Convert Sorted Array to Binary Search


import java.util.LinkedList;

public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;

        LinkedList<TreeNode> nodes = new LinkedList<>();
        LinkedList<Integer> limits = new LinkedList<>();

        int length = nums.length;
        int mid = (length - 1) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        nodes.add(root);
        limits.add(0);
        limits.add(mid - 1);
        limits.add(mid + 1);
        limits.add(length - 1);

        TreeNode temp;
        int leftLim;
        int rightLim;

        int addedNodes = 1;
        while (addedNodes < length) {
            leftLim = limits.pollFirst();
            rightLim = limits.pollFirst();
            if (rightLim - leftLim >= 0) {
                mid = CalculatingMid.calculateMid(leftLim, rightLim, CalculatingMid.Sides.LEFT);
                temp = new TreeNode(nums[mid]);
                nodes.peekFirst().left = temp;
                nodes.addLast(temp);
                addedNodes++;

                limits.addLast(leftLim);
                limits.addLast(mid - 1);

                limits.addLast(mid + 1);
                limits.addLast(rightLim);
            } else {

            }
            if (addedNodes < length) {
                leftLim = limits.pollFirst();
                rightLim = limits.pollFirst();
                if (rightLim - leftLim >= 0) {
                    mid = CalculatingMid.calculateMid(leftLim, rightLim, CalculatingMid.Sides.RIGHT);
                    temp = new TreeNode(nums[mid]);
                    nodes.pollFirst().right = temp;
                    addedNodes++;
                    nodes.addLast(temp);
                    limits.addLast(leftLim);
                    limits.addLast(mid - 1);

                    limits.addLast(mid + 1);
                    limits.addLast(rightLim);

                } else {

                    nodes.removeFirst();
                }
            }
        }
        return root;
    }

    static class CalculatingMid {
        static int calculateMid(int left, int right, Sides side) {
            if (left == right) {
                return left;
            }

            if (side == Sides.LEFT) {
                if (right - left == 1) {
                    return (left + right + 1) / 2;
                } else {
                    return (left + right) / 2;
                }
            } else {
                if (right - left == 1) {
                    return (left - 1 + right) / 2;
                } else {
                    return (left + right) / 2;
                }
            }
        }

        enum Sides {
            LEFT,
            RIGHT
        }
    }
}
