package learn.ds.array;

/**
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence
 * such that all elements of the subsequence are sorted in increasing order.
 *
 * Example:
 * the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 *
 * https://www.geeksforgeeks.org/?p=12832
 */

public class LongestIncreasingSubsequence {

    public static int lis(int[] array){
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        System.out.println(lis(array));
    }
}
