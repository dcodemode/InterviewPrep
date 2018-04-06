package learn.algo.search;

/**
 * @author Varma Penmetsa
 * https://www.geeksforgeeks.org/exponential-search/
 */
public class ExponentialSearch {

    public static int binarySearch(int[] array, int x , int left, int right) {
        int n = array.length;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == x) {
                return mid;
            } else if (x < array[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 1. Find Range
     * 2. Binary Search
     *
     * Time Complexity: O(log n)
     * Auxiliary Space: O(1)
     */
    public static int expSearch(int[] array, int x){
        int n = array.length, left = 0, right = n - 1;

        for(int i = 1; i < n ; i = 2*i){
            if(array[i-1] == x){
                return i-1;
            }else if(array[i-1] > x){
                right = i-1;
                left = (i-1)/2;
                break;
            }
        }
        return binarySearch(array,x,left,right);
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 10, 40};
        System.out.println(expSearch(arr,7));
    }

}
