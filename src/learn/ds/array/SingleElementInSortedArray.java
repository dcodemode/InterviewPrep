package learn.ds.array;

/**
 * 540. Single Element in a Sorted Array
 *
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
 *
 * Example 1:
 *
 * Input: [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 *
 * Input: [3,3,7,7,10,11,11]
 * Output: 10
 *
 * Note: Your solution should run in O(log n) time and O(1) space.
 *
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 */
public class SingleElementInSortedArray {

    /**
     * Time Complexity : O(log n)
     * Space Complexity: O(1)x
     */
    public int singleNonDuplicate(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(mid % 2 == 0){
                // mid is even
                if(nums[mid] == nums[mid + 1]){
                    left = mid + 2;
                }else{
                    right = mid;
                }
            }else{
                // mid is odd
                if(nums[mid] == nums[mid - 1]){
                    left = mid + 1;
                }else{
                    right = mid;
                }
            }
        }
        return nums[left];
    }
}
