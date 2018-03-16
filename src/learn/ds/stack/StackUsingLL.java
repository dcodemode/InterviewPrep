package learn.ds.stack;


import learn.ds.nodes.ListNode;
import learn.ds.util.LinkedList;

/**
 * @author Varma Penmetsa
 *
 * Pros: The linked list implementation of stack can grow and shrink according to the needs at runtime.
 * Cons: Requires extra memory due to involvement of pointers.
 *
 * https://www.geeksforgeeks.org/stack-data-structure-introduction-program/
 */
public class StackUsingLL {

    public class Node {
        public String val;
        public Node next;

        public Node(String val) {
            this.val = val;
        }
    }

    Node head;

    public void push(String val) {
        Node new_node = new Node(val);
        new_node.next = head;
        head = new_node;
    }

    public String pop() {
        if (head != null) {
            Node temp = head;
            head = head.next;
            return temp.val;
        }else{
            return "";
        }
    }

    public String peek() {
        if (head != null) {
            return head.val;
        } else {
            return "";
        }
    }

    public boolean isEmpty() {
        if (head != null) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String args[]) {

        StackUsingLL ll = new StackUsingLL();
        ll.push("S");
        ll.push("T");
        ll.push("A");
        ll.push("C");
        ll.push("K");

        System.out.println(ll.peek());
        System.out.println(ll.pop());

        System.out.println(ll.isEmpty());
    }

}
