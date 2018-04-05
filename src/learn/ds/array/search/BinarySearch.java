package learn.ds.array.search;

/**
 * @author Varma Penmetsa
 *
 * https://www.geeksforgeeks.org/binary-search/
 */
public class BinarySearch {

    /**
     * Recursive implementation
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int search(int array[],int x, int left, int right) {
        if (right >= left) {
            int mid = left + (right - left) / 2;

            if (array[mid] == x) {
                return mid;
            }else if (x < array[mid]) {
                return search(array, x, left, mid - 1);
            }else {
                return search(array, x, mid + 1, right);
            }
        }
        return -1;
    }

    /**
     * Iterative Approach
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int search(int[] array, int x){
        int left = 0;
        int right = array.length - 1;
        int mid;

        while (left <= right){
            mid = left + (right - left) / 2;
            if(array[mid] == x){
                return mid;
            }else if(array[mid] < x){
                left = mid + 1;
            }else {
                right = mid -1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int n = arr.length;
        System.out.println(search(arr, 9));
    }
}
