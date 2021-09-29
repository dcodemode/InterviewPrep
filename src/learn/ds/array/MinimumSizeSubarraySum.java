package learn.ds.array;

/*
Given an array of positive integers nums and a positive integer target, return the minimal length of a contiguous subarray [numsl, numsl+1, ..., numsr-1, numsr] of which the sum is greater than or equal to target. If there is no such subarray, return 0 instead.

Example 1:

Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
Example 2:

Input: target = 4, nums = [1,4,4]
Output: 1
Example 3:

Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0

https://leetcode.com/problems/minimum-size-subarray-sum/
 */
public class MinimumSizeSubarraySum {

     /**
     * Sliding window approach
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param nums
     * @param k
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        
        int left = 0;
        int right = 0;
        int prefixSum = 0;
        
        while(right < nums.length){
            prefixSum += nums[right];
            
            
            while(prefixSum >= target){
                minLen = Math.min(minLen, right - left + 1);
                prefixSum -= nums[left++];
            }
            
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
    
}
