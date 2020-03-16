package Tools.TreeTools.RandomGenTree;

import Algoritms.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomGenTree {

    public TreeNode createRandomTreeNode(int levels, int percentOfChildren) {
        TreeNode head = new TreeNode(0);
        List<TreeNode> upperLayer = new ArrayList<>();
        List<TreeNode> lowerLayer = new ArrayList<>();
        upperLayer.add(head);
        int ordinalNnumber = 1;
        for (int i = 0; i <= levels - 1; i++) {
            lowerLayer = new ArrayList<>();
            List<Integer> randNumbers = getRandomNumbers(getCountOfLayerChildrens(upperLayer), percentOfChildren);
            Collections.sort(randNumbers);
            for (int j = 0; j <= randNumbers.size() - 1; j++) {
                addChildrenByNum(upperLayer, lowerLayer, randNumbers.get(j), ordinalNnumber);
                ordinalNnumber++;
            }
            upperLayer = lowerLayer;
        }
        return head;
    }

    private int getCountOfLayerChildrens(List<TreeNode> listLayer) {
        return listLayer.size() * 2;
    }

    private List<Integer> getRandomNumbers(int countOfChildrens, int percent) {
        List<Integer> childrens = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Random r = new Random();
        for (int i = 0; i <= countOfChildrens - 1; i++) {
            childrens.add(i);
        }
        int countChildrensAfterPercent = (int) Math.round(percent * 0.01 * countOfChildrens);

        for (int i = 0; i < countChildrensAfterPercent; i++) {
            int randomNum = r.nextInt(childrens.size());
            res.add(childrens.get(randomNum));
            childrens.remove(randomNum);
        }
        return res;
    }

    private void addChildrenByNum(List<TreeNode> parentsList, List<TreeNode> childrensList, int num, int valOfNewNode) {
        int halfNum = num / 2;
        if (num % 2 == 0) {
            TreeNode newNode = new TreeNode(valOfNewNode);
            parentsList.get(halfNum).left = newNode;
            childrensList.add(newNode);
        }
        else if (num % 2 == 1) {
            TreeNode newNode = new TreeNode(valOfNewNode);
            parentsList.get(halfNum).right = newNode;
            childrensList.add(newNode);
        }
    }
}
