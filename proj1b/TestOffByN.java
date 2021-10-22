import org.junit.Assert;
import org.junit.Test;

public class TestOffByN {

    @Test
    public void testOffByN() {
        OffByN offBy5 = new OffByN(5);
        Assert.assertTrue(offBy5.equalChars('a', 'f'));  // true
        Assert.assertTrue(offBy5.equalChars('f', 'a'));  // true
        Assert.assertFalse(offBy5.equalChars('f', 'h'));  // false
    }
}
