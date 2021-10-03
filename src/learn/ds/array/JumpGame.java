package learn.ds.array;
/*
Jump Game
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.

Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 

Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105

https://leetcode.com/problems/jump-game/solution/
 */

import java.util.Arrays;

enum Index{
     GOOD, BAD, UNKNOWN
 }

public class JumpGame {

    Index[] memo;

    /**
     * Dynamic Programming Top Down Approach
     * 
     * 1. Initially, all elements of the memo table are UNKNOWN, except for the last one, which is (trivially) GOOD (it can reach itself)
     * 2. Modify the backtracking algorithm such that the recursive step first checks if the index is known (GOOD / BAD)
     *      1.If it is known then return True / False
     *      2. Otherwise perform the backtracking steps as before
     * 3.Once we determine the value of the current index, we store it in the memo table
     * 
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        memo = new Index[nums.length];
        Arrays.fill(memo, Index.UNKNOWN);
        memo[memo.length - 1] = Index.GOOD;
        return canJumpFromPosition(0, nums);
    }

    public boolean canJumpFromPosition(int position, int[] nums) {
        if (memo[position] != Index.UNKNOWN) {
            return memo[position] == Index.GOOD ? true : false;
        }

        int furthestJump = Math.max(position + nums[position], position);
        
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                memo[position] = Index.GOOD;
                return true;
            }
        }

        memo[position] = Index.BAD;
        return false;
    }
}
