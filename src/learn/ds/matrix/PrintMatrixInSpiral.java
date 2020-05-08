package learn.ds.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * Print a given matrix in spiral form
 *
 * Given a 2D array, print it in spiral form. See the following examples.
 *
 * Examples:
 *
 * Input:  1    2   3   4
 *         5    6   7   8
 *         9   10  11  12
 *         13  14  15  16
 * Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
 * Explanation: The output is matrix in spiral format.
 *
 * Input:  1   2   3   4  5   6
 *         7   8   9  10  11  12
 *         13  14  15 16  17  18
 * Output: 1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11
 * Explanation :The output is matrix in spiral format.
 *
 * https://www.geeksforgeeks.org/print-a-given-matrix-in-spiral-form/
 */
public class PrintMatrixInSpiral {

    /**
     * Time Complexity :  O(N)
     * Space Complexity : O(N) as we are using ArrayList to store answer.
     *
     * https://www.youtube.com/watch?v=BdQ2AkaTgOA
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix==null || matrix.length==0){
            return list;
        }
        int left = 0;
        int right = matrix[0].length-1;
        int top = 0;
        int bottom = matrix.length-1;
        int size = matrix.length * matrix[0].length;
        while(list.size() < size){
            for(int i=left ; i<=right && list.size() < size ; i++){
                list.add(matrix[top][i]);
            }
            top++;
            for(int i=top ; i<=bottom && list.size() < size ; i++){
                list.add(matrix[i][right]);
            }
            right--;
            for(int i=right ; i>=left && list.size() < size ; i--){
                list.add(matrix[bottom][i]);
            }
            bottom--;
            for(int i=bottom; i>=top && list.size() < size ; i--){
                list.add(matrix[i][left]);
            }
            left++;
        }
        return list;
    }
}
