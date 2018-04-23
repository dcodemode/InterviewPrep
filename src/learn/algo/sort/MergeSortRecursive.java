package learn.algo.sort;

import learn.util.ArrayUtil;

/**
 * @author Varma Penmetsa
 * https://www.youtube.com/watch?v=TzeBrDU-JaY
 * https://github.com/mission-peace/interview/blob/68f97392c6f6e14e2c08860684ed605a1a5e7e72/src/com/interview/sort/MergeSort.java
 */
public class MergeSortRecursive {

    /**
     * Time Complexity: O (n log n)
     * Space Complexity: O (n)
     */
    public static void sort(int[] array){
        sort(array, 0, array.length-1);
    }

    public static void sort(int[] array, int left, int right){
        if (left >= right){
            return;
        }

        int mid = (left + right) / 2;
        sort(array, left, mid);
        sort(array,mid+1, right);
        sortedHalves(array,mid,left,right);
    }

    public static void sortedHalves(int[] array, int mid, int left, int right){
        int leftStart =  left;
        int rightStart = mid + 1;

        int lSize = mid - left + 1;
        int rSize = right - mid;

        int[] L = new int[lSize];
        int[] R  = new int[rSize];
        int i,j,k;

        for (i = 0; i < lSize; i++) {
            L[i] = array[leftStart + i];
        }

        for (j = 0; j < rSize; j++) {
            R[j] = array[rightStart + j];
        }

        i = 0;
        j = 0;
        k = leftStart;

        while (i < lSize && j < rSize) {
            if (L[i] < R[j]) {
                array[k++] = L[i++];
            } else {
                array[k++] = R[j++];
            }
        }

        while (i < lSize) {
            array[k++] = L[i++];
        }

        while (j < rSize) {
            array[k++] = R[j++];
        }


    }

    public static void main(String[] args) {
        int[] array = ArrayUtil.generateRandomArray(9,9);
        ArrayUtil.display(array);
        sort(array);
        ArrayUtil.display(array);
    }
}
