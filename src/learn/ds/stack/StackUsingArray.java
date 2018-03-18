package learn.ds.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Varma Penmetsa
 *
 * Pros: Easy to implement. Memory is saved as pointers are not involved.
 * Cons: It is not dynamic. It doesn’t grow and shrink depending on needs at runtime.
 *
 * https://www.geeksforgeeks.org/stack-data-structure-introduction-program/
 *
 */

public class StackUsingArray {
    public int stackSize;
    public String[] stackArray;
    public int top = 0;

    public StackUsingArray(int stackSize) {
        this.stackSize = stackSize;
        stackArray = new String[stackSize];
    }

    public void push(String val) {
        if (top < stackSize) {
            stackArray[top++] = val;
        } else {
            System.out.println("Stack Overflow");
        }
    }

    public String pop() {
        if (top == 0) {
            System.out.println("Stack Underflow");
            return null;
        } else {
            String ret = stackArray[--top];
            stackArray[top] = null;
            return ret;
        }
    }

    public String peek() {
        if (top <= stackSize) {
            return stackArray[top - 1];
        } else {
            System.out.println("Stack Underflow");
            return "";
        }
    }

    public boolean isEmpty() {
        if (top == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String args[]) {

        Queue<String> q = new LinkedList<>();
        StackUsingArray st = new StackUsingArray(5);
        st.push("S");
        st.push("T");
        st.push("A");
        st.push("C");
        st.push("K");

        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());
        System.out.println(st.pop());

        System.out.println("Is stack empty: " + st.isEmpty());
    }
}
