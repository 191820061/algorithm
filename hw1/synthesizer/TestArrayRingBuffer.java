package synthesizer;

import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

/**
 * Tests the ArrayRingBuffer class.
 *
 * @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Double> arb = new ArrayRingBuffer<>(100);
        for (int i = 0; i < arb.capacity(); i++) {
            Double value = Math.random() - 0.5;
            arb.enqueue(value);
        }
        for (Double d : arb) {
            System.out.println(d);
        }

    }

    /**
     * Calls tests for ArrayRingBuffer.
     */
    public static void main(String[] args) {
        jh61b.junit.textui.runClasses(TestArrayRingBuffer.class);
    }
} 
