public class LinkedListDeque<T> {
    public class Node {
        public T item;
        public Node next;
        public Node prev;

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

    public LinkedListDeque(LinkedListDeque other) {
        this.size = 0;
        sentinel = new Node();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;

        for (int i = 0; i < other.size(); i++) {
            addLast((T) other.get(i));
        }
    }

    public void addFirst(T item) {
        size++;
        sentinel.next = new Node(item, sentinel.next);
        sentinel.next.prev = sentinel;
        sentinel.next.next.prev = sentinel.next;
    }

    public T getFirst() {
        return sentinel.next.item;
    }

    public void addLast(T item) {
        size++;
        sentinel.prev.next = new Node(item, sentinel);
        sentinel.prev.next.prev = sentinel.prev;
        sentinel.prev = sentinel.prev.next;
    }

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

    public T getLast() {
        return sentinel.prev.item;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void printDeque() {
        Node p = sentinel.next;
        while (!p.equals(sentinel)) {
            System.out.print(p.item);
            System.out.print(" ");
            p = p.next;
        }
        System.out.println();
    }

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
}