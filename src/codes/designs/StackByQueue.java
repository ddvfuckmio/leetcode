package codes.designs;

import java.util.LinkedList;
import java.util.Queue;


/*
使用两个队列构造栈 💕
每次出栈交换队列元素即可
*/
public class StackByQueue {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public StackByQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    public void push(int data) {
        queue1.offer(data);
    }

    public int pop() {
        if (queue1.size() < 1) throw new RuntimeException("stack now if empty...");
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        switchQueue();
        return queue2.poll();
    }

    public int peek() {
        if (queue1.size() < 1) throw new RuntimeException("stack now if empty...");
        while (queue1.size() > 1) {
            queue2.add(queue1.poll());
        }
        queue2.offer(queue1.peek());
        switchQueue();
        return queue2.poll();
    }

    public void switchQueue() {
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }


}
