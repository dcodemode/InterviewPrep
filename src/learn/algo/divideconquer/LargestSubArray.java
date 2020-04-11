package learn.algo.divideconquer;

/**
 *
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 * Follow up:
 *
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 *
 *
 * https://leetcode.com/problems/maximum-subarray/
 *
 */
public class LargestSubArray {

    public static int crossSum(int[] array, int left, int right, int mid){
        if(left == right) return array[left];

        int leftSubSum = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = mid; i > left-1 ; --i){
            sum += array[i];
            leftSubSum = Math.max(sum, leftSubSum);
        }

        int rightSubSum = Integer.MIN_VALUE;
        sum = 0;
        for(int i = mid+1 ; i < right + 1 ; ++i){
            sum += array[i];
            rightSubSum = Math.max(sum, rightSubSum);
        }
        return leftSubSum + rightSubSum ;
    }

    public static int rec(int[] array, int left, int right){
        if(left == right){
            return array[left];
        }
        int mid = (left + right)/2;
        int leftSum = rec(array, left, mid);
        int rightSum = rec(array, mid+1, right);
        int sum = crossSum(array, left, right,  mid);
        return Math.max(Math.max(leftSum, rightSum),sum);

    }

    /**
     *
     * Algorithm
     *
     * maxSubArray for array with n numbers:
     *
     * If n == 1 : return this single element.
     *
     * left_sum = maxSubArray for the left subarray, i.e. for the first n/2 numbers (middle element at index (left + right) / 2 always belongs to the left subarray).
     *
     * right_sum = maxSubArray for the right subarray, i.e. for the last n/2 numbers.
     *
     * cross_sum = maximum sum of the subarray containing elements from both left and right subarrays and hence crossing the middle element at index (left + right) / 2.
     *
     * Merge the subproblems solutions, i.e. return max(left_sum, right_sum, cross_sum).
     *
     *
     * Time Complexity: O(n log n)
     * Space complexity O(log n)
     */
    public static int maxSubArray(int[] array){
        return rec(array, 0, array.length-1);
    }

    public static void main(String[] args) {
        int[] array = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(array));
    }

}
