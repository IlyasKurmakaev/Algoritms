package Algoritms;
//338. Counting Bits https://leetcode.com/problems/counting-bits/
//Success but failed
//Runtime: 110 ms, faster than 5.35% of Java online submissions for Counting Bits.
//Memory Usage: 100.3 MB, less than 5.69% of Java online submissions for Counting Bits.
import org.junit.Assert;
import org.junit.Test;

public class CountBits {
	public int[] countBits(int n) {
		int[] res = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			res[i] = getSumFromBinaryString(Integer.toBinaryString(i));
		}
		return res;
	}

	public int getSumFromBinaryString(String binSum) {
		int sum = 0;
		for (int i = 0; i < binSum.length(); i++) {
			sum += Integer.parseInt(binSum.substring(i, i + 1));
		}
		return sum;
	}

	@Test
	public void common() {
		int[] expected = new int[]{0, 1, 1};
		int[] actual = new CountBits().countBits(2);
		Assert.assertArrayEquals(expected, actual);
	}
}
