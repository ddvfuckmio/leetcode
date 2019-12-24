package nowcoder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();

    private static class MyTask implements Runnable {
        int a;

        public MyTask(int a) {
            this.a = a;
        }

        @Override
        public void run() {
            try {

                if (threadLocal.get() == null) {
                    threadLocal.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                }
                Date date = threadLocal.get().parse("2015-03-29 19:29:" + a % 60);
                System.out.println(a + " " + " " + date + threadLocal.get().hashCode());
                threadLocal.remove();

            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add(i);
        }
        while (true) {
            System.out.println(list.stream().findAny().get());
        }

    }

    private static int sort(int[] array) {
        if (array == null)
            return 0;
        return sort(array, 0, array.length - 1);
    }

    private static int sort(int[] array, int start, int end) {
        if (start == end)
            return array[start];
        int mid = (start + end) >> 1;
        int a = sort(array, start, mid);
        int b = sort(array, mid + 1, end);
        return a > b ? a : b;
    }

}
