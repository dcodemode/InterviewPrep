package learn.ds.array;

import learn.util.ArrayUtil;

/**
 * @author Varma Penmetsa
 *
 * Given an array (or string), the task is to reverse the array/string.
 *
 * Examples :
 * Input  : arr[] = {1, 2, 3}
 * Output : arr[] = {3, 2, 1}
 *
 * Input :  arr[] = {4, 5, 1, 2}
 * Output : arr[] = {2, 1, 5, 4}
 *
 * https://www.geeksforgeeks.org/write-a-program-to-reverse-an-array-or-string/
 */
public class Reverse {

    /**
     * Iteration
     * Time  : O(n)
     * Space : O(1)
     */
    public static void rev(int[] array) {
        int n = array.length - 1;

        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[n];
            array[n--] = temp;
        }
    }

    /**
     * Recursive
     * Time      : O(n)
     * Space     : O(n)
     */
    public static void rev1(int[] array, int mid, int i, int j) {
        if (i == mid) {
            return;
        }
        ArrayUtil.swap(array, i++, j--);
        rev1(array, mid, i, j);
    }

    public static void main(String[] args) {
        int[] array = ArrayUtil.generateRandomArray(6, 9);
        ArrayUtil.display(array);
        // Rotate 1
        rev(array);
        ArrayUtil.display(array);
        int mid = array.length / 2;
        //Rotate 2
        rev1(array, mid, 0, array.length - 1);
        ArrayUtil.display(array);
    }
}
