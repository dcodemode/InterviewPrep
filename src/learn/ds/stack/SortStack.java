package learn.ds.stack;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Varma Penmetsa
 *
 * https://www.geeksforgeeks.org/sort-a-stack-using-recursion/
 */
public class SortStack {

    //Using Recursion
    public static void sort(Deque<Integer> st){
        if(st.isEmpty())
            return;
        int val = st.pop();
        sort(st);
        sortedInsert(st,val);
    }

    public static void sortedInsert(Deque<Integer> st ,int val){
        if(st.isEmpty() || val > st.peek()){
            st.push(val);
            return;
        }else {
            int v = st.pop();
            sortedInsert(st,val);
            st.push(v);
        }
    }

    //Iteration O(n^2)
    public static Deque<Integer> sort2(Deque<Integer> input){
        Deque<Integer> tmpStack = new ArrayDeque<>();
        while (!input.isEmpty()) {
            int tmp = input.pop();
            while (!tmpStack.isEmpty() && tmpStack.peek() > tmp) {
                input.push(tmpStack.pop());
            }
            tmpStack.push(tmp);
        }
        return tmpStack;
    }



    public static void main(String[] args) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(5);
        st.push(7);
        st.push(1);
        st.push(-9);
        st.push(2);

        System.out.println(Arrays.toString(sort2(st).toArray()));
    }
}
