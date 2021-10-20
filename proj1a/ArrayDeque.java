public class ArrayDeque<T> {
    private T[] element;
    private int size;
    private int maxSize;
    private int nextFirst;
    private int nextLast;

    public ArrayDeque() {
        element = (T[]) new Object[8];
        size = 0;
        maxSize = 8;
        nextFirst = 4;
        nextLast = 5;
    }

    private T getFirst() {
        int currentFirst = nextFirst + 1 == maxSize ? 0 : nextFirst + 1;
        return element[currentFirst];
    }

    private T getLast() {
        int currentLast = nextLast == 0 ? maxSize - 1 : nextLast - 1;
        return element[currentLast];
    }

    public void addFirst(T item) {
        if (size == maxSize) {
            expandArray();
        }
        size++;
        element[nextFirst] = item;
        nextFirst = nextFirst == 0 ? maxSize + nextFirst - 1 : nextFirst - 1;
    }

    public void addLast(T item) {
        if (size == maxSize) {
            expandArray();
        }
        size++;
        element[nextLast] = item;
        nextLast = nextLast + 1 == maxSize ? 0 : nextLast + 1;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public T removeFirst() {
        double usage = (double) size / (double) maxSize;
        if (maxSize >= 16 && usage < 0.25) {
            shrinkArray();
        }
        if (!isEmpty()) {
            size--;
            nextFirst = nextFirst + 1 == maxSize ? 0 : nextFirst + 1;
            T item = element[nextFirst];
            element[nextFirst] = null;
            return item;
        }
        return null;
    }

    public T removeLast() {
        double usage = (double) size / (double) maxSize;
        if (maxSize >= 16 && usage < 0.25) {
            shrinkArray();
        }
        if (!isEmpty()) {
            size--;
            nextLast = nextLast == 0 ? maxSize - 1 : nextLast - 1;
            T item = element[nextLast];
            element[nextLast] = null;
            return item;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        int currentFirst = nextFirst + 1 == maxSize ? 0 : nextFirst + 1;
        int currentLast = nextLast == 0 ? maxSize - 1 : nextLast - 1;
        while (currentFirst != currentLast) {
            System.out.print(element[currentFirst]);
            System.out.print(" ");
            currentFirst = currentFirst + 1 == maxSize ? 0 : currentFirst + 1;
        }
        System.out.print(element[currentLast]);
        System.out.println();
    }

    public T get(int index) {
        if (index <= size - 1) {
            int current = nextFirst + 1 == maxSize ? 0 : nextFirst + 1;
            int needPos = current + index >= maxSize ? current + index - maxSize : current + index;
            return element[needPos];
        }
        return null;
    }

    private void expandArray() {
        T[] copy = (T[]) new Object[maxSize * 2];
        int currentFirst = 3;
        for (int i = 0; i < size; i++) {
            copy[i + currentFirst] = get(i);
        }
        nextFirst = 2;
        nextLast = currentFirst + size;
        maxSize = maxSize * 2;
        element = copy;
    }

    private void shrinkArray() {
        T[] copy = (T[]) new Object[maxSize / 2];
        int currentFirst = 3;
        for (int i = 0; i < size; i++) {
            copy[i + currentFirst] = get(i);
        }
        nextFirst = 2;
        nextLast = currentFirst + size;
        maxSize = maxSize / 2;
        element = copy;
    }

}
