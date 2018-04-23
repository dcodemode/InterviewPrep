package learn.ds.array;

import learn.util.ArrayUtil;

/**
 * @author Varma Penmetsa
 *
 * Given an array of positive and negative numbers, arrange them such that all negative integers
 * appear before all the positive integers in the array without using any additional data structure like hash table,
 * arrays, etc. The order of appearance should be maintained.
 *
 * https://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers/
 */
public class Rearrange {

    //Optimize Merge sort
    public static void arrange(int[] array) {
        arrange(array, 0, array.length - 1);
    }

    public static void arrange(int[] array, int left, int right){
        if(left >= right){
            return;
        }
        int mid  = left + (right - left ) /2;
        arrange(array,left, mid);
        arrange(array,mid+1, right);
        mergeHalfs(array, mid, left, right);
    }

    public static void mergeHalfs(int[] array, int mid, int left, int right){
        int leftStart = left;
        int rightStart =  mid + 1;

        int lSize = mid + 1 - left;
        int rSize = right - mid;

        int L[] = new int[lSize];
        int R[] = new int[rSize];
        int i , j ,k;

        for (i = 0; i < lSize; i++) {
            L[i] = array[leftStart + i];
        }
        for(j = 0 ; j < rSize; j++){
            R[j] = array[rightStart + j];
        }

        i = 0; j = 0; k = leftStart;

        while(i < lSize && L[i] < 0){
            array[k++] = L[i++];
        }

        while(j < rSize && R[j] < 0){
            array[k++] = R[j++];
        }

        while(i < lSize){
            array[k++] = L[i++];
        }

        while (j < rSize){
            array[k++] = R[j++];
        }

    }

    public static void main(String[] args) {
        int[] array = {12, 11, -13, -5, 6, -7, 5, -3, -6};
        arrange(array);
        ArrayUtil.display(array);
    }
}
