package learn.ds.array;

import learn.util.ArrayUtil;

/**
 * Given an array of n elements. Consider array as circular array i.e element after an is a1.
 * The task is to find maximum sum of the difference between consecutive elements with * rearrangement
 * of array element allowed * i.e after rearrangement of element find
 * |a1 – a2| + |a2 – a3| + …… + |an – 1 – an| + |an – a1|.
 *
 * https://www.geeksforgeeks.org/maximize-sum-consecutive-differences-circular-array/
 */
public class MaxSum {

    public static void waveSort(int[] array) {
        for (int i = 0; i < array.length; i += 2) {
            if (i > 0 && array[i - 1] > array[i]) {
                ArrayUtil.swap(array, i - 1, i);
            }
            if (i < array.length - 1 && array[i + 1] > array[i]) {
                ArrayUtil.swap(array, i + 1, i);
            }
        }
    }

    /**
     * Time:  O(n)
     * Space: O(1)
     */
    public static int sum(int[] array){
        waveSort(array);
        int s = 0;
        for(int i = 0; i< array.length; i++){
            if(i != array.length -1 ){
                s += Math.abs(array[i] - array[i+1]);
            }else {
                s += Math.abs(array[i] - array[0]);
            }
        }
        return s;
    }

    public static void main(String[] args) {
        int[] array = { 4, 2};
        System.out.println(sum(array));
    }

}
