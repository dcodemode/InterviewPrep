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
        sortedHalves(array,left,right);
    }

    public static void sortedHalves(int[] array, int left, int right){
        int mid = (left + right) / 2;
        int[] temp = new int[right - left + 1];

        // i is start of left, j is start of right and r is start of temp
        int i = left;
        int j = mid + 1;
        int r = 0;

        while(i <= mid && j <= right){
            if(array[i] < array[j]){
                temp[r++] = array[i++];
            }else {
                temp[r++] = array[j++];
            }
        }

        while(i <= mid){
            temp[r++] = array[i++];
        }

        while (j <= right){
            temp[r++] = array[j++];
        }

        //Copying it back to array
        i = left;
        for (int k = 0; k < temp.length; ) {
            array[i++] = temp[k++];
        }
    }

    public static void main(String[] args) {
        int[] array = ArrayUtil.generateRandomArray(9);
        sort(array);
        ArrayUtil.display(array);
    }
}
