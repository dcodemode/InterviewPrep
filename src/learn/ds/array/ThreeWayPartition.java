package learn.ds.array;

import learn.util.ArrayUtil;

/**
 *
 * Given an array and a range [lowVal, highVal], partition the array around the range such that array is divided in three parts.
 *  1) All elements smaller than lowVal come first.
 *  2) All elements in range lowVal to highVVal come next.
 *  3) All elements greater than highVVal appear in the end.
 * The individual elements of three sets can appear in any order.
 *
 * Examples:
 *  Input: arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32}
 *  lowVal = 14, highVal = 20
 *  Output: arr[] = {1, 5, 4, 2, 1, 3, 14, 20, 20, 98, 87, 32, 54}
 *
 *  Input: arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32}
 *  lowVal = 20, highVal = 20
 *  Output: arr[] = {1, 14, 5, 4, 2, 1, 3, 20, 20, 98, 87, 32, 54}
 *
 * https://www.geeksforgeeks.org/three-way-partitioning-of-an-array-around-a-given-range/
 */
public class ThreeWayPartition {

    public static void partition(int[] array, int lowVal , int highVal){

        int  n = array.length;
        int start = 0, end = n-1;

        int i = 0;
        //Traversing from left to right
        while(i <= end){
            if(array[i] < lowVal){
                ArrayUtil.swap(array,i++,start++);
            }else if(array[i] > highVal){
                //No incrementing i as, we are swapping element with right side
                ArrayUtil.swap(array,i,end--);
            }else {
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};
        partition(array,14,20);
        ArrayUtil.display(array);
    }

}
