package learn.algo.search;

/**
 * @author Varma Penmetsa
 *
 * https://www.geeksforgeeks.org/linear-search/
 */
public class LinearSearch {

    /**
     * Space Complexity: O(1)
     * Time Complexity: O(n)
     */
    public static int search(int[] array, int x) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == x) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array = {1,2,3,1,5,1,7,1};
        System.out.println(search(array, 1));
    }
}
