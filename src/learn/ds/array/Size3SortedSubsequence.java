package learn.ds.array;

import learn.util.ArrayUtil;

/**
 * Given an array of n integers, find the 3 elements such that a[i] < a[j] < a[k] and i < j < k in 0(n) time.
 * If there are multiple such triplets, then print any one of them.
 *
 * Examples:
 * Input:  arr[] = {12, 11, 10, 5, 6, 2, 30}
 * Output: 5, 6, 30
 *
 * Input:  arr[] = {1, 2, 3, 4}
 * Output: 1, 2, 3 OR 1, 2, 4 OR 2, 3, 4
 *
 * Input:  arr[] = {4, 3, 2, 1}
 * Output: No such triplet
 *
 * https://www.geeksforgeeks.org/find-a-sorted-subsequence-of-size-3-in-linear-time/
 */
public class Size3SortedSubsequence {

    /**
     * Algorithm
     *  1) Create an auxiliary array smaller[n]. smaller[i] should store the index of a number which is smaller than arr[i] and is on left side of arr[i]. smaller[i] should contain -1 if there is no such element.
     *  2) Create another auxiliary array greater[0..n-1]. greater[i] should store the index of a number which is greater than arr[i] and is on right side of arr[i]. greater[i] should contain -1 if there is no such element.
     *  3) Finally traverse both smaller[] and greater[] and find the index i for which both smaller[i] and greater[i] are not -1.
     *
     * Time Complexity  : O(n)
     * Space Complexity : O(1)
     */
    public static void findSubSequence(int[] array){
        if(array.length == 0){
            System.out.println("Sub-Sequence not found");
            return;
        }
        int n = array.length;

        int min = 0;
        int max = n -1;

        int[] small = new int[n];
        int[] large = new int[n];

        // Create an array that will store index of a smaller element on left side.
        // If there is no smaller element on left side, then smaller[i] will be -1.
        small[0] = -1;
        for(int i = 1 ; i < n ; i++){
            if (array[min] >= array[i] ){
                small[i] = -1;
                min = i;
            }else {
                small[i] = min;
            }
        }

        // Create another array that will store index of a greater element on right side.
        // If there is no greater element on right side, then greater[i] will be -1.
        large[n-1] = -1;
        for(int i = n-2; i >=0; i--){
            if(array[max] <= array[i]){
                max = i;
                large[i] = -1;
            }else {
                large[i] = max;
            }
        }

        // Now find a number which has both a greater number on right side and smaller number on left side
        for(int i =0 ; i< n ; i++){
            if(small[i]!=-1 && large[i] != -1){
                System.out.println(array[small[i]] + " " + array[i] + " " + array[large[i]]);
                return;
            }
        }

        System.out.println("Sub-Sequence not found");
    }

    public static void main(String[] args) {
        int array[] = ArrayUtil.generateRandomArray(5,99);
        ArrayUtil.display(array);

        findSubSequence(array);
    }
}
