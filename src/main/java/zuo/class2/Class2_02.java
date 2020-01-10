package zuo.class2;

import utlis.Utils;

/**
 * @author : ddv
 * @since : 2019/12/27 6:00 PM
 */

public class Class2_02 {
    public static void main(String[] args) {
        // int[] array = {1886, 4934, 9831, 7710, 5802, 4347, 1555, 438, 6906, 5490};
        // quickSort(0, array.length - 1, array);
        // Utils.logArray(array);
        Utils.jujgeArray(10, 10, 1);
    }

    public static void quickSort(int left, int right, int[] array) {
        if (left >= right) {
            return;
        }
        // System.out.println(left + " " + right);
        // Utils.logArray(array);
        quickSortWithRecursive(left, right, array);
        // int point = realQuickSort(left, right, array);
        // quickSort(left, point - 1, array);
        // quickSort(point + 1, right, array);
    }

    private static int realQuickSort(int left, int right, int[] array) {
        if (left >= right) {
            return left;
        }
        int sampleSum = array[left];
        int leftPoint = left;
        int rightPoint = right;

        while (leftPoint < rightPoint) {
            // find small num in right
            while (leftPoint < rightPoint && array[rightPoint] >= sampleSum) {
                rightPoint--;
            }
            if (leftPoint < rightPoint) {
                array[leftPoint++] = array[rightPoint];
            }
            // find more num in left
            while (leftPoint < rightPoint && array[leftPoint] <= sampleSum) {
                leftPoint++;
            }
            if (leftPoint < rightPoint) {
                array[rightPoint--] = array[leftPoint];
            }
            array[leftPoint] = sampleSum;
        }
        return leftPoint;
    }

    /**
     * 递归版
     */
    private static void quickSortWithRecursive(int left, int right, int[] array) {
        if (left >= right) {
            return;
        }
        int leftPoint = left;
        int rightPoint = right;
        int sampleNum = array[left];

        while (leftPoint < rightPoint) {
            while (leftPoint < rightPoint && array[rightPoint] >= sampleNum) {
                rightPoint--;
            }

            if (leftPoint < rightPoint) {
                array[leftPoint++] = array[rightPoint];
            }

            while (leftPoint < rightPoint && array[leftPoint] <= sampleNum) {
                leftPoint++;
            }

            if (leftPoint < rightPoint) {
                array[rightPoint--] = array[leftPoint];
            }
        }

        array[leftPoint] = sampleNum;

        quickSortWithRecursive(left, leftPoint - 1, array);
        quickSortWithRecursive(leftPoint + 1, right, array);
    }
}
