package learn.ds.array;

import learn.util.ArrayUtil;

/**
 * Given a sorted array of positive integers, rearrange the array alternately i.e first element should be
 * maximum value, second minimum value, third second max, fourth second min and so on.
 *
 * Examples:
 * Input  : arr[] = {1, 2, 3, 4, 5, 6, 7}
 * Output : arr[] = {7, 1, 6, 2, 5, 3, 4}
 *
 * Input  : arr[] = {1, 2, 3, 4, 5, 6}
 * Output : arr[] = {6, 1, 5, 2, 4, 3}
 *
 * https://www.geeksforgeeks.org/rearrange-array-maximum-minimum-form/
 */
public class RearangeMaxMin {

    /**
     * Time  : O(n)
     * Space : O(n)
     */
    public static int[] reaarange(int[] array){
        int start = 0;
        int end = array.length - 1;

        int[] temp = new int[array.length];

        int i = 0;
        while(start <= end){
           if(i%2!=0){
               temp[i++] = array[start++];
           }else {
               temp[i++] = array[end--];
           }
        }
        return temp;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] temp = reaarange(array);
        ArrayUtil.display(temp);
    }

}
