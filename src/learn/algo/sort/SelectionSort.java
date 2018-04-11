package learn.algo.sort;

import learn.util.ArrayUtil;

public class SelectionSort {

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     * https://www.geeksforgeeks.org/selection-sort/
     */

    public static void sort(int[] array) {
        int i, j;
        for (i = 0; i < array.length - 1; i++) {
            int min_index = i;
            for (j = i + 1; j < array.length; j++) {
                if (array[min_index] > array[j]) {
                    min_index = j;
                }
            }
            int temp = array[i];
            array[i] = array[min_index];
            array[min_index] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 8, 5, 9, 4, 1, 6};
        sort(array);
        ArrayUtil.display(array);
    }

}
