package Algoritms;
//Task 228. Summary Ranges https://leetcode.com/problems/summary-ranges/
//Success
//Runtime: 6 ms, faster than 68.77% of Java online submissions for Summary Ranges.
//Memory Usage: 37.3 MB, less than 71.25% of Java online submissions for Summary Ranges.

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		Integer startValue = null;
		int previousValue = 0;
		List<String> res = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (startValue == null) {
				startValue = nums[i];
				previousValue = nums[i];
			} else {
				if (previousValue + 1 != nums[i]) {
					if (startValue != previousValue) {
						res.add(startValue + "->" + previousValue);
					} else {
						res.add(String.valueOf(startValue));
					}
					startValue = nums[i];
				}
			}
			previousValue = nums[i];
			if (i == nums.length - 1) {
				if (startValue == nums[i]) {
					res.add(String.valueOf(startValue));
				} else {
					res.add(startValue + "->" + nums[i]);
				}
			}
		}
		return res;
	}


	//Execute and tests


	public static void main(String[] args) {
		System.out.println(new SummaryRanges().summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9}));
	}

	@Test
	public void firstTest() {
		List<String> listStr = new SummaryRanges().summaryRanges(new int[]{0, 2, 3, 4, 6, 8, 9});
		String actualRes = getStringFromList(listStr);
		Assert.assertEquals("[0, 2->4, 6, 8->9]", actualRes);
	}

	private String getStringFromList(List<String> listStr) {
		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("[");
		for (int i = 0; i < listStr.size(); i++) {
			strBuffer.append(listStr.get(i));
			if (i != listStr.size() - 1) {
				strBuffer.append(", ");
			}
		}
		strBuffer.append("]");
		return strBuffer.toString();
	}
}
