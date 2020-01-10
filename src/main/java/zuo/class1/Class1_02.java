package zuo.class1;

/**
 * @author : ddv
 * @since : 2019/12/26 9:56 PM
 */

public class Class1_02 {

    public static void main(String[] args) {
        System.out.println(smallSum(new int[] {1, 3, 4, 2, 5}));
    }

    /**
     * 小和问题:每一个数左边比当前数小的数累加起来， 叫做这个数组的小和
     *
     * {1,2,3} = 1*2 + 2*1 = 4
     *
     * {1,3,4,2,5} 1*4 + 3*2 + 4*1 + 2*1 = 4+6+4+2=16
     */
    private static int smallSum(int[] array) {
        return getSmallSum(0, array.length - 1 >= 0 ? array.length - 1 : 0, array);
    }

    private static int getSmallSum(int left, int right, int[] array) {
        if (left == right) {
            return 0;
        }
        int sum = 0;
        int mid = (left + right) >> 1;
        sum += getSmallSum(left, mid, array);
        sum += getSmallSum(mid + 1, right, array);
        sum += mergeArray(left, right, array);
        return sum;
    }

    private static int mergeArray(int left, int right, int[] array) {
        int sum = 0;
        int mid = (left + right) >> 1;
        int leftPoint = left;
        int helpPoint = 0;
        int rightPoint = mid + 1;
        int length = right - left + 1;
        int[] help = new int[length];

        while (leftPoint <= mid && rightPoint <= right) {
            sum += array[leftPoint] < array[rightPoint] ? array[leftPoint] * (right - rightPoint + 1) : 0;
            help[helpPoint++] = array[leftPoint] <= array[rightPoint] ? array[leftPoint++] : array[rightPoint++];
        }

        while (leftPoint <= mid) {
            help[helpPoint++] = array[leftPoint++];
        }

        while (rightPoint <= right) {
            help[helpPoint++] = array[rightPoint++];
        }

        for (int i = 0; i < help.length; i++) {
            array[left + i] = help[i];
        }

        return sum;
    }

}
