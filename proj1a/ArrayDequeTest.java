import org.junit.Assert;
import org.junit.Test;

public class ArrayDequeTest {
    @Test
    public void addFirstTest() {
        ArrayDeque<Integer> arrayDeque=new ArrayDeque<>();
        arrayDeque.addFirst(0);
        Assert.assertEquals(arrayDeque.get(0),Integer.valueOf(0));
        arrayDeque.addLast(2);
        arrayDeque.addFirst(3);
        arrayDeque.addLast(4);
        arrayDeque.addLast(5);
        arrayDeque.addFirst(6);
        Assert.assertEquals(arrayDeque.removeFirst(),Integer.valueOf(6));
        arrayDeque.addFirst(8);
        arrayDeque.addFirst(9);
        arrayDeque.addFirst(10);
        arrayDeque.removeFirst();
        arrayDeque.addFirst(12);
        arrayDeque.addFirst(13);
        Assert.assertEquals(arrayDeque.removeLast(),Integer.valueOf(5));
    }
}
