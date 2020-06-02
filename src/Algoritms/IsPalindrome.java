package Algoritms;
//125 Easy. Valid Palindrome https://leetcode.com/problems/valid-palindrome/
//Success
//Runtime: 1 ms, faster than 100.00% of Java online submissions for Valid Palindrome.
//Memory Usage: 39.5 MB, less than 25.00% of Java online submissions for Valid Palindrome.
import org.junit.Assert;
import org.junit.Test;

public class IsPalindrome {
    public boolean isPalindrome(String s) {
        int length = s.length();
        int leftPos = 0;
        char leftCh;
        int rightPos = s.length() - 1;
        char rightCh;
        final int LOW_BORDER_LOW_CHARACTERS = 'a';
        final int HIGH_BORDER_LOW_CHARACTERS = 'z';
        final int LOW_BORDER_HIGH_CHARACTERS = 'A';
        final int HIGH_BORDER_HIGH_CHARACTERS = 'Z';
        final int SHIFT_BETWEEN_LOW_AND_HIGH = 'a' - 'A'; //32
        final int LOW_BORDER_NUMBER = '0';
        final int HIGH_BORDER_NUMBER = '9';

        while (leftPos < rightPos) {
            leftCh = s.charAt(leftPos);
            while (!((leftCh >= LOW_BORDER_LOW_CHARACTERS && leftCh <= HIGH_BORDER_LOW_CHARACTERS) || (leftCh >= LOW_BORDER_HIGH_CHARACTERS && leftCh <= HIGH_BORDER_HIGH_CHARACTERS) || (leftCh >= LOW_BORDER_NUMBER && leftCh <= HIGH_BORDER_NUMBER))) {
                leftPos++;
                if ((leftPos > rightPos) || leftPos > length - 1 || rightPos < 0) {
                    return true;
                }
                leftCh = s.charAt(leftPos);
            }
            rightCh = s.charAt(rightPos);
            while (!((rightCh >= LOW_BORDER_LOW_CHARACTERS && rightCh <= HIGH_BORDER_LOW_CHARACTERS) || (rightCh >= LOW_BORDER_HIGH_CHARACTERS && rightCh <= HIGH_BORDER_HIGH_CHARACTERS) || (rightCh >= LOW_BORDER_NUMBER && rightCh <= HIGH_BORDER_NUMBER))) {
                rightPos--;
                rightCh = s.charAt(rightPos);
                if (leftPos > rightPos) {
                    return true;
                }
            }
            if (leftCh >= LOW_BORDER_LOW_CHARACTERS && leftCh <= HIGH_BORDER_LOW_CHARACTERS) {
                if (leftCh != rightCh && (leftCh - SHIFT_BETWEEN_LOW_AND_HIGH) != rightCh) { //32 - место где
                    return false;
                }
            } else if (leftCh >= LOW_BORDER_HIGH_CHARACTERS && leftCh <= HIGH_BORDER_HIGH_CHARACTERS) {
                if (leftCh != rightCh && (leftCh + SHIFT_BETWEEN_LOW_AND_HIGH) != rightCh) { //32 - место где
                    return false;
                }
            } else {
                if (leftCh != rightCh) {
                    return false;
                }
            }
            leftPos++;
            rightPos--;
        }
        return true;
    }

    @Test
    public void testIsPalindrome() {
        Assert.assertEquals(new IsPalindrome().isPalindrome("A man, a plan, a canal: Panama"), true);
        Assert.assertTrue(new IsPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        Assert.assertTrue(new IsPalindrome().isPalindrome(".,"));
        Assert.assertFalse(new IsPalindrome().isPalindrome("race a car"));
        Assert.assertFalse(new IsPalindrome().isPalindrome("0P"));
        Assert.assertTrue(new IsPalindrome().isPalindrome("\"Sirrah! Deliver deified desserts detartrated!\" stressed deified, reviled Harris."));
        Assert.assertTrue(new IsPalindrome().isPalindrome("`l;`` 1o1 ??;l`"));
        String hardcoreString = "QZrD2 7UL91z,i`O2ef:6e'2\"yP !:,U.:pX90PU3CXo'i!;3 `j 0?\"'hK8 ? BAjM2\"DBw?7!4R3?U2E8F2y!?3 R2!fw 6e!:0  ErCi98KM`,8`8648,mi3P0`,!5 E.?00J3A 52\"x8,tHy!'2!DLBbK'j!tt1C' 7`JPulW\"\"uRTbr\"',\",U`ZOW5'\"LMDQDMJ\"'5WOZ`U,\",'\"rbTRu\"\"WluPJ`7 'C1tt!j'KbBJD!2'!yHt,8x\"25 A3J00?.E 5!,`0P3im,8468`8,`MK89iCrE  0:!e6 wf!2R 3?!y2F8E2U?3R4!7?wBD\"2MjAB ? 8Kh'\"?0 j` 3;!i'oXC3UP09Xp:.U,:! Py\"2'e6:fe2O`i,z19LU7 2DrZQ";
        Assert.assertFalse(new IsPalindrome().isPalindrome(hardcoreString));
        hardcoreString = hardcoreString.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        Assert.assertFalse(new IsPalindrome().isPalindrome(hardcoreString));
    }

    public static void main(String[] args) {
        String hardcoreStr = "QZrD2 7UL91z,i`O2ef:6e'2\"yP !:,U.:pX90PU3CXo'i!;3 `j 0?\"'hK8 ? BAjM2\"DBw?7!4R3?U2E8F2y!?3 R2!fw 6e!:0  ErCi98KM`,8`8648,mi3P0`,!5 E.?00J3A 52\"x8,tHy!'2!DLBbK'j!tt1C' 7`JPulW\"\"uRTbr\"',\",U`ZOW5'\"LMDQDMJ\"'5WOZ`U,\",'\"rbTRu\"\"WluPJ`7 'C1tt!j'KbBJD!2'!yHt,8x\"25 A3J00?.E 5!,`0P3im,8468`8,`MK89iCrE  0:!e6 wf!2R 3?!y2F8E2U?3R4!7?wBD\"2MjAB ? 8Kh'\"?0 j` 3;!i'oXC3UP09Xp:.U,:! Py\"2'e6:fe2O`i,z19LU7 2DrZQ";
        System.out.println(new IsPalindrome().isPalindrome(hardcoreStr));
        hardcoreStr = hardcoreStr.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
        System.out.println(new IsPalindrome().isPalindrome(hardcoreStr));
    }

}