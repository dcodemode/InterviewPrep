package learn.ds.array;

/**
 * Given a circular integer array nums of length n, return the maximum possible
 * sum of a non-empty subarray of nums.
 *
 * A circular array means the end of the array connects to the beginning of the
 * array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the
 * previous element of nums[i] is nums[(i - 1 + n) % n].
 *
 * A subarray may only include each element of the fixed buffer nums at most
 * once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does
 * not exist i <= k1, k2 <= j with k1 % n == k2 % n.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,-2,3,-2] 
 * Output: 3 
 * Explanation: Subarray [3] has maximum sum 3
 *
 * Example 2:
 *
 * Input: nums = [5,-3,5]
 * Output: 10 
 * 
 * Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10
 *
 * Example 3:
 *
 * Input: nums = [3,-1,2,-1] 
 * Output: 4 
 * Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4
 *
 * Example 4:
 *
 * Input: nums = [3,-2,2,-3] 
 * Output: 3
 * 
 * Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3
 *
 * Example 5:
 *
 * Input: nums = [-2,-3,-1] 
 * Output: -1 
 * 
 * Explanation: Subarray [-1] has maximum sum -1
 *
 * https://leetcode.com/problems/maximum-sum-circular-subarray/
 */

public class MaxSumCircularSubArray {

    /***
     * Using variation of Kadane's maxSum algo 
     * 
     * https://www.youtube.com/watch?v=Q1TYVUEr-wY
     * 
     * @param numbers
     * @return
     */
    static int maxSum(int[] numbers){

        int maxSum = Integer.MIN_VALUE;
        int currentMax = 0;

        int minSum = Integer.MAX_VALUE;
        int currentMin = 0;

        int sumTotal = 0;

        for(int number : numbers){
            //Find max sum
            currentMax = Math.max(0, currentMax) + number;
            maxSum = Math.max(maxSum, currentMax);
            //Find Min sum
            currentMin = Math.min(0, currentMin) + number;
            minSum = Math.min(minSum, currentMin);
            //Find total sum
            sumTotal += number;
        }
        if(sumTotal == minSum){
            return maxSum;
        }

        return Math.max(maxSum, (sumTotal-minSum));

    }

    public static void main(String[] args) {
        int[] array = {-2,-3,-1};
        System.out.println(maxSum(array));
    }

}
