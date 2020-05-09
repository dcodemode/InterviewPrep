package learn.ds.matrix;


/**
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 * Example:
 *
 * Consider the following matrix:
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 *
 * Given target = 20, return false.
 *
 *
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 * https://www.youtube.com/watch?v=FOa55B9Ikfg&t=581s
 */
public class SearchMatrixDisContSortVariant {

    public boolean search(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }

        int col = matrix[0].length - 1;
        int row = 0;

        while (col >= 0 && row <= matrix.length - 1) {
      /*
        Cases:
          target == item : We found the item. Return true.
          target < item : Target must be to our left...go down in value
          target > item : Target must be to our below...go up in value
      */
            if (target == matrix[row][col]) {
                return true;
            } else if (target < matrix[row][col]) {
                col--;
            } else if (target > matrix[row][col]) {
                row++;
            }
        }

        return false;
    }
}
