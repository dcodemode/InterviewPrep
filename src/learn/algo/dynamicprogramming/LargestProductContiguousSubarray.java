package learn.algo.dynamicprogramming;

/**
 * @author Varma Penmetsa
 *
 * Given an array that contains both positive and negative integers, find the product of the maximum product subarray.
 * Expected Time complexity is O(n) and only O(1) extra space can be used.
 *
 * Examples:
 *
 * Input: arr[] = {6, -3, -10, 0, 2}
 * Output:   180  // The subarray is {6, -3, -10}
 *
 * Input: arr[] = {-1, -3, -10, 0, 60}
 * Output:   60  // The subarray is {60}
 *
 * Input: arr[] = {-2, -3, 0, -2, -40}
 * Output:   80  // The subarray is {-2, -40}
 *
 * Follow Up: Can you do it in O(n) time and O(1) space ?
 *
 * https://www.geeksforgeeks.org/maximum-product-subarray/
 */
public class LargestProductContiguousSubarray {

    /**
     * Time Complexity : O(n)
     * Space Complexity : O(n)
     */
    public static int maxProduct(int[] array) {
        int[] max = new int[array.length];
        int[] min = new int[array.length];

        max[0] = min[0] = array[0];
        int result = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > 0) {
                max[i] = Math.max(array[i], max[i - 1] * array[i]);
                min[i] = Math.min(array[i], min[i - 1] * array[i]);
            } else {
                max[i] = Math.max(array[i], min[i - 1] * array[i]);
                min[i] = Math.min(array[i], max[i - 1] * array[i]);
            }
            result = Math.max(result, max[i]);
        }
        return result;
    }
    /**
     * Application of Kadane's Algorithm
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    public static int maxProduct1(int[] array){
        int maxSoFar = array[0];
        int min = maxSoFar;
        int max = maxSoFar;

        for (int i = 1; i < array.length; i++) {
            // multiplied by a negative makes big number smaller, small number bigger
            // so we redefine the extremums by swapping them
            if(array[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }
            // max/min product for the current number is either the current number itself
            // or the max/min by the previous number times the current one
            max = Math.max(array[i], max * array[i]);
            min = Math.min(array[i], min * array[i]);
            // the newly computed max value is a candidate for our global result
            maxSoFar = Math.max(maxSoFar, max);
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        int array[] = {6, -3, -10, 0, 2};
        System.out.println(maxProduct1(array));
    }
}
