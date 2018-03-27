package learn.ds.array;

/**
 * @author Varma Penmetsa
 *
 * https://www.geeksforgeeks.org/circular-array/
 *
 * Hint: Use mod operator 
 *
 */
public class CircularArray {

    public static void print(char[] array, int index){
        int n = array.length;
        for(int i = index; i < n + index ; i++ ){
            System.out.print(array[i % n] +" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        char[] array = new char[]{'A', 'B', 'C', 'D', 'E', 'F'};
        print(array, 1);
    }
}
