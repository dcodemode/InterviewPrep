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

        small[0] = -1;
        for(int i = 1 ; i < n ; i++){
            if (array[min] >= array[i] ){
                small[i] = -1;
                min = i;
            }else {
                small[i] = min;
            }
        }

        large[n-1] = -1;
        for(int i = n-2; i >=0; i--){
            if(array[max] <= array[i]){
                max = i;
                large[i] = -1;
            }else {
                large[i] = max;
            }
        }

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
