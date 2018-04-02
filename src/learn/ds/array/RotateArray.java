package learn.ds.array;

import learn.ds.util.ArrayUtil;

public class RotateArray {

    /**
     * Rotate one by one.
     * Time Complexity: O(n * d)
     * Space Complexity: O(1)
     */
    public static void rotate(int[] array, int d){
        int len = array.length;

        for(int j = 0 ; j < d; j++){
            int temp = array[0];
            for(int i = 0 ; i < len - 1 ; i ++){
                array[i] =  array[i+1];
            }
            array[len-1] = temp;
        }
    }

    /**
     * Juggling Algorithm
     * Time Complexity: O(1)
     * Space Complexity: O(n)
     */
    public static void rotate2(int[] array, int d) {
        int n = array.length;
        int i, j, k, temp;
        for(i = 0 ;i < gcd(d,n); i ++){
            temp = array[i];
            j = i;
            while (true) {
                k = j + d;
                if(k >= n){
                    k = k - n;
                }
                if(k == i){
                    break;
                }
                array[j] = array[k];
                j = k;
            }
            array[j] = temp;
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void main(String[] args) {
        System.out.println("Actual Array");
        int[] array = {1,2,3,4,5,6,7,8,9,10,11,12};
        ArrayUtil.display(array);

        System.out.println("Rotated Array 1");
        rotate(array, 2);
        ArrayUtil.display(array);

        System.out.println("Rotated Array 2");
        rotate2(array, 2);
        ArrayUtil.display(array);

    }
}
