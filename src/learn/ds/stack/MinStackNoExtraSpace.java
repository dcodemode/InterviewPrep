package learn.ds.stack;

import java.util.Random;
import java.util.Stack;

/**
 * @author Varma Penmetsa
 *
 * https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
 *
 * Push: 2 * x - minVal
 * Pop : 2 * minVal - y
 */
public class MinStackNoExtraSpace {

    Stack<Integer> stackArray = new Stack<>();
    Integer minVal;

    public void push(Integer val){
        if(stackArray.isEmpty()){
            stackArray.push(val);
            minVal = val;
            return;
        }
        if(val < minVal){
            int pushVal = 2 * val - minVal;
            stackArray.push(pushVal);
            minVal = val;
        }else {
            stackArray.push(val);
        }

    }

    public void pop(){
        int y = stackArray.pop();
        if(y < minVal){
            minVal = 2 * minVal - y;
        }
    }

    public int getMin(){
        return minVal;
    }

    public static void main(String[] args) {

        MinStackNoExtraSpace st = new MinStackNoExtraSpace();
        Random ran = new Random();

        st.push(1);
        st.push(90);
        st.push(100);
        st.push(53);
        st.push(35);
        st.push(52);
        st.push(87);
        st.push(4);
        st.push(0);

        st.pop();

        System.out.println(st.getMin());

    }
}
