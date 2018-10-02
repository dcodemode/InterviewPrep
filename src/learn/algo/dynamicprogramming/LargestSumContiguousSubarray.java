package learn.algo.dynamicprogramming;

/**
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 *
 * @author Varma Penmetsa
 *
 * https://www.programcreek.com/2013/02/leetcode-maximum-subarray-java/
 */
public class LargestSumContiguousSubarray {

    /**
     * Time Complexity  : O(n)
     * Space Complexity : O(n)
     */

    public static int maxSum(int[] array) {
        int max = array[0];
        int[] sum = new int[array.length];
        sum[0] = array[0];

        for (int i = 1; i < array.length; i++) {
            sum[i] = Math.max(array[i], sum[i - 1] + array[i]);
            max = Math.max(max, sum[i]);
        }

        return max;
    }

    /**
     * Kadane's Algorithm
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     * https://www.youtube.com/watch?v=86CQq3pKSUw&t=587s
     */
    public static int maxSum1(int[] array) {
        int sum = array[0];
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            sum = Math.max(sum + array[i], array[i]);
            max = Math.max(max, sum);
        }

        return max;
    }

    public static void main(String[] args) {
        int array[] = {4,-1,2,1};
        System.out.println(maxSum1(array));
        System.out.println(maxSum(array));
    }
}
