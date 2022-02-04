package learn.ds.array;

/**
    You are given an integer array arr.
    We split arr into some number of chunks (i.e., partitions), and individually sort each chunk.
    After concatenating them, the result should equal the sorted array.

    Return the largest number of chunks we can make to sort the array.

    Example 1:

    Input: arr = [5,4,3,2,1]
    Output: 1
    Explanation:
    Splitting into two or more chunks will not return the required result.
    For example, splitting into [5, 4], [3, 2, 1] will result in [4, 5, 1, 2, 3], which isn't sorted.
   
    Example 2:

    Input: arr = [2,1,3,4,4]
    Output: 4
    Explanation:
    We can split into two chunks, such as [2, 1], [3, 4, 4].
    However, splitting into [2, 1], [3], [4], [4] is the highest number of chunks possible.
    
    Constraints:
    1 <= arr.length <= 2000
    0 <= arr[i] <= 108

    https://leetcode.com/problems/max-chunks-to-make-sorted/
    https://leetcode.com/problems/max-chunks-to-make-sorted-ii/
 */
public class MaxChunksToMakeSorted {

    /**
     * 
     * Algorithm: 
     * Iterate through the array, each time all elements to the left are smaller (or equal) to all elements to the right, there is a new chunck.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param arr
     * @return
     */
    public int maxChunksToSorted(int[] arr) {
        if(arr == null || arr.length == 0){
            return 0;
        }
        
        int[] leftMax = new int[arr.length];
        int[] rightMin = new int[arr.length];
        
        leftMax[0] = arr[0];
        for(int i = 1 ; i < arr.length ; i++){
            leftMax[i] = Math.max(arr[i] , leftMax[i - 1]);
        }
        
        rightMin[arr.length - 1] = arr[arr.length - 1];
        for(int i = arr.length - 2 ; i >= 0 ; i--){
            rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
        }
        
        int ans = 1;
        for(int i = 0 ; i < arr.length - 1 ; i++){
            if(leftMax[i] <= rightMin[i+1] ){
                ans++;
            }
        }
        return ans;
    }
    
}
