package learn.ds.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author Varma Penmetsa
 * The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate 
 * span of stock’s price for all n days. 
 *
 * For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85},
 * then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}
 *
 * https://www.geeksforgeeks.org/the-stock-span-problem/
 */
public class StockSpan {

    //Naive Approach O(n^2)
    public static void checkSpan(int price[], int n, int S[]) {
        S[0] = 1;
        for (int i = 1; i < n; i++) {
            S[i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (price[i] >= price[j]) {
                    S[i]++;
                } else {
                    break;
                }
            }
        }
    }

    //Using Stack O(n)
    public static void checkSpan2(int price[], int n, int S[]) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        S[0] = 1;

        for (int i = 1; i < n; i++) {
            while (!st.isEmpty() && price[st.peek()] <= price[i]){
                st.pop();
            }
            S[i] = (st.empty())? (i + 1) : (i - st.peek());
            st.push(i);
        }
    }

    public static void main(String[] args) {

        int price[] = {10, 4, 5, 90, 120, 80};
        int n = price.length;
        int S[]= new int[n];

        checkSpan2(price, n, S);
        System.out.println(Arrays.toString(S));

    }
}
