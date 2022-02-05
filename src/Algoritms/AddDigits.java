package Algoritms;
//Task 258.  Add Digits https://leetcode.com/problems/add-digits/
//Success
//Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Digits.
//Memory Usage: 35.9 MB, less than 86.61% of Java online submissions for Add Digits.

import org.junit.Assert;
import org.junit.Test;

public class AddDigits {
	public int addDigits(int num) {

		while (num / 10 != 0) {
			int numLength = (int) Math.log10(num) + 1;
			int newNum = 0;
			for (int i = 1; i < numLength + 1; i++) {
				newNum += num % 10;
				num /= 10;
			}
			num = newNum;
		}
		return num;
	}

	@Test
	public void tesCommon() {
		Assert.assertEquals(6, new AddDigits().addDigits(123));
	}

	@Test
	public void testZero() {
		Assert.assertEquals(0, new AddDigits().addDigits(0));
	}

	@Test
	public void testManyDigits() {
		Assert.assertEquals(9, new AddDigits().addDigits(9999));
	}
}
