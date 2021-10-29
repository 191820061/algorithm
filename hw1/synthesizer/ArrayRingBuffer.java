package synthesizer;

import java.util.Iterator;

public class ArrayRingBuffer<T> implements BoundedQueue<T> {
    private int fillCount;
    private int capacity;
    /* Index for the next dequeue or peek. */
    private int first;
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        rb = (T[]) new Object[capacity];
        this.fillCount = 0;
        this.capacity = capacity;
        this.first = 0;
        this.last = 0;
    }

    @Override
    public int capacity() {
        return capacity;
    }

    @Override
    public int fillCount() {
        return fillCount;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }
        this.fillCount++;
        rb[last] = x;
        last = last + 1 == capacity ? 0 : last + 1;
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        this.fillCount--;
        T item = rb[first];
        rb[first] = null;
        first = first + 1 == capacity ? 0 : first + 1;
        return item;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        return rb[first];
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueIterator();
    }

    private class QueueIterator implements Iterator<T> {
        private int index = first - 1;
        private boolean status = false;

        @Override
        public boolean hasNext() {
            int nextIndex = index + 1 == capacity ? 0 : index + 1;
            if (isFull()) {
                if (nextIndex == last) {
                    status = !status;
                }
                return status;
            } else {
                return nextIndex != last;
            }
        }

        @Override
        public T next() {
            index = index + 1 == capacity ? 0 : index + 1;
            return rb[index];
        }
    }
}
