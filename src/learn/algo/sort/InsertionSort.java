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
    public static void sort(int[] array) {

        //Starting from 1, since beacuse there will be nothing to compare before the first element
        for (int i = 1; i < array.length; i++) {
            int val = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > val) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = val;
        }
    }

    /**
     * Recursive
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */
    public static void sort(int[] array, int n) {
        if (n <= 1) {
            return;
        }

        sort(array, n - 1);

        int last = array[n - 1];
        int j = n - 2;

        while (j >= 0 && array[j] > last) {
            array[j + 1] = array[j];
            j--;
        }
        array[j + 1] = last;
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 8, 5, 9, 4, 1, 6};
        sort(array,array.length);
        ArrayUtil.display(array);
    }
}
