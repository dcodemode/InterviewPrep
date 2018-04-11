package learn.util;


/**
 * @author Varma Penmetsa
 *
 * Pros: The linked list implementation of stack can grow and shrink according to the needs at runtime.
 * Cons: Requires extra memory due to involvement of pointers.
 *
 * https://www.geeksforgeeks.org/stack-data-structure-introduction-program/
 */
public class Stack {

    public int stackSize;
    public String[] stackArray;
    public int top = 0;

    public Stack(int stackSize) {
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
        return top == 0;
    }

    public static void main(String args[]) {

        Stack ll = new Stack(5);
        ll.push("S");
        ll.push("T");
        ll.push("A");
        ll.push("C");
        ll.push("K");

        System.out.println(ll.peek());
    }

}
