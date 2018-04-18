package learn.algo.sort;

import learn.util.ArrayUtil;

/**
 * @author Varma Penmetsa
 * https://github.com/mission-peace/interview/blob/68f97392c6f6e14e2c08860684ed605a1a5e7e72/src/com/interview/sort/QuickSort.java
 * https://www.youtube.com/watch?v=SLauY6PpjW4&t=283s
 */
public class QuickSort {

    /**
     * Time  : O (n log n)
     * Space : O(n)
     */
    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    public static void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = array[left + (right - left) / 2];
        int index = partition(array, pivot, left, right);
        sort(array, left, index - 1);
        sort(array, index, right);
    }

    public static int partition(int[] array, int pivot, int left, int right) {
        while (left <= right) {

            if (array[left] < pivot) {
                left++;
                continue;
            }

            if (array[right] > pivot) {
                right--;
                continue;
            }

            ArrayUtil.swap(array, left++, right--);
        }
        return left;
    }

    public static void main(String[] args) {
        int[] array = ArrayUtil.generateRandomArray(15,9);
        ArrayUtil.display(array);
        sort(array);
        ArrayUtil.display(array);
    }
}
