package learn.ds.stack;

import java.util.Stack;

/**
 * @author Varma Penmetsa
 *
 * https://www.geeksforgeeks.org/design-a-stack-that-supports-getmin-in-o1-time-and-o1-extra-space/
 */
public class MinStackNoExtraSpace {

    Stack<String> stackArray = new Stack<>();
    String min;


    public void push(String val){
        if(stackArray.isEmpty()){
            stackArray.push(val);
            min = val;
            return;
        }

    }

    public static void main(String[] args) {

    }
}
