package learn.algo.divideconquer;

/**
 * @author Varma Penmetsa
 *
 *
 * You are given a one dimensional array that may contain both positive and negative integers,
 * find the sum of contiguous subarray of numbers which has the largest sum.
 *
 * Example,
 *    if the given array is {-2, -5, 6, -2, -3, 1, 5, -6}, then the maximum subarray sum is 7
 *
 * https://www.geeksforgeeks.org/divide-and-conquer-maximum-sum-subarray/
 */
public class MaxSubarraySum {

    /**
     * Divide and Conquer technique
     *
     * Time : O(n log n)
     */
    public static int maxSum(int[] array, int left, int right){
        if(left >= right){
            return -1;
        }
        int mid  = left + (right - left) /2;
        maxSum(array, left , mid );
        maxSum(array, mid + 1 , right);
        return sumItUp(array,left,right);
    }

    public static int sumItUp(int[] array, int left, int right){
        int max = 0;
        int sum = 0;

        for(int i = left ; i < right; i++){
            sum += array[i];
            if (sum < 0){
                sum = 0;
            }

            if (sum > max){
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] array =  {4,-1,2,1};
        System.out.println(maxSum(array, 0 , array.length));
    }
}
