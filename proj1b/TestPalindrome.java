import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    static Palindrome palindrome = new Palindrome();

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
    public void testIsPalindrome(){
        Assert.assertTrue(palindrome.isPalindrome("cac"));
        Assert.assertTrue(palindrome.isPalindrome("maam"));
        Assert.assertFalse(palindrome.isPalindrome("sdkjsdk"));
        Assert.assertTrue(palindrome.isPalindrome("adkjkda"));
        Assert.assertTrue(palindrome.isPalindrome("racecar"));
        Assert.assertTrue(palindrome.isPalindrome("a"));
        Assert.assertTrue(palindrome.isPalindrome("noon"));
    }
}
