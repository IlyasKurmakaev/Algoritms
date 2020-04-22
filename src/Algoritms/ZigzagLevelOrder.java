package Algoritms;
//Task 103 Medium. Binary Tree Zigzag Level Order Traversal https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
//Success
//Runtime: 1 ms, faster than 68.79% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
//Memory Usage: 39.6 MB, less than 5.77% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class ZigzagLevelOrder {                    // РАЗВЛЕЧЕНИЯ И ЭКСПЕРИМЕНТЫ!

    private IInvertingFor iInvertingFor;
    private IInvertingFor iRightZig;
    private IInvertingFor iLeftZag;
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        LinkedList<List<Integer>> res = new LinkedList<>();
        ArrayList<TreeNode> current = new ArrayList<>();
        ArrayList<TreeNode> children = new ArrayList<>();
        current.add(root);

        iInvertingFor = new LeftZag();
        iLeftZag = iInvertingFor;
        iRightZig = new RightZig();

        while (!current.isEmpty()) {
            for (int i = iInvertingFor.initializeI(current); iInvertingFor.comparison(i, current); i = iInvertingFor.nextI(i)) {
                iInvertingFor.addChildren(i, current, children);
            }
            iInvertingFor.switchStrategy();

            res.add(current.stream().map(p -> p.val).collect(Collectors.toList()));
//            res.add(new LinkedList<>()); //без стримов
//            for (TreeNode tr : current) {
//                res.peekLast().add(tr.val);
//            }

            current = children;
            children = new ArrayList<>();
        }
        return res;
    }

    interface IInvertingFor {
        int initializeI(List<TreeNode> treeNodes);
        boolean comparison(int i, List<TreeNode> treeNodes);
        int nextI(int i);
        void addChildren(int i, List<TreeNode> current, List<TreeNode> children);
        void switchStrategy();
    }

    private class RightZig implements IInvertingFor {
        @Override
        public int initializeI(List<TreeNode> treeNodes) {
            return  treeNodes.size() - 1;
        }

        @Override
        public boolean comparison(int i, List<TreeNode> treeNodes) {
            return i >= 0;
        }

        @Override
        public int nextI(int i) {
            return i - 1;
        }

        @Override
        public void addChildren(int i, List<TreeNode> current, List<TreeNode> children) {
            if (current.get(i).left != null) {
                children.add(current.get(i).left);
            }
            if (current.get(i).right != null) {
                children.add(current.get(i).right);
            }
        }

        @Override
        public void switchStrategy() {
            iInvertingFor = iLeftZag;
        }

    }

    private class LeftZag implements IInvertingFor {

        @Override
        public int initializeI(List<TreeNode> treeNodes) {
            return treeNodes.size() - 1;
        }

        @Override
        public boolean comparison(int i, List<TreeNode> treeNodes) {
            return i >= 0;
        }

        @Override
        public int nextI(int i) {
            return i - 1;
        }

        @Override
        public void addChildren(int i, List<TreeNode> current, List<TreeNode> children) {
            if (current.get(i).right != null) {
                children.add(current.get(i).right);
            }
            if (current.get(i).left != null) {
                children.add(current.get(i).left);
            }
        }

        @Override
        public void switchStrategy() {
            iInvertingFor = iRightZig;
        }
    }
}