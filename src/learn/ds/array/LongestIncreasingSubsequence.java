package learn.ds.array;

/**
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest subsequence of a given sequence
 * such that all elements of the subsequence are sorted in increasing order.
 *
 * Example:
 * the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80} is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 *
 * https://www.geeksforgeeks.org/?p=12832
 * https://www.youtube.com/watch?v=CE2b_-XfVDk
 */

public class LongestIncreasingSubsequence {

    /**
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     */
    public static int lis(int[] array) {
        int[] temp = new int[array.length];

        //Set value of all elements in temp to 1 as LIS is 1 for any array
        for (int i = 0; i < array.length; i++) {
            temp[i] = 1;
        }

        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    temp[i] = Integer.max(temp[i], temp[j] + 1);
                }
            }
        }

        int max = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > max) {
                max = temp[i];
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[] array = {10,9,2,5,3,7,101,18};
        System.out.println(lis(array));
    }
}
