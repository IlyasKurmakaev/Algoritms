package Algoritms;
//Task 344. Reverse String https://leetcode.com/problems/reverse-string/
//Success
//Runtime: 1 ms, faster than 95.21% of Java online submissions for Reverse String.
//Memory Usage: 52.8 MB, less than 5.36% of Java online submissions for Reverse String.
import org.junit.Assert;
import org.junit.Test;

public class ReverseString {
	public void reverseString(char[] s) {
		char buffer;
		int length = s.length;
		for (int i = 0; i < s.length / 2; i++) {
			buffer = s[0 + i];
			s[0 + i] = s[length - 1 - i];
			s[length - 1 - i] = buffer;
		}
	}

	@Test
	public void common() {
		char[] array = new char[] {'h','e','l','l','o'};
		char[] expected = new char[] {'o','l','l','e','h'};
		new ReverseString().reverseString(array);
		Assert.assertArrayEquals(expected, array);
	}
}
