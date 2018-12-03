package nowcoder;

import utlis.Utils;

import java.util.Scanner;

class StackArray {
    private int[] array = new int[50];
    private int index = -1;

    private void log() {
        Utils.logArray(array);
    }

    public void push(int data) {

        array[++index] = data;
        log();
    }

    public void pop() {
        //		System.out.println("pop...");
        if (index < 0) {
            log();
            return;
        }
        array[index--] = 0;
        log();
    }

    public void delete(int data) {
        if (index < 0) {
            log();
            return;
        }
        for (int i = index; i >= 0; i--) {
            if (array[i] == data) {
                for (int j = i; j < index + 1; j++) {
                    array[j] = array[j + 1];
                }
                index--;
                log();
                return;
            }
        }
        log();
    }

    public void query() {
        //		System.out.println("query...");
        if (index < 0) {
            System.out.println(0);
            return;
        }
        System.out.println(array[index]);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StackArray stack = new StackArray();
        while (true) {
            String operation = sc.next();
            switch (operation) {
                case "push":
                    stack.push(sc.nextInt());
                    break;
                case "delete":
                    stack.delete(sc.nextInt());
                    break;
                case "query":
                    stack.query();
                    break;
                case "pop":
                    stack.pop();
                    break;
            }
        }
    }
}
