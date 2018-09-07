package learn.ds.array;

import learn.util.ArrayUtil;

/**
 * @author Varma Penmetsa
 * Given an unsorted array of both negative and positive integer. The task is place all negative element at the end of array without changing the order of positive element and negative element.
 *
 * Examples:
 *
 * Input : arr[] = {1, -1, 3, 2, -7, -5, 11, 6 }
 * Output : 1  3  2  11  6  -1  -7  -5
 *
 * Input : arr[] = {-5, 7, -3, -4, 9, 10, -1, 11}
 * Output : 7  9  10  11  -5  -3  -4  -1
 * https://www.geeksforgeeks.org/move-ve-elements-end-order-extra-space-allowed/
 */
public class MoveNegativeElements {
    /**
     * Using modified Merge Sort
     * Time : O(n log n)
     * Space: O(n)
     */
    public static void moveNeg(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = left + (right - left) / 2;
        moveNeg(array, left, mid);
        moveNeg(array, mid + 1, right);
        merge(array, mid, left, right);
    }

    public static void merge(int[] array, int mid, int left, int right) {

        int leftStart = left;
        int rightStart = mid + 1;

        int lSize = mid + 1 - left;
        int rSize = right - mid;

        int L[] = new int[lSize];
        int R[] = new int[rSize];

        int i, j, k;

        for (i = 0; i < lSize; i++) {
            L[i] = array[leftStart + i];
        }
        for (j = 0; j < rSize; j++) {
            R[j] = array[rightStart + j];
        }

        i = 0;
        j = 0;
        k = leftStart;

        while (i < lSize && L[i] >= 0) {
            array[k++] = L[i++];
        }

        while (j < rSize && R[j] >= 0) {
            array[k++] = R[j++];
        }

        while (i < lSize) {
            array[k++] = L[i++];
        }

        while (j < rSize) {
            array[k++] = R[j++];
        }
    }

    /**
     * Using Extra Space
     * Time  : O(n)
     * Space : O(n)
     */
    public static void segregateElements(int[] array) {
        int n = array.length;
        int[] temp = new int[n];
        int k = 0;

        //Add +ve num's to temp
        for (int i = 0; i < n; i++) {
            if (array[i] >= 0) {
                temp[k++] = array[i];
            }
        }

        if( k == 0 || k == n){
            return;
        }

        //Add -ve num's to temp
        for (int i = 0; i < n; i++) {
            if (array[i] < 0) {
                temp[k++] = array[i];
            }
        }
        //Copy temp back to array
        for (int i = 0; i < n; i++) {
            array[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] array = { 1, -1, -3, -2, 7, 5, 11, 6 };
        segregateElements(array);
        ArrayUtil.display(array);
    }
}
