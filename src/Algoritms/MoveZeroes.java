package Algoritms;
//Task 283.  Move Zeroes https://leetcode.com/problems/move-zeroes/
//Success
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Move Zeroes.
//Memory Usage: 42.2 MB, less than 7.02% of Java online submissions for Move Zeroes.
import org.junit.Assert;
import org.junit.Test;

public class MoveZeroes {
	public void moveZeroes(int[] nums) {
		int shift = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				shift++;
				continue;
			}
			if (shift == 0) continue;

			nums[i - shift] = nums[i];
		}
		for (int i = nums.length - 1; i > nums.length - 1 - shift; i--) {
			nums[i] = 0;
		}
	}

	@Test
	public void common() {
		int []actual = new int[]{0,1,0,3,12};
		new MoveZeroes().moveZeroes(actual);
		Assert.assertArrayEquals(new int[]{1,3,12,0,0}, actual);
	}
}
