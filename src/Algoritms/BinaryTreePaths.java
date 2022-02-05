package Algoritms;
//257. Binary Tree Paths
import Tools.TreeTools.SmallTreeTools;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreePaths {
	//try 1
//	public List<String> binaryTreePaths(TreeNode root) {
//		List<String> res = new ArrayList<>();
//		Map<Integer, Integer> nextNumMap = new HashMap<>();
//		List<TreeNode> rightBuffer = new ArrayList<>();
//		List<Integer> rightLvlBuffer = new ArrayList<>();
//		int currentLvl = 0;
//
//
//		nextNumMap.put(0, root.val);
//		while (true) {
//			if (root.left != null) {
//				if (root.right != null) {
//					rightBuffer.add(root.right);
//					rightLvlBuffer.add(currentLvl + 1);
//				}
//				root = root.left;
//				currentLvl++;
//				nextNumMap.put(currentLvl, root.val);
//			} else {
//				if (root.right != null) {
//					rightBuffer.add(root.right);
//					rightLvlBuffer.add(currentLvl + 1);
//				} else {
//					nextNumMap.put(currentLvl, root.val);
//					res.add(makeStringFromListOfNodes(nextNumMap));
//				}
//
//				root = rightBuffer.get(rightBuffer.size() - 1);
//				currentLvl = rightLvlBuffer.get(rightLvlBuffer.size() - 1);
//				rightBuffer.remove(rightBuffer.size() - 1);
//				rightLvlBuffer.remove(rightLvlBuffer.size() - 1);
//				removeElementsHigherThenN(nextNumMap, currentLvl);
//			}
//			if (root == null && rightBuffer.size() == 0) {
//				return res;
//			}
//		}
//	}
//
//	private String makeStringFromListOfNodes(Map<Integer, Integer> map) {
//		String res = "";
//		for (int i = 0; i < map.size(); i++) {
//			res += map.get(i);
//		}
//		return res;
//	}
//
//	private void removeElementsHigherThenN(Map<Integer, Integer> nextNumMap, int n) {
//		for (Map.Entry<Integer, Integer> element : nextNumMap.entrySet()) {
//			if (element.getKey() > n) {
//				nextNumMap.remove(element.getKey());
//			}
//		}
//	}
//
//	@Test
//	public void testSumNumbers() {
//		TreeNode root = new SmallTreeTools().makeTreeNodeFromLeetCodeString("[1,2,3,null,5]");
//		System.out.println(root);
//		binaryTreePaths(root);
//	}

	class AdvancedTree {
		TreeNode treeNode;
		AdvancedTree nextAdvTN;
		public AdvancedTree(TreeNode treeNode) {
			this.treeNode = treeNode;
		}

		public AdvancedTree getNextAdvTN() {
			return nextAdvTN;
		}

		public void setNextAdvTN(AdvancedTree nextAdvTN) {
			this.nextAdvTN = nextAdvTN;
		}
	}

	public List<String> binaryTreePaths(TreeNode root) {
		AdvancedTree advRoot = new AdvancedTree(root);
		//advRoot.
		return null;
	}
}
