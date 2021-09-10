package learn.ds.matrix;

import java.util.Arrays;

/**
 *
 * 764. Largest Plus Sign
 *
 * You are given an integer n. You have an n x n binary grid grid with all values initially 1's except for some indices given in the array mines. The ith element of the array mines is defined as mines[i] = [xi, yi] where grid[xi][yi] == 0.
 *
 * Return the order of the largest axis-aligned plus sign of 1's contained in grid. If there is none, return 0.
 *
 * An axis-aligned plus sign of 1's of order k has some center grid[r][c] == 1 along with four arms of length k - 1 going up, down, left, and right, and made of 1's. Note that there could be 0's or 1's beyond the arms of the plus sign, only the relevant area of the plus sign is checked for 1's.
 *
 * Example 1:
 *
 * Input: n = 5, mines = [[4,2]]
 * Output: 2
 *
 * Explanation: In the above grid, the largest plus sign can only be of order 2. One of them is shown.
 *
 * Example 2:
 *
 * Input: n = 1, mines = [[0,0]]
 * Output: 0
 * Explanation: There is no plus sign, so return 0.
 *
 * https://leetcode.com/problems/largest-plus-sign/
 */

public class LargestPlusSign {

    /**
     * Time Complexity: O(n^2)
     * Space Complexity : O(n^2)
     * @param n
     * @param mines
     * @return
     */
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] grid = new int[n][n];

        // Filling up grid with 1
        for (int[] arr : grid) {
            Arrays.fill(arr, 1);
        }

        // Setting mine's
        for (int[] mine : mines) {
            grid[mine[0]][mine[1]] = 0;
        }


        for (int row = 0; row < n; row++) {
            // Left
            int count = 0;
            for (int col = 0; col < n; col++) {
                if (grid[row][col] != 0) {
                    count++;
                } else {
                    count = 0;
                }
                grid[row][col] = count;
            }
            //Right
            count = 0;
            for (int col = n - 1; col >= 0; col--) {
                if (grid[row][col] != 0) {
                    count++;
                } else {
                    count = 0;
                }
                grid[row][col] = Math.min(grid[row][col], count);
            }
        }

        int result = 0;

        for (int col = 0; col < n; col++) {
            int count = 0;
            for (int row = 0; row < n; row++) { //up
                if (grid[row][col] != 0) {
                    count++;
                } else {
                    count = 0;
                }
                grid[row][col] = Math.min(grid[row][col], count);
            }
            count = 0; //down
            for (int row = n - 1; row >= 0; row--) {
                if (grid[row][col] != 0) {
                    count++;
                } else {
                    count = 0;
                }
                grid[row][col] = Math.min(grid[row][col], count);
                result = Math.max(result, grid[row][col]);
            }
        }
        return result;
    }
}
