package Algoritms;
//Task 110 Easy. Balanced Binary Tree https://leetcode.com/problems/balanced-binary-tree/
//Success
//Runtime: 3 ms, faster than 6.81% of Java online submissions for Balanced Binary Tree.
//Memory Usage: 40.3 MB, less than 59.26% of Java online submissions for Balanced Binary Tree.
import java.util.Iterator;
import java.util.LinkedList;

public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        LinkedList<LinkedList<TreeNode>> levels = new LinkedList<>();
        levels.add(new LinkedList<>());
        levels.get(0).add(root);

        Iterator<TreeNode> currentLevelIt;
        boolean indicatorOfNotNull = true; // true - в списке есть хотя бы 1 объект, false - всё null
        while (indicatorOfNotNull) {
            indicatorOfNotNull = false;
            currentLevelIt = levels.peekLast().iterator();
            TreeNode currentTree;
            levels.add(new LinkedList<>());
            while (currentLevelIt.hasNext()) {
                currentTree = currentLevelIt.next();
                if (currentTree != null) {
                    levels.peekLast().add(currentTree.left);
                    levels.peekLast().add(currentTree.right);
                    if (indicatorOfNotNull == true || currentTree.left != null || currentTree.right != null) {
                        indicatorOfNotNull = true;
                    }
                }
            }
        }
        levels.removeLast();


        LinkedList<Integer> currentHeightLevel = new LinkedList<>();
        LinkedList<Integer> nextHeightLevel;
        currentLevelIt = levels.peekLast().iterator();
        int size = levels.peekLast().size();
        for (int i = 0; i < size; i++) {
            if (currentLevelIt.next() != null) {
                currentHeightLevel.add(1);
            }
        }
        levels.removeLast();

        Iterator<Integer> currentHeightIterator;
        while (levels.size() != 0) {
            currentLevelIt = levels.peekLast().iterator();
            size = levels.peekLast().size();
            TreeNode currentTree;


            nextHeightLevel = new LinkedList<>();
            currentHeightIterator = currentHeightLevel.iterator();

            for (int i = 0; i < size; i++) {
                currentTree = currentLevelIt.next();
                int left = 0;
                int right = 0;
                if (currentTree != null) {
                    if (currentTree.left != null) {
                        left += currentHeightIterator.next();
                    }
                    if (currentTree.right != null) {
                        right += currentHeightIterator.next();
                    }
                } else {
                    continue;
                }

                if (Math.abs(left - right) >= 2) {
                    return false;
                } else {
                    nextHeightLevel.add(Math.max(left, right) + 1);
                }
            }

            currentHeightLevel = nextHeightLevel;
            nextHeightLevel = new LinkedList<>();

            levels.removeLast();
        }
        return true;
    }


//    public boolean isBalanced(TreeNode root) { //завалилось на одном из последних тестов
//        if (root == null) return true;
//        LinkedList<TreeNode> treeList = new LinkedList<>();
//        LinkedList<Integer> heightList = new LinkedList<>();
//        int min = Integer.MAX_VALUE;
//        int max = 1;
//        int currentHeight = 1;
//        while (!treeList.isEmpty() || root != null) {
//            if (root.right == null || root.left == null) {
//                if (min > currentHeight) {
//                    min = currentHeight;
//                }
//                if (max < currentHeight) {
//                    max = currentHeight;
//                }
//            }
//            if (root.right != null) {
//                treeList.add(root.right);
//                heightList.add(currentHeight + 1);
//            }
//            if (root.left != null) {
//                root = root.left;
//                currentHeight++;
//                continue;
//            }
//
//            root = treeList.pollFirst();
//            if (!heightList.isEmpty()) {
//                currentHeight = heightList.pollFirst();
//            } else {
//                return !(max - min >= 2);
//            }
//        }
//        return !(max - min >= 2);
//    }
}