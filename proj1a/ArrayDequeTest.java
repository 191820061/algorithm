import org.junit.Assert;
import org.junit.Test;

public class ArrayDequeTest {
    @Test
    public void addFirstTest() {
        ArrayDeque<Integer> array = new ArrayDeque<>();
        for (int i = 0; i < 8; i++) {
            array.addLast(i);
        }
        array.addFirst(78);
        for (int i = 0; i < 8; i++) {
            array.removeFirst();
        }
        array.removeFirst();
    }
}
