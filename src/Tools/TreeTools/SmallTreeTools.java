package Tools.TreeTools;

import Algoritms.TreeNode;
import Tools.TreeTools.ShowTree.Graphics.WindowManager;
import Tools.TreeTools.ShowTree.ShowTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SmallTreeTools {
    static private IStrategiLeftRight iStrategiLeftRight = new LeftStrategi();

    /**
     * // Создаёт дерево из стринговой строки типа [2,4,3,null,null,null,5,1]
     */
    public TreeNode makeTreeNodeFromLeetCodeString(String argStr) {
        if (argStr == null) return null;
        List<TreeNode> treeNodes = new ArrayList<>();
        LinkedList<Integer> integers = (LinkedList<Integer>) new Utillls().parceStringInIntegers(argStr);
        TreeNode head = new TreeNode(integers.get(0));
        integers.remove(0);
        treeNodes.add(head);
        while (!integers.isEmpty()) {
            TreeNode temp = iStrategiLeftRight.makeTreeNode(treeNodes.get(0), integers.get(0), treeNodes);
            if (temp != null) {
                treeNodes.add(temp);
            }
            integers.remove(0);
        }
        return head;
    }

    private interface IStrategiLeftRight {
        TreeNode makeTreeNode(TreeNode root, Integer value, List<TreeNode> treeNodes);
    }

    private static class LeftStrategi implements IStrategiLeftRight {
        @Override
        public TreeNode makeTreeNode(TreeNode root, Integer value, List<TreeNode> treeNodes) {
            if (value != null) {
                root.left = new TreeNode(value);
            }
            iStrategiLeftRight = new RightStrategi();
            return root.left;
        }
    }

    private static class RightStrategi implements IStrategiLeftRight {
        @Override
        public TreeNode makeTreeNode(TreeNode root, Integer value, List<TreeNode> treeNodes) {
            if (value != null) {
                root.right = new TreeNode(value);
            }
            iStrategiLeftRight = new LeftStrategi();
            treeNodes.remove(0);
            return root.right;
        }
    }


//    public static void main(String[] args) {
//        //List<Integer> list = new SmallTreeTools().new Utillls().parceStringInIntegers("[2,4,3,null,null,null,5,1]");
//        WindowManager.createFrame(ShowTree.layerTreeNodeBuilder(new SmallTreeTools().makeTreeNodeFromLeetCodeString("[2,4,3,null,null,null,5,1]")));
//    }


    class Utillls {
        public List<Integer> parceStringInIntegers(String argStr) {
            List<Integer> res = new LinkedList<>();
            Integer temp = null;
            Pattern numPattern;
            Pattern abcPattern;
            for (int i = 0; i < argStr.length(); i++) {
                String subStr = argStr.substring(i, i + 1);

                numPattern = Pattern.compile("\\d");
                abcPattern = Pattern.compile("\\w");
                Matcher numMatcher = numPattern.matcher(subStr);
                Matcher abcMatcher = abcPattern.matcher(subStr);

                if (subStr.equals("[")) {
                    continue;
                } else if (numMatcher.find()) {
                    if (temp == null) {
                        temp = Integer.parseInt(subStr);
                    } else {
                        temp = temp * 10 + Integer.parseInt(subStr);
                    }
                } else if (subStr.equals(",") || subStr.equals("]")) {
                    if (temp == null) {
                        res.add(null);
                    } else {
                        res.add(temp);
                        temp = null;
                    }
                } else if (abcMatcher.find()) {
                    continue;
                }
            }
            return res;
        }
    }
}
