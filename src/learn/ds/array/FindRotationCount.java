package learn.ds.array;

/**
 * @author Varma Penmetsa
 *
 * Consider an array of distinct numbers sorted in increasing order.
 * The array has been rotated (anti-clockwise) k number of times.
 * Given such an array, find the value of k.
 *
 * Examples:
 *
 * Input : arr[] = {15, 18, 2, 3, 6, 12}
 * Output: 2
 * Explanation : Initial array must be {2, 3, 6, 12, 15, 18}.
 * We get the given array after rotating the initial array twice.
 *
 * Input : arr[] = {7, 9, 11, 12, 5}
 * Output: 4
 *
 * Input: arr[] = {7, 9, 11, 12, 15};
 * Output: 0
 *
 * https://www.geeksforgeeks.org/find-rotation-count-rotated-sorted-array/
 */
public class FindRotationCount {

    public static int countRotation(int[] array) {
        int pivot = pivot(array, 0, array.length - 1);
        if (pivot == -1) {
            return 0;
        } else {
            return pivot + 1;
        }
    }

    /**
     *Time Complexity: O(log n)
     * Space Complexity: O(x)
     */
    public static int pivot(int[] array, int left, int right) {
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (array[mid] > array[mid + 1]) {
                return mid;
            } else if (array[mid - 1] > array[mid]) {
                return mid - 1;
            }

            if (array[left] >= array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {7, 9, 11, 12, 15};
        System.out.println(countRotation(array));
    }

}
