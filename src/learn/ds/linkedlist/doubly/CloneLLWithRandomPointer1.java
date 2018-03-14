package learn.ds.linkedlist.doubly;

import learn.ds.nodes.ListNode;
import learn.ds.util.LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Varma Penmetsa
 *
 * Using hash table approach
 *
 * https://www.geeksforgeeks.org/clone-linked-list-next-arbit-pointer-set-2/
 */

public class CloneLLWithRandomPointer1 {

    Node head;

    public CloneLLWithRandomPointer1() {
    }

    public CloneLLWithRandomPointer1(int data) {
        this.head = new Node(data);
    }

    public class Node {
        int data;
        Node next, random;

        public Node(int data) {
            this.data = data;
            next = random = null;
        }
    }

    void print() {
        Node temp = head;
        while (temp != null) {
            Node random = temp.random;
            int randomData = (random != null) ? random.data : -1;
            System.out.println("Data = " + temp.data +
                    ", Random data = " + randomData);
            temp = temp.next;
        }
    }

    public void push(int data) {
        Node node = new Node(data);
        node.next = this.head;
        this.head = node;
    }

    /*
     * The idea is to use Hashing. Below is algorithm.
     * 1. Traverse the original linked list and make a copy in terms of data.
     * 2. Make a hash map of key value pair with original linked list node and copied linked list node.
     * 3. Traverse the original linked list again and using the hash map adjust the next and random reference of cloned linked list nodes.
     */
    public Node clone(Node head){
        Node orig = head;  Node clone = null;

        Map<Node,Node> map = new HashMap<>();

        while(orig!=null){
            clone = new Node(orig.data);
            map.put(orig, clone);
            orig = orig.next;
        }
        orig = head;

        while (orig != null) {
            clone = map.get(orig);
            clone.next = map.get(orig.next);
            clone.random = map.get(orig.random);
            orig = orig.next;
        }

        //return the head reference of the clone list.
        return map.get(head);
    }

    public static void main(String[] args){

        CloneLLWithRandomPointer1 list = new CloneLLWithRandomPointer1(5);

        list.push(4);
        list.push(3);
        list.push(2);
        list.push(1);

        // Setting up random references.
        list.head.random = list.head.next.next;
        list.head.next.random = list.head.next.next.next;
        list.head.next.next.random = list.head.next.next.next.next;
        list.head.next.next.next.random = list.head.next.next.next.next.next;
        list.head.next.next.next.next.random = list.head.next;

        list.print();
        list.clone(list.head);
        System.out.println();
        list.print();

    }

}
