package Algoritms;
//Task 58 Easy. Length of Last Word    https://leetcode.com/problems/length-of-last-word/
//Success
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Length of Last Word.
//Memory Usage: 35.6 MB, less than 100.00% of Java online submissions for Length of Last Word.

public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        int longestWord = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ' && longestWord != 0) {
                return longestWord;
            } else if (s.charAt(i) != ' ') {
                longestWord++;
            }
        }
        return longestWord;
    }
}
