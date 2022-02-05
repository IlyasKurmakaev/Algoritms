package Algoritms;
//Task 290. Word Pattern https://leetcode.com/problems/word-pattern/
//Success
//Runtime: 2 ms, faster than 21.10% of Java online submissions for Word Pattern.
//Memory Usage: 38.5 MB, less than 14.74% of Java online submissions for Word Pattern.
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class WordPattern {
	public boolean wordPattern(String pattern, String s) {
		Map<String, String> patternsMap = new HashMap<>();
		List<String> wordsList = Arrays.asList(s.split(" "));
		int patternLength = pattern.length();
		if (patternLength == 0 && s.length() != 0) {
			return false;
		}
		if (patternLength != wordsList.size()) {
			return false;
		}
		String substring;
		for (int i = 0; i < patternLength; i++) {
			substring = pattern.substring(i, i + 1);
			if (patternsMap.containsKey(substring)) {
				if (!patternsMap.get(substring).equals(wordsList.get(i))) {
					return false;
				}
			} else {
				if (patternsMap.containsValue(wordsList.get(i))) {
					return false;
				}
				patternsMap.put(substring, wordsList.get(i));
			}
		}
		return true;
	}

	@Test
	public void common() {
		Assert.assertTrue(new WordPattern().wordPattern("abba", "dog cat cat dog"));
	}

	@Test
	public void wrongWords() {
		Assert.assertFalse(new WordPattern().wordPattern("abba", "dog dog dog dog"));
	}

	@Test
	public void tooMuchWords() {
		Assert.assertFalse(new WordPattern().wordPattern("aaa", "aa aa aa aa"));
	}

	@Test
	public void twoWords()  {
		Assert.assertFalse(new WordPattern().wordPattern("jquery", "jquery"));
	}
}
