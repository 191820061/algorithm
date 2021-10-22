public class LinkedListDeque<T> implements Deque<T>{
    private class Node {
        private T item;
        private Node next;
        private Node prev;

        public Node(T item, Node next) {
            this(item, null, next);
        }

        public Node(T item) {
            this(item, null, null);
        }

        public Node() {
            this(null, null, null);
        }

        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.next = next;
            this.prev = prev;
        }
    }

    private int size;
    private Node sentinel;

    public LinkedListDeque() {
        sentinel = new Node();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T item) {
        size++;
        sentinel.next = new Node(item, sentinel.next);
        sentinel.next.prev = sentinel;
        sentinel.next.next.prev = sentinel.next;
    }

    private T getFirst() {
        return sentinel.next.item;
    }

    @Override
    public void addLast(T item) {
        size++;
        sentinel.prev.next = new Node(item, sentinel);
        sentinel.prev.next.prev = sentinel.prev;
        sentinel.prev = sentinel.prev.next;
    }

    @Override
    public T removeFirst() {
        if (!isEmpty()) {
            size--;
            T item = sentinel.next.item;
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
            return item;
        }
        return null;
    }

    @Override
    public T removeLast() {
        if (!isEmpty()) {
            size--;
            T item = sentinel.prev.item;
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
            return item;
        }
        return null;
    }

    private T getLast() {
        return sentinel.prev.item;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void printDeque() {
        Node p = sentinel.next;
        while (!p.equals(sentinel)) {
            System.out.print(p.item);
            System.out.print(" ");
            p = p.next;
        }
        System.out.println();
    }

    @Override
    public T get(int index) {
        if (index <= (size - 1)) {
            Node p = sentinel;
            while (index >= 0) {
                p = p.next;
                index--;
            }
            return p.item;
        }
        return null;
    }

    public T getRecursive(int index) {
        return getRecursive(sentinel.next, index);
    }

    private T getRecursive(Node p, int index) {
        if (index == 0) {
            return p.item;
        }
        return getRecursive(p.next, index - 1);
    }

}
