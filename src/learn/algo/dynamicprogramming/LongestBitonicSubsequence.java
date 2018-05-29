package learn.algo.dynamicprogramming;

/**
 * @author Varma Penmetsa
 *
 * Find length of logest bitonic subsequence
 *
 * Examples:
 *
 * Input arr[] = {1, 11, 2, 10, 4, 5, 2, 1};
 * Output: 6 (A Longest Bitonic Subsequence of length 6 is 1, 2, 10, 4, 2, 1)
 *
 * Input arr[] = {12, 11, 40, 5, 3, 1}
 * Output: 5 (A Longest Bitonic Subsequence of length 5 is 12, 11, 5, 3, 1)
 *
 * Input arr[] = {80, 60, 30, 40, 20, 10}
 * Output: 5 (A Longest Bitonic Subsequence of length 5 is 80, 60, 30, 20, 10)
 *
 * https://www.geeksforgeeks.org/dynamic-programming-set-15-longest-bitonic-subsequence/
 */
public class LongestBitonicSubsequence {

    public static int lbs(int[] array) {
        int[] lis = new int[array.length];
        int[] lds = new int[array.length];
        int n = array.length - 1;

        for (int i = 0; i <= n; i++) {
            lis[i] = 1;
            lds[i] = 1;
        }

        //LIS
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (array[j] < array[i]) {
                    lis[i] = Integer.max(lis[i], lis[j] + 1);
                }
            }
        }

        //LDS
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n; j > i; j--) {
                if (array[j] < array[i]) {
                    lds[i] = Integer.max(lds[i], lds[j] + 1);
                }
            }
        }

        // max = lis[i] + lds[i] - 1
        int max = 0;
        for (int i = 0; i <= n; i++) {
            max = Integer.max(max, lis[i] + lds[i] - 1);
        }

        return max;
    }

    public static void main(String[] args) {
        int array[] = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        System.out.println(lbs(array));
    }
}
