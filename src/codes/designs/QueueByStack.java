package codes.designs;

import java.util.Stack;

public class QueueByStack {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public QueueByStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void offer(int data) {
        stack1.push(data);
    }

    public int poll() {
        if (stack1.isEmpty()) throw new RuntimeException("queue now is empty...");
        int data = 0;
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        data = stack2.pop();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return data;
    }

    public int peek() {
        if (stack1.isEmpty()) throw new RuntimeException("queue now is empty...");
        int data = 0;
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        data = stack2.peek();
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        return data;
    }
}
