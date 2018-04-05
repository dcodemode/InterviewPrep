package learn.ds.array.search;

/**
 * @author Varma Penmetsa
 *
 * https://www.geeksforgeeks.org/jump-search/
 *
 *  Jump size: step = √n.
 */
public class JumpSearch {

    /**
     * Time Complexity:  O(√n)
     * Auxiliary Space: O(1)
     */
    public static int search(int[] array, int x){
        int n = array.length;
        int step = (int) Math.floor(Math.sqrt(n));
        int i,prev;

        for(i = 0 ; i < n ; i = i + step){
            if(array[i] > x){
                break;
            }
        }

        if(i-step >= 0 && i -step < n ){
            prev = i-step;
        }else {
            prev = 0;
        }

        while(i > prev){
            if(array[--i] == x){
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int array[] = {0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610};
        int x = 1;
        System.out.println(search(array,x));
    }
}
