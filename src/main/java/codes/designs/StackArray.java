package codes.designs;

public class StackArray {
    private int[] array = new int[3];
    private int index = -1;

    public void push(int data) {
        if (index == 2) {
            throw new RuntimeException("stack now is full...");
        }
        array[++index] = data;
    }

    public int pop() {
        if (index < 0) {
            throw new RuntimeException("stack now is empty...");
        }
        return array[index--];
    }

    public int peek() {
        if (index < 0) {
            throw new RuntimeException("stack now is empty...");
        }
        return array[index];
    }
}
