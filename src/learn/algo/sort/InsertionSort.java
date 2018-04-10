package learn.algo.sort;

import learn.ds.util.ArrayUtil;

/**
 * @author Varma Penmetsa
 * https://www.geeksforgeeks.org/insertion-sort/
 */
public class InsertionSort {

    /**
     * Iterative
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     *
     */
    public static void sort(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 8, 5, 9, 4, 1, 6};
        sort(array);
        ArrayUtil.display(array);
    }
}
