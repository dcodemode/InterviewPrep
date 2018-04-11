package learn.algo.sort;

import learn.util.ArrayUtil;

/**
 * @author Varma Penmetsa
 * https://github.com/mission-peace/interview/blob/68f97392c6f6e14e2c08860684ed605a1a5e7e72/src/com/interview/sort/QuickSort.java
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
        int pivot = partition(array, left, right);
        sort(array, left, pivot - 1);
        sort(array, pivot + 1, right);
    }

    public static int partition(int[] array, int left, int right) {
        int p = left;
        int i = left + 1;
        int j = right;

        while (i <= j) {

            if (array[i] < array[p]) {
                i++;
                continue;
            }

            if (array[p] < array[j]) {
                j--;
                continue;
            }

            ArrayUtil.swap(array, i++, j--);
        }

        //If Pivot is greater the last element swap it.
        if (array[p] >= array[j]) {
            ArrayUtil.swap(array, p, j);
            return j;
        }
        return p;
    }

    public static void main(String[] args) {
        int[] array = {5,1,8,1,1,4,6,5,5,5,3,1};
        ArrayUtil.display(array);
        sort(array);
        ArrayUtil.display(array);
    }
}
