package learn.ds.array;

/**
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 *
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4], the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 *
 * @author Varma Penmetsa
 *
 * https://www.geeksforgeeks.org/?p=576
 */
public class LargestSumContiguousSubarray {

    /**
     * Kardane's Algorithm
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(1)
     */
    public static int maxSum(int[] array) {
        if (array.length == 0)
            return -1;

        int n = array.length;
        int max = 0, sum = 0;

        for (int i = 0; i < n; i++) {
            sum += array[i];

            if (sum < 0) {
                sum = 0;
            }

            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array =  {4,-1,2,1};
        System.out.println(maxSum(array));
    }

}
