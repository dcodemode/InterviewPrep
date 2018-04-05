package learn.ds.array;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array A[] of n numbers and another number x.
 * Determines whether or not there exist two elements in S whose sum is exactly x.
 *
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
            int v = x - nums[i];
            if (set.contains(v)) {
                System.out.println("Check 1: " + v + " " + nums[i]);
            }
            set.add(nums[i]);
        }
    }

    /**
     * With out using data structure
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void check2(int[] array, int x){
        int n = array.length;
        int i;

        //Find greatest and smallest elements
        for(i= 0 ; i < n - 1 ;i++){
            if(array[i] > array[i+1]){
                break;
            }
        }
        int min = (i+1) % n;
        int max = i;

        while (min != max){
            int sum = array[min] + array[max];
            if(sum == x){
                System.out.println("Check 2: " +array[max] + " " + array[min]);
                return;
            } else if(sum < x){
                min = (min + 1) % n;
            }else {
                max = (n + max - 1) % n;
            }
        }
    }



    public static void main(String[] args) {
        int[] nums = {11, 15, 6, 8, 9, 10};
        check(nums,16);
        check2(nums,16);
    }
}
