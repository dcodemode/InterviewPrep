package learn.algo.sort;

import learn.ds.util.ArrayUtil;

/**
 * @author Varma Penmetsa
 * https://www.youtube.com/watch?v=6Gv8vg0kcHc
 */
public class BubbleSort {

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(1)
     */
    public static void sort(int[] array) {
        boolean isSorted = false;
        int lastUnsorted = array.length - 1;
        while(!isSorted){
            isSorted = true;
            for(int i = 0 ; i < lastUnsorted; i++){
                if(array[i+1] < array[i]){
                    int temp = array[i+1];
                    array[i+1] = array[i];
                    array[i] = temp;
                    isSorted= false;
                }
            }
            lastUnsorted--;
        }
    }

    /**
     * Recursive Binary Search
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */
    public static void sort(int[] array, int n){
        if(n == 1){
            return;
        }

        for(int i =0 ;i < n -1 ; i++){
            if (array[i+1] < array[i]){
                int temp = array[i+1];
                array[i+1] = array[i];
                array[i] = temp;
            }
        }

        sort(array,--n);
    }


    public static void main(String[] args) {
        int[] array = {3, 2, 8, 5, 9, 4, 1, 6};
        sort(array, array.length);
        ArrayUtil.display(array);
    }
}
