package learn.ds.array;

import java.util.Arrays;

/**
 * @author Varma Penmetsa
 *
 * Given two sorted arrays, the task is to merge them in a sorted manner.
 *
 * Examples:
 *
 * Input :  arr1[] = { 1, 3, 4, 5}
 *          arr2[] = {2, 4, 6, 8}
 * Output : arr3[] = {1, 2, 3, 4, 5, 6, 7, 8}
 *
 * Input  : arr1[] = { 5, 8, 9}
 *          arr2[] = {4, 7, 8}
 * Output : arr3[] = {4, 5, 7, 8, 8, 9}
 *
 * https://www.geeksforgeeks.org/merge-two-sorted-arrays/
 * https://leetcode.com/problems/merge-sorted-array/description/
 */
public class MergeSortedArrays {

    /**
     * Time Complexity   : O(m+n)
     * Space Complexity  : O(m+n)
     *
     * The idea is to use Merge function of Merge sort.
     *  1. Create an array arr3[] of size n1 + n2.
     *  2. Simultaneously traverse arr1[] and arr2[].
     *  3. Pick smaller of current elements in arr1[] and arr2[],
     *  copy this smaller element to next position in arr3[] and move ahead in arr3[] and the array whose element is picked.
     *  4. If there are are remaining elements in arr1[] or arr2[], copy them also in arr3[].
     *
     */
    public static int[] merge(int[] arrayA, int[] arrayB){

        if(arrayA.length == 0){
            return arrayB;
        }else if(arrayB.length == 0){
            return arrayA;
        }

        if(arrayA.length==0 && arrayB.length ==0){
            return arrayA;
        }

        int[] output = new int[arrayA.length + arrayB.length];
        int i = 0, indexA =0, indexB = 0;

        while(indexA < arrayA.length && indexB < arrayB.length){
            if(arrayA[indexA] < arrayB[indexB]){
                output[i] = arrayA[indexA++];
            }else {
                output[i] = arrayB[indexB++];
            }
            i++;
        }

        while (indexA < arrayA.length){
            output[i++] = arrayA[indexA++];
        }

        while (indexB < arrayB.length){
            output[i++] = arrayB[indexB++];
        }

        return output;
    }

    public static void main(String[] args) {
        int a[] = {1,2,3,6,89,102};
        int b[] = {9,15,80,120};

        System.out.printf(Arrays.toString(merge(a,b)));

    }
}
