package learn.ds.array;

import learn.util.ArrayUtil;

/**
 * @author Varma Penmetsa
 *
 * iven an array of positive and negative numbers, arrange them such that all negative integers
 * appear before all the positive integers in the array without using any additional data structure like hash table,
 * arrays, etc. The order of appearance should be maintained.
 *
 * https://www.geeksforgeeks.org/rearrange-positive-and-negative-numbers/
 */
public class Rearrange {

    public static void arrage(int[] array){
        if(array.length == 0){
            return;
        }
        int low = 0;
        int high = array.length -1;

        while(low <= high){

            if(array[low] < 0){
                low++;
            }else if(array[high] >= 0){
                high--;
            }else {
                ArrayUtil.swap(array,low++,high--);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 11, -13, -5, 6, -7, 5, -3, -6};
        arrage(array);
        ArrayUtil.display(array);
    }
}
