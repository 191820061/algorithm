import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestOffByOne {

    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualChars() {
        Assert.assertTrue(offByOne.equalChars('a', 'b'));
        Assert.assertTrue(offByOne.equalChars('r', 'q'));
        Assert.assertFalse(offByOne.equalChars('a', 'e'));
        Assert.assertFalse(offByOne.equalChars('z', 'a'));
        Assert.assertFalse(offByOne.equalChars('a', 'a'));
        Assert.assertTrue(offByOne.equalChars('A', 'B'));
        Assert.assertTrue(offByOne.equalChars('&', '%'));
        Assert.assertFalse(offByOne.equalChars('A', 'b'));
        Assert.assertFalse(offByOne.equalChars('b', 'C'));
    }
}
