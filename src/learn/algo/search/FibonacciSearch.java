package learn.algo.search;

/**
 * @author Varma Penmetsa
 * https://www.geeksforgeeks.org/fibonacci-search/
 */
public class FibonacciSearch {

    public static int search(int array[], int x) {

        int m2 = 0, m1 = 1, m = m2 + m1, n = array.length;

        while (m < n) {
            m2 = m1;
            m1 = m;
            m = m2 + m1;
        }

        int offset = -1;

        while (m > 1) {
            int i = min(offset + m2, n-1);

            if (array[i] == x) {
                return i;
            } else if (array[i] < x) {
                m = m1;
                m1 = m2;
                m2 = m - m1;
                offset = i;
            } else {
                m = m2;
                m1 = m1 - m2;
                m2 = m - m1;
            }
        }

        if (m1 == 1 && array[offset + 1] == x) {
            return offset + 1;
        }

        return -1;
    }

    public static int min(int x, int y) {
        return (x <= y) ? x : y;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 4, 10, 40};
        System.out.println(search(arr,4));
    }

}
