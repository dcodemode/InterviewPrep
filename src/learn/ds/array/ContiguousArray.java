package learn.ds.array;

import java.util.HashMap;

/**
    Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.
 
    Example 1:
    Input: nums = [0,1]
    Output: 2
    Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.

    Example 2:
    Input: nums = [0,1,0]
    Output: 2
    Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
    
    Constraints:
    1 <= nums.length <= 105
    nums[i] is either 0 or 1.

    https://leetcode.com/problems/contiguous-array/
 */
public class ContiguousArray {
    /**
     * Using Prefix Sum and HashMap
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int count = 0, max = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0){
                count += -1;
            }else{
                count += 1;
            }
            
            if(count == 0){
                max = Math.max(max, i+1);
            }
            
            if(map.containsKey(count)){
                max = Math.max(max, i - map.get(count));
            }else{
                map.put(count, i);
            } 
        }
        return max;
    }
}
