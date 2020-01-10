package codes.designs;

/**
 * 数组实现单向队列
 */
public class QueueArray {
    private int length = 0;
    private int start = 0;
    private int end = 0;
    private int size = 0;
    private int[] array;

    public void initQueue(int length) {
        this.length = length;
        array = new int[length];
    }

    public void inQueue(int data) {
        if (size == length) {
            throw new RuntimeException("queue now is full...");
        }
        array[end++] = data;
        size++;
    }

    public int outQueue() {
        if (size == 0) {
            throw new RuntimeException("queue now is empty...");
        }
        size--;
        return array[start++];
    }
}

