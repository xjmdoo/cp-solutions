class MyCircularQueue {
    private int read = 0;
    private int write = -1;
    private int capacity;
    private int[] storage;
    private int size = 0;

    public MyCircularQueue(int k) {
        capacity = k;
        storage = new int[capacity];
    }

    public boolean enQueue(int value) {
        if (!isFull()) {
            write = (write + 1) % capacity;
            storage[write] = value;
            size++;
            return true;
        }

        return false;
    }

    public boolean deQueue() {
        if (!isEmpty()) {
            read = (read + 1) % capacity;
            size--;
            return true;
        }

        return false;
    }

    public int Front() {
        return isEmpty() ?  -1 : storage[read % capacity];
    }

    public int Rear() {
        return isEmpty() ? -1 : storage[write % capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }
}
