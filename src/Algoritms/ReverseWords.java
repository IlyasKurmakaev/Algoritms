package Algoritms;
//Task 151 Reverse Words in a String https://leetcode.com/problems/reverse-words-in-a-string/
//Success
//Runtime: 3 ms, faster than 91.13% of Java online submissions for Reverse Words in a String.
//Memory Usage: 38.8 MB, less than 94.04% of Java online submissions for Reverse Words in a String.
public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null) return null;
        StringBuffer res = new StringBuffer();
        StringBuffer tempWord = new StringBuffer();
        char tempChar;
        for (int i = s.length() - 1; i >= 0; i--) {
            tempChar = s.charAt(i);
            if (tempChar != ' '){
                tempWord.append(tempChar);
            } else {
                if (tempWord.length() != 0) {
                    if (res.length() != 0) {
                        res.append(" ");
                    }
                    res.append(tempWord.reverse());
                    tempWord.setLength(0);
                }
            }
        }
        if (tempWord.length() != 0) {
            if (res.length() != 0) {
                res.append(" ");
            }
            res.append(tempWord.reverse());
        }
        return String.valueOf(res);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWords().reverseWords("qwer asdf zxcv  "));
    }
}
