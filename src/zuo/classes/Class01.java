package zuo.classes;

/**
 *
 * b中有 a没有的数
 *
 * @author : ddv
 * @since : 2019/12/23 6:06 PM
 */

public class Class01 {
    static int[] array = new int[] {1, 3, 5, 6, 9};
    static int[] secondArray = new int[] {1, 4, 5, 7, 9};

    public static void main(String[] args) {
        int pointA = 0;
        int pointB = 0;

        while (pointA < array.length - 1 || pointB < secondArray.length - 1) {
            if (secondArray[pointB] < array[pointA]) {
                System.out.print(secondArray[pointB++] + " ");
            } else if (secondArray[pointB] == array[pointA]) {
                pointB++;
            } else {
                pointA++;
            }
        }

        System.out.println();
    }
}
