package learn.ds.stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author Varma Penmetsa
 *
 * https://www.geeksforgeeks.org/reverse-a-stack-using-recursion/
 */
public class ReverseStack {

    public static void reverse(Deque<Integer> st){
        if(st.isEmpty()){
            return;
        }
        int val = st.pop();
        reverse(st);
        st.addLast(val);
    }

    public static void main(String[] args) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);

        reverse(st);

        System.out.println(Arrays.toString(st.toArray()));
    }
}
