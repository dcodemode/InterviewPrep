package learn.ds.stack;


import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * @author Varma Penmetsa
 *
 * https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
 *
 * Allowed to use extra space
 *
 */
public class MinStack {

    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    /**
     *
     * PUSH:
     *    Push x to the first stack (the stack with actual elements)
     *    compare x with the top element of the second stack (the auxiliary stack). Let the top element be y.
     *    If x is smaller than y then push x to the auxiliary stack.
     *
     * POP:
     *    POP the element from s2 if s1 val is equal to s2
     *
     * GetMin:
     *    Peek the element from s2
     *
     * IsEmpty:
     *    Check if s2 is empty.
     *
     */

    public void push(Integer data){
        if(s1.isEmpty() && s2.empty()){
            s1.push(data);
            s2.push(data);
            return;
        }

        s1.push(data);

        if(s1.peek() < s2.peek()){
            s2.push(s1.peek());
        }

    }

    public Integer pop(){
        Integer ret ;
        if (!s1.isEmpty() && !s2.isEmpty()) {

            int x = s1.pop();

            if(x == s2.peek()){
                s2.pop();
            }

            return x;
        }else{
            return -1;
        }
    }

    public boolean isEmpty(){
        if(s2.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public Integer getMin(){
        return s2.peek();
    }

    public Integer peek(){
        return s1.peek();
    }


    public static void main(String[] args) {
        MinStack st = new MinStack();
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

        System.out.println(st.getMin());
    }
}

