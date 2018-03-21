package learn.ds.stack;

import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * @author Varma Penmetsa
 *
 * Create Max stack if you are allowed to use extra space
 *
 */
public class MaxStack {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void push(Integer val){
        if(s1.isEmpty() & s2.isEmpty()){
            s1.push(val);
            s2.push(val);
            return;
        }
        s1.push(val);
        if(val > s2.peek()){
            s2.push(val);
        }
    }

    public void pop(){
        int val = s1.pop();
        if(val == s2.peek()){
            s2.pop();
        }
    }

    public Integer getMax(){
        return s2.peek();
    }

    public static void main(String[] args) {
        MaxStack st = new MaxStack();

        Random ran = new Random();

        st.push(ran.nextInt(99));
        st.push(ran.nextInt(99));
        st.push(ran.nextInt(99));
        st.push(ran.nextInt(99));
        st.push(ran.nextInt(99));
        st.push(ran.nextInt(99));
        st.push(ran.nextInt(99));
        st.push(ran.nextInt(99));
        st.push(ran.nextInt(99));
        st.push(ran.nextInt(99));
        st.push(ran.nextInt(99));
        st.push(ran.nextInt(99));

        System.out.println(Arrays.toString(st.s1.toArray()));

        st.pop();
        st.pop();
        st.pop();

        System.out.println(Arrays.toString(st.s1.toArray()));

        System.out.println(st.getMax());
    }
}
