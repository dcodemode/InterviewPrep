package learn.ds.array;

/**
 * @author Varma Penmetsa
 *
 * https://www.geeksforgeeks.org/search-an-element-in-a-sorted-and-pivoted-array/
 *
 * Given a rotated sorted array, perform search in O(log n) time
 * Assume no duplicates
 *
 * Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}; key = 3
 * Output : Found at index 8
 *
 * Input  : arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3}; key = 30
 * Output : Not found
 *
 * Input : arr[] = {30, 40, 50, 10, 20}; key = 10
 * Output : Found at index 3
 */
public class SearchRotateArray {

    /**
     * Input arr[] = {3, 4, 5, 1, 2}
     * Element to Search = 1
     *  1) Find out pivot point and divide the array in two sub-arrays. (pivot = 2)
     *  2) Now call binary search for one of the two sub-arrays.
     *      (a) If element is greater than 0th element then search in left array
     *      (b) Else Search in right array (1 will go in else as 1 < 0th element(3))
     *  3) If element is found in selected sub-array then return index
     *      Else return -1.
     *
     */
    public static int search(int[] array, int x) {
        int n = array.length;
        int pivot = findPivot(array, 0, n - 1);

        if (pivot == -1) {
            return binarySearch(array, x, 0, n - 1);
        } else if (array[pivot] == x) {
            return pivot;
        } else if (array[0] > x) {
            return binarySearch(array, x, pivot + 1, n - 1);
        } else {
            return binarySearch(array, x, 0, pivot - 1);
        }

    }

    // Using Binary Search, time Complexity : O(log n)
    public static int findPivot(int[] array, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (left == right) {
            return left;
        }

        int mid = left + (right - left) / 2;

        if (array[mid] > array[mid + 1]) {
            return mid;
        } else if (array[mid - 1] > array[mid]) {
            return mid - 1;
        }

        if (array[left] >= array[mid]) {
            return findPivot(array, left, mid - 1);
        } else {
            return findPivot(array, mid + 1, right);
        }

    }

    public static int binarySearch(int[] array,int x, int left, int right){

        while (left<=right){
            int mid = left + (right - left) / 2;
            if(array[mid] == x){
                return mid;
            }else if(x < array[mid]){
                right = mid - 1;
            }else {
                left = mid + 1 ;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {2,3,4,5,1};
        System.out.println(findPivot(array,0,array.length-1));
    }

}
