package learn.ds.matrix;

/**
 * 8/24/18
 *
 * Rotate Matrix Elements
 *
 * Given a matrix, clockwise rotate elements in it.
 *
 * Examples:
 *
 * Input
 *  1    2    3
 *  4    5    6
 *  7    8    9
 *
 * Output:
 *  4    1    2
 *  7    5    3
 *  8    9    6
 *
 * For 4*4 matrix
 *
 * Input:
 *  1    2    3    4
 *  5    6    7    8
 *  9    10   11   12
 *  13   14   15   16
 *
 * Output:
 *  5    1    2    3
 *  9    10   6    4
 *  13   11   7    8
 *  14   15   16   12
 *
 * 
 * 
 * https://www.geeksforgeeks.org/rotate-matrix-elements/
 *
 */
public class RotateMatrixElements {

    /**
     * Transpose and then reverse:
     * The obvious idea would be to transpose the matrix first and then reverse each row. 
     * This simple approach already demonstrates the best possible time complexity
     * @param matrix
     */
    public static void rotate(int[][] matrix){
        int n = matrix.length;
        //Step1: Transpose Matrix
        for(int i=0 ; i < n ; i++){
            for(int j = i ; j < n ; j++){
                int temp = matrix[j][i];
                matrix[j][i] =  matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        //Step 2: Swap last node to first
        for(int i = 0 ; i < n; i++){
            for(int j  = 0; j < n/2 ; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    public static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) { 
            for (int j = 0; j < matrix.length; j++) 
            System.out.print( matrix[i][j] + " "); 
            System.out.print("\n"); 
        } 
    }

    public static void main(String[] args) {
        int[][] matrix = { {1, 2, 3}, {4, 5, 6}, {7,8,9}}; 
        printMatrix(matrix);
        rotate(matrix);
        System.out.println("---------------------");
        printMatrix(matrix);
    }
}
