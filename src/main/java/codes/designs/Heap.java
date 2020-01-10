package codes.designs;

import utlis.Utils;

public class Heap {}

class MaxHeap {
    private int[] array;
    private int size;
    private int index = -1;

    public MaxHeap() {
        size = 100;
        array = new int[size];
    }

    public MaxHeap(int size) {
        this.size = size;
        array = new int[this.size];
    }

    public void makeMaxHeap(int[] a) {
        for (int i = 0; i < a.length; i++) {
            insertHeap(a[i]);
        }
    }

    // 建立大根堆  时间复杂度(n)
    public void insertHeap(int data) {
        if (index == size - 1) throw new RuntimeException("heap now is full...");
        int currentIndex = ++index;
        array[currentIndex] = data;
        while (currentIndex > 0 && array[currentIndex] > array[(currentIndex - 1) >> 1]) {
            Utils.swapElement(array, currentIndex, (currentIndex - 1) >> 1);
            currentIndex = (currentIndex - 1) >> 1;
        }
    }

    // 重排堆 时间复杂度 O(nlogn)
    public void heapfiy(int currentIndex, int heapSize) {
        int left = currentIndex * 2 + 1;
        while (left < heapSize) {
            int newIndex = left + 1 < heapSize && array[left + 1] > array[left] ? left + 1 : left;
            if (array[newIndex] <= array[currentIndex]) {
                break;
            }
            Utils.swapElement(array, currentIndex, newIndex);
            currentIndex = newIndex;
            left = currentIndex * 2 + 1;
        }
    }

    public void logHeap() {
        Utils.logArray(array);
    }

    public void heapSort() {
        for (int i = index; i > 0; i--) {
            Utils.swapElement(array, 0, i);
            heapfiy(0, i);
        }
    }

    public void modify(int index, int data) {
        if (index > this.index || index < 0) throw new RuntimeException("index out of range ...");
        array[index] = data;
    }
}
