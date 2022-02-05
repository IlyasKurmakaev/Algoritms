package Algoritms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		List<Integer> res = new ArrayList<>();
		Map<Integer, Integer> numIdMap = new HashMap<>();
		for (int i = 0; i < nums1.length; i++) {
			int lastNumId = 0;
			if (numIdMap.containsKey(nums1[i])) {
				if (numIdMap.get(nums1[i]) + 1 > nums2.length - 1) {
					continue;
				} else {
					lastNumId = numIdMap.get(nums1[i] + 1);
				}
			}
			for (int j = lastNumId; j < nums2.length; j++) {
				if (nums1[i] == nums2[j]) {
					res.add(nums2[j]); //or nums1[i]
					numIdMap.put(nums2[j], j);
				}
			}
		}
		int[] resArr = new int[res.size()];
		for (int i = 0; i < res.size(); i++) {
			resArr[i] = res.get(i);
		}
		return resArr;
	}
}
