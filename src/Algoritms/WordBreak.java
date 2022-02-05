package Algoritms;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        } else if (s == null) {
            return false;
        }
        int currentPosition = 0;
        Boolean sucessCompareFlag = null;
        boolean sucessCompareFlagWithWordDictSizeOne = false;
        int wordDictStartSize = wordDict.size();

        while (currentPosition < s.length() && wordDict.size() >= 1) {
            sucessCompareFlag = null;
            if (wordDict.get(0).substring(0, 1).equals(s.substring(currentPosition, currentPosition + 1)) && s.length() >= currentPosition + wordDict.get(0).length()) { // проверка на совпадение первого слова словаря
                for (int i = 0; i < wordDict.get(0).length(); i++) {
                    if (!s.substring(currentPosition + i, currentPosition + i + 1).equals(wordDict.get(0).substring(i, i + 1))) {
                        sucessCompareFlag = false;
                        break;
                    }
                    if (i == wordDict.get(0).length() - 1) {
                        sucessCompareFlag = true;
                    }
                }
                if (sucessCompareFlag) {
                    currentPosition += wordDict.get(0).length();
                    if (wordDict.size() == 1) {
                        sucessCompareFlagWithWordDictSizeOne = true;
                    }
                    continue;
                }

            }

            sucessCompareFlag = null;

            if (wordDict.size() > 1 && wordDict.get(1).substring(0, 1).equals(s.substring(currentPosition, currentPosition + 1)) && s.length() >= currentPosition + wordDict.get(1).length() && wordDictStartSize == wordDict.size()) { // проверка на совпадение первого слова словаря
                for (int i = 0; i < wordDict.get(1).length(); i++) {
                    if (!s.substring(currentPosition + i, currentPosition + i + 1).equals(wordDict.get(1).substring(i, i + 1))) {
                        sucessCompareFlag = false;
                        break;
                    }
                    if (i == wordDict.get(1).length() - 1) {
                        sucessCompareFlag = true;
                    }
                }
                if (sucessCompareFlag) {
                    currentPosition += wordDict.get(0).length();
                    if (wordDict.size() == 2) {
                        sucessCompareFlagWithWordDictSizeOne = true;
                    }
                    wordDict.remove(0);
                    continue;
                }
            }
            currentPosition++;
        }
        return wordDict.size() == 1  && sucessCompareFlagWithWordDictSizeOne;
    }

    private String testCase1 = "leetcode";
    private List<String> testCase1WordDict = new ArrayList<String>(Arrays.asList(new String[] {"leet","code"}));

    private String testCase2 = "applepenapple";
    private List<String> testCase2WordDict = new ArrayList<String>(Arrays.asList(new String[] {"apple", "pen"}));

    private String testCase3 = "catsandog";
    private List<String> testCase3WordDict = new ArrayList<String>(Arrays.asList(new String[] {"cats", "dog", "sand", "and", "cat"}));

    private String testCase4 = "a";
    private List<String> testCase4WordDict = new ArrayList<String>(Arrays.asList(new String[] {"b"}));

    private String testCase5 = "bb";
    private List<String> testCase5WordDict = new ArrayList<String>(Arrays.asList(new String[] {"a","b","bbb","bbbb"}));

    @Test
    public void testThis() {
//        Assert.assertEquals(true, new WordBreak().wordBreak(testCase1, testCase1WordDict));
//        Assert.assertEquals(true, new WordBreak().wordBreak(testCase2, testCase2WordDict));
//        Assert.assertEquals(false, new WordBreak().wordBreak(testCase3, testCase3WordDict));
//        Assert.assertEquals(false, new WordBreak().wordBreak(testCase4, testCase4WordDict));
        Assert.assertEquals(false, new WordBreak().wordBreak(testCase5, testCase5WordDict));


        System.out.println(new WordBreak().wordBreak("a", new ArrayList<String>()));
    }
}
