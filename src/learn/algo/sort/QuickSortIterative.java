package learn.algo.sort;


import learn.util.ArrayUtil;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Varma Penmetsa
 * https://github.com/mission-peace/interview/blob/68f97392c6f6e14e2c08860684ed605a1a5e7e72/src/com/interview/sort/IterativeQuickSort.java
 */
public class QuickSortIterative {

    public static void sort(int arr[]){
        Deque<Integer> stack = new ArrayDeque<>();
        int low = 0;
        int high = arr.length-1;
        stack.push(low);
        stack.push(high);

        while(!stack.isEmpty()){
            high = stack.pop();
            low = stack.pop();

            int p = partition(arr,low,high);
            if(low < p-1 && high > p+1){
                stack.push(low);
                stack.push(p-1);
                stack.push(p+1);
                stack.push(high);
            }
            else if(low < p-1){
                stack.offerFirst(low);
                stack.offerFirst(p-1);
            }else if(high > p+1){
                stack.offerFirst(p+1);
                stack.offerFirst(high);
            }
        }
    }

    private static int partition(int arr[], int low,int high){
        int pivot = low;
        int i = low+1;
        int j = high;
        while(i <= j){

            if(arr[i] <= arr[pivot]){
                i++;
                continue;
            }
            if(arr[j] > arr[pivot]){
                j--;
                continue;
            }
            ArrayUtil.swap(arr,i++,j--);
        }
        if(arr[pivot] >= arr[j]){
            ArrayUtil.swap(arr,pivot,j);
            return j;
        }
        return pivot;

    }

    public static void main(String[] args) {
        int[] array = ArrayUtil.generateRandomArray(12,9);
        ArrayUtil.display(array);
        sort(array);
        ArrayUtil.display(array);
    }

}
