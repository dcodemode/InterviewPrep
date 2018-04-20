package learn.ds.array;

import learn.util.ArrayUtil;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Varma Penmetsa
 *
 * Given an unsorted array of integers, sort the array into a wave like array
 *
 * https://www.geeksforgeeks.org/sort-array-wave-form-2/
 */
public class SortArrayInWaveForm {

    public static void sort(int[] array){
        sort(array,0, array.length-1);
    }

    public static void sort(int[] array, int low, int high){
        Deque<Integer> st = new ArrayDeque<>();
        st.push(low);
        st.push(high);

        while(!st.isEmpty()){
            high = st.pop();
            low =  st.pop();

            int p = partition(array,low,high);
            if(low < p - 1 && high > p + 1){
                st.push(low);
                st.push(p-1);
                st.push(p+1);
                st.push(high);
            }else if(low < p - 1){
                st.push(low);
                st.push(p-1);
            }else if ( high > p + 1){
                st.push(p+1);
                st.push(high);
            }
        }
    }

    public static int partition(int[] array, int low, int high){
        int pivot = low;
        int i = low + 1;
        int j = high;

        while(i <= j ){
            if(array[i] < array[pivot]){
                i++;
            }else if(array[j] > array[pivot]){
                j--;
            }else {
                ArrayUtil.swap(array,i++,j--);
            }
        }

        if(array[pivot] >= array[j]){
            ArrayUtil.swap(array,pivot,j);
            return j;
        }
        return pivot;
    }

    /**
     * Naive Approach
     * 1. Sort Array
     * 2. Swap Adjacent elements
     *
     * Time  : O (n log n)
     * Space : O (1)
     */
    public static void waveSort(int[] array){
        //Quick Sort
        sort(array);
        //Swap Alternate numbers
        for(int i =0 ; i < array.length-1 ; i+=2){
            ArrayUtil.swap(array,i,i+1);
        }
    }

    /**
     * Traverse all even positioned elements of input array, and do following.
     *       a) If current element is smaller than previous odd element, swap previous and current.
     *       b) If current element is smaller than next odd element, swap next and current.
     *
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     */
    public static void wavesort1(int[] array){
        for(int i = 0 ; i < array.length; i+=2){
            if( i > 0 && array[i-1] > array[i] ){
                ArrayUtil.swap(array,i-1,i);
            }
            if(i < array.length-1 && array[i+1] > array[i]){
                ArrayUtil.swap(array,i+1,i);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6,7};
        wavesort1(array);
        ArrayUtil.display(array);
    }

}
