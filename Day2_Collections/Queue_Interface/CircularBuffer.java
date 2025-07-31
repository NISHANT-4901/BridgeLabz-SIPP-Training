package Queue_Interface;

public class CircularBuffer {
    private int[] buffer;
    private int size;
    private int start = 0;
    private int count = 0;

    public CircularBuffer(int capacity) {
        buffer = new int[capacity];
        size = capacity;
    }

    public void insert(int value) {
        int index = (start + count) % size;
        buffer[index] = value;
        if (count < size) {
            count++;
        } else {
            start = (start + 1) % size;
        }
    }

    public void printBuffer() {
        for (int i = 0; i < count; i++) {
            int index = (start + i) % size;
            System.out.print(buffer[index] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularBuffer cb = new CircularBuffer(3);
        cb.insert(1);
        cb.insert(2);
        cb.insert(3);
        cb.printBuffer(); // Output: 1 2 3
        cb.insert(4);
        cb.printBuffer(); // Output: 2 3 4
    }
}
