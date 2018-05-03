package learn.ds.array;

/**
 * Partition problem is to determine whether a given set can be partitioned into two subsets
 * such that the sum of elements in both subsets is same.
 *
 * Examples
 * Input  : {1, 5, 11, 5}
 * Output : true
 * The array can be partitioned as {1, 5, 5} and {11}
 *
 * Input  : {1, 5, 3}
 * Output : false
 * The array cannot be partitioned into equal sum sets.
 *
 * https://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/
 */
public class PartitionProblem {

    /**
     * Recursive Solution
     * 1) Calculate sum of the array. If sum is odd, there can not be two subsets with equal sum, so return false.
     * 2) If sum of array elements is even, calculate sum/2 and find a subset of array with sum equal to sum/2.
     *
     * Time Complexity  : O(2^n)
     * Space Complexity : O(n)
     */

    public static boolean findPartition(int[] array){
        if (array.length == 0){
            return false;
        }
        int n = array.length;
        int sum = 0;
        for(int i =0 ;i < n;i++){
            sum += array[i];
        }

        if (sum %2 != 0){
            return false;
        }else {
            return subPartition(array,n,sum/2);
        }
    }

    /**
     * Let isSubsetSum(arr, n, sum/2) be the function that returns true if
     * there is a subset of arr[0..n-1] with sum equal to sum/2
     *
     * The isSubsetSum problem can be divided into two subproblems
     *  a) isSubsetSum() without considering last element
     *     (reducing n to n-1)
     *  b) isSubsetSum considering the last element
     *     (reducing sum/2 by arr[n-1] and n to n-1)
     */
    public static boolean subPartition(int[] array, int n, int sum){

        if (sum == 0)
            return true;

        if (n == 0 && sum != 0)
            return false;

        if (array[n-1] > sum)
            return subPartition(array,n-1,sum);

        return subPartition(array,n-1,sum) || subPartition(array,n-1,sum-array[n-1]);
    }

    public static void main(String[] args) {
        int[] array = {3,1,5,9,12};
        System.out.println(findPartition(array));
    }
}
