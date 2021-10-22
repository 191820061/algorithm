import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    static Palindrome palindrome = new Palindrome();
    static OffByOne one = new OffByOne();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        Assert.assertFalse(palindrome.isPalindrome("cac",one));
        Assert.assertFalse(palindrome.isPalindrome("maam",one));
        Assert.assertFalse(palindrome.isPalindrome("adkjkda",one));
        Assert.assertFalse(palindrome.isPalindrome("racecar",one));
        Assert.assertTrue(palindrome.isPalindrome("a",one));
        Assert.assertFalse(palindrome.isPalindrome("noon",one));
        Assert.assertTrue(palindrome.isPalindrome("unhot",one));
        Assert.assertTrue(palindrome.isPalindrome("flake",one));
    }

    @Test
    public void testIsPalindrome2() {
        Assert.assertTrue(palindrome.isPalindrome("cac"));
        Assert.assertTrue(palindrome.isPalindrome("maam"));
        Assert.assertFalse(palindrome.isPalindrome("sdkjsdk"));
        Assert.assertTrue(palindrome.isPalindrome("adkjkda"));
        Assert.assertTrue(palindrome.isPalindrome("racecar"));
        Assert.assertTrue(palindrome.isPalindrome("a"));
        Assert.assertTrue(palindrome.isPalindrome("noon"));
    }
}
