package learn.ds.array;

import java.util.HashMap;
import java.util.Map;

/*
Given an integer array nums and an integer k, return true if it is possible to divide this array into k non-empty subsets whose sums are all equal.

Example 1:

Input: nums = [4,3,2,3,5,2,1], k = 4
Output: true
Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
Example 2:

Input: nums = [1,2,3,4], k = 3
Output: false
 

Constraints:

1 <= k <= nums.length <= 16
1 <= nums[i] <= 104
The frequency of each element is in the range [1, 4].

https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
https://www.youtube.com/watch?v=qpgqhp_9d1s
https://github.com/dvpenmetsa/backtobackswe/blob/master/Dynamic%20Programming%2C%20Recursion%2C%20%26%20Backtracking/PartitionIntoKEqualSumSubsets/PartitionIntoKEqualSumSubsets.java

*/
public class PartitionKEqualSumSubsets {


    /**
     * Backtacking
     * 
     * @param nums
     * @param visited
     * @param k
     * @param start
     * @param sum
     * @param target
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int sum = 0;
        for(int num : nums){
            sum += num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        if(sum % k != 0){
            return false;
        }
        
        int target = sum / k;
        boolean[] visited = new boolean[nums.length];
        return dfs(nums, visited, k, 0, 0, target);
    }
    
    public boolean dfs(int[] nums, boolean[] visited, int k , int start, int sum, int target){
        if(k == 1){
            return true;
        }
        
        if(sum == target){
            return dfs(nums, visited, k-1, 0, 0, target);
        }
        
        for(int i = start ; i < nums.length ; i++){
            if(!visited[i]){
                visited[i] = true;
                if(dfs(nums, visited, k, i+1, sum + nums[i], target)){
                    return true;
                }
                visited[i] = false;
            }
            
        }
        return false;
    }
}