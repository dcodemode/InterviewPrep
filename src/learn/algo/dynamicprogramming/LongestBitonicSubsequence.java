package learn.algo.dynamicprogramming;

/**
 * @author Varma Penmetsa
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
