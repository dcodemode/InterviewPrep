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

    public static void sort(Deque<Integer> st){
        if(st.isEmpty())
            return;
        int val = st.pop();
        sort(st);
        sortedInsert(st,val);
    }

    public static void sortedInsert(Deque<Integer> st ,int val){
        if(st.isEmpty() || val < st.peek()){
            st.push(val);
            return;
        }else {
            int v = st.pop();
            sortedInsert(st,val);
            st.push(v);
        }
    }

    public static void main(String[] args) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(5);
        st.push(7);
        st.push(1);
        st.push(-9);
        st.push(2);

        sort(st);

        System.out.println(Arrays.toString(st.toArray()));
    }
}
