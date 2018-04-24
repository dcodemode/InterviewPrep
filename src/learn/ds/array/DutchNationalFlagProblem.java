package learn.ds.array;

import learn.util.ArrayUtil;

/**
 * Given an array with n objects colored red, white or blue, sort them in-place so that
 * objects of the same color are adjacent, with the colors in the order red, white and blue.
 *
 * Note: You are not suppose to use the library's sort function for this problem.
 *
 * Example:
 *  Input: [2,0,2,1,1,0]
 *  Output: [0,0,1,1,2,2]
 *
 * https://en.wikipedia.org/wiki/Dutch_national_flag_problem
 * https://leetcode.com/problems/sort-colors/description/
 */
public class DutchNationalFlagProblem {

    public static void sortColors(int[] array){
        int n = array.length, start = 0, end = n - 1;

        int i = 0;

        while(i <= end){
            if(array[i] == 0){
                int temp = array[i];
                array[i] = array[start];
                array[start] = temp;
                i++;
                start++;
            }else if(array[i] == 2){
                int temp = array[i];
                array[i] = array[end];
                array[end] = temp;
                end--;
            }else{
                i++;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {2,0,1};
        sortColors(array);
        ArrayUtil.display(array);
    }
}
