package learn.ds.array;

import learn.util.ArrayUtil;

/**
 * @author Varma Penmetsa
 *
 * An array contains both positive and negative numbers in random order.
 * Rearrange the array elements so that positive and negative numbers are placed alternatively.
 * Number of positive and negative numbers need not be equal. If there are more positive numbers they appear at the end of the array.
 * If there are more negative numbers, they too appear in the end of the array.
 *
 * For example, if the input array is [-1, 2, -3, 4, 5, 6, -7, 8, 9],
 * then the output should be [9, -7, 8, -3, 5, -1, 2, 4, 6]
 *
 * https://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers-publish/
 */
public class RearrangePositiveNegativeNumbes {

    /**
     *
     *  The solution is to first separate positive and negative numbers using partition process of QuickSort.
     *  Once negative and positive numbers are separated, we start from the first negative number and first positive number,
     *  and swap every alternate negative number with next positive number.
     *
     * Time Complexity: O (n)
     * Space Complexity: O (1)
     */
    public static void rearrange(int[] arr) {
        int p = partition(arr);

        for (int i = 0; i < p && p < arr.length; i += 2) {
            ArrayUtil.swap(arr, i, p++);
        }
    }

    public static int partition(int[] arr) {
        int low = 0;
        int high = arr.length - 1;
        while (low < high) {
            if (arr[low] < 0) {
                low++;
            } else if (arr[high] >= 0) {
                high--;
            } else {
                ArrayUtil.swap(arr, low, high);
            }
        }
        return low;
    }

    public static void main(String[] args) {

        int[] array = ArrayUtil.generateRandomArray(7);
        ArrayUtil.display(array);
        rearrange(array);
        ArrayUtil.display(array);
    }


}
