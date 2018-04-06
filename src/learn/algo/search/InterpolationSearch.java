package learn.algo.search;

/**
 * @author Varma Penmetsa
 * https://www.geeksforgeeks.org/interpolation-search/
 */
public class InterpolationSearch {

    public static int search(int[] arr, int x) {
        int lo = 0, hi = (arr.length - 1);

        while (lo <= hi) {

            int pos = lo + (  ( (hi - lo) / (arr[hi] - arr[lo]))   *   (x - arr[lo]) );

            if (arr[pos] == x)
                return pos;

            if (arr[pos] < x)
                lo = pos + 1;
            else
                hi = pos - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {10, 12, 13, 16, 18, 19, 20, 21, 22, 23, 24, 33, 35, 42, 47};
        System.out.println(search(array,13));
    }
}
