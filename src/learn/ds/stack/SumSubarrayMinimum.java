package learn.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
    Given an array of integers arr, find the sum of min(b), where b ranges over every (contiguous) subarray of arr. 
    Since the answer may be large, return the answer modulo 1e7 + 7.

    Example 1:

    Input: arr = [3,1,2,4]
    Output: 17
    Explanation: 
    Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
    Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.
    Sum is 17.
    
    Example 2:
    Input: arr = [11,81,94,43,3]
    Output: 444
    
    Constraints:
    1 <= arr.length <= 3 * 104
    1 <= arr[i] <= 3 * 104

    https://leetcode.com/problems/sum-of-subarray-minimums/
 */
public class SumSubarrayMinimum {

    /**
     * Monotonic Stacks
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param nums
     * @return
     */
    public int sumSubarrayMins(int[] nums) {
        long res = 0, mod = (int)1e9 + 7;
        
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        Deque<int[]> s1 = new ArrayDeque();
        Deque<int[]> s2 = new ArrayDeque();
        
        //Previous Large Element
        for (int i = 0; i < n; i++) {
            int count = 1;
            while (!s1.isEmpty() && s1.peek()[0] > nums[i]) // Monotonically Decreasing Stack
                count += s1.pop()[1];
            s1.push(new int[] {nums[i], count});
            left[i] = count;
        }
        
        //Next Large Element
        for (int i = n - 1; i >= 0; i--) {
            int count = 1;
            while (!s2.isEmpty() && s2.peek()[0] >= nums[i]) // Monotonically Decreasing Stack
                count += s2.pop()[1];
            s2.push(new int[] {nums[i], count});
            right[i] = count;
        }
        
        for (int i = 0; i < n; ++i){
            res = (res + (long)nums[i] * left[i] * right[i]) % mod;
        }
        
        return (int)res;
    }
    
}
