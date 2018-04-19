package learn.ds.array;

import learn.util.ArrayUtil;

/**
 * @author Varma Penmetsa
 *
 * An array contains both positive and negative numbers in random order.
 * Rearrange the array elements so that positive and negative numbers are placed alternatively.
 * Number of positive and negative numbers need not be equal. If there are more positive numbers they appear at the end of the array.
 * If there are more negative numbers, they too appear in the end of the array.
 *
 * For example, if the input array is [-1, 2, -3, 4, 5, 6, -7, 8, 9],
 * then the output should be [9, -7, 8, -3, 5, -1, 2, 4, 6]
 *
 * https://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers-publish/
 */
public class RearrangePositiveNegativeNumbes {

    /**
     *
     *  The solution is to first separate positive and negative numbers using partition process of QuickSort.
     *  Once negative and positive numbers are separated, we start from the first negative number and first positive number,
     *  and swap every alternate negative number with next positive number.
     *
     * Time Complexity: O (log n)
     * Space Complexity: O (1)
     */
    public static void rearrange(int[] array){

        int p = partition(array) + 1;

        for (int i = 0 ; i < array.length-2 ;i+=i+2){
            ArrayUtil.swap(array,i,p++);
        }
    }

    /**
     * Time Complexity: O(n log n)
     * Space Complexity: O(1)
     */
    public static int partition(int[] array){
        int left = 0;
        int right = array.length-1;
        int pivot = left;

        int i = left+1;
        int j = right;

        while (i <= j){
            if(array[i] <= array[pivot]){
                i++;
                continue;
            }

            if(array[pivot] <= array[j]){
                j--;
                continue;
            }

            ArrayUtil.swap(array,i,j);
        }

        if(array[pivot] > array[j]){
            ArrayUtil.swap(array,pivot,j);
            return j;
        }

        return pivot;
    }

    public static void main(String[] args) {

        int[] array = ArrayUtil.generateRandomArray(5);

        rearrange(array);
        ArrayUtil.display(array);
    }


}
