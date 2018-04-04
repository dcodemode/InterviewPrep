package learn.ds.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array A[] of n numbers and another number x, determines whether or not there exist two elements in S whose sum is exactly x.
 * https://www.geeksforgeeks.org/write-a-c-program-that-given-a-set-a-of-n-numbers-and-another-number-x-determines-whether-or-not-there-exist-two-elements-in-s-whose-sum-is-exactly-x/
 */
public class Sum1 {

    /**
     * Using Hashing
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     *
     */
    public static void check(int[] nums, int x){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(x - nums[i])) {
                System.out.println(x - nums[i] + " " + nums[i]);
            }
            set.add(nums[i]);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        check(nums,4);
    }
}
