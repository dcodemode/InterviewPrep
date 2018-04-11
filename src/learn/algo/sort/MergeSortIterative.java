package learn.algo.sort;

import learn.util.ArrayUtil;

/**
 * @author Varma Penmetsa
 *
 * Implement MergeSort iteratively using bottoms-up apparoach
 * http://www.techiedelight.com/iterative-merge-sort-algorithm-bottom-up/
 * https://www.coursera.org/learn/algorithms-part1/lecture/PWNEl/bottom-up-mergesort
 */
public class MergeSortIterative {

    public static void sort(int[] array) {

        int left = 0;
        int right = array.length - 1;

        for (int m = 1; m < right - left; m = 2 * m) {
            for (int i = left; i < right; i += 2 * m) {
                int from = i;
                int to = Integer.min(i + 2 * m - 1, right);
                sortedHalves(array, from, to);
            }
        }
    }

    public static void sortedHalves(int[] array, int left, int right) {
        int mid = (left + right) / 2;

        int[] temp = new int[right - left + 1];
        // i is start of left, j is start of right and r is start of temp
        int i = left;
        int j = mid + 1;
        int r = 0;

        while (i <= mid && j <= right) {
            if (array[i] < array[j]) {
                temp[r++] = array[i++];
            } else {
                temp[r++] = array[j++];
            }
        }

        while (i <= mid) {
            temp[r++] = array[i++];
        }

        while (j <= right) {
            temp[r++] = array[j++];
        }

        //Copying it back to array
        i = left;
        for (int k = 0; k < temp.length; ) {
            array[i++] = temp[k++];
        }
    }

    public static void main(String[] args) {
        int[] array = ArrayUtil.generateRandomArray(7, 99);
        sort(array);
        ArrayUtil.display(array);
    }
}
