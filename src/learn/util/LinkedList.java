package learn.util;

/**
 * @author Varma Penmetsa
 */

import learn.ds.nodes.ListNode;

public class LinkedList {

    public ListNode head;

    public LinkedList() {

    }

    public LinkedList(ListNode head) {
        this.head = head;
    }

    public LinkedList(int data) {
        this.head = new ListNode(data);
    }

    /* Push adds node on front of the list*/
    public void push(int data) {
        ListNode new_node = new ListNode(data);
        new_node.next = head;
        head = new_node;

    }

    /* Pop removes first element in the linked list*/
    public void pop() {
        if (head == null) {
            System.out.println("\nNo Elements to pop ");
            return;
        }
        head = head.next;
    }

    /* Print elements of a linked list*/
    public void display() {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.data + " --> ");
            node = node.next;
        }
        System.out.println("null");
    }

    public void display2(ListNode head) {
        ListNode node = head;
        while (node != null) {
            System.out.print(node.data + " --> ");
            node = node.next;
        }
        System.out.println("null");
    }

    /* Add after last node */
    public void append(int new_data) {

        if (head == null) {
            head = new ListNode(new_data);
            return;
        }
        ListNode new_node = new ListNode(new_data);
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new_node;
    }

    /*Length of a linked list*/
    public int length() {
        ListNode node = head;
        int i = 0;
        while (node != null) {
            i++;
            node = node.next;
        }
        return i;
    }

    /* Insert after a given node */
    public void insertAfter(ListNode prev, int new_data) {

        ListNode new_node = new ListNode(new_data);
        ListNode temp;

        if (null == prev) {
            System.out.println("Given node cant't be null");
            return;
        }
        new_node.next = prev.next;
        prev.next = new_node;
    }


    /*Search an element in linked list iterative solution*/
    public int search(int data) {
        ListNode temp = head;

        while (temp != null && temp.data != data) {
            temp = temp.next;
        }

        if (temp == null) {
            return -1;
        }
        return 1;

    }

    /*Search an element in linked list recursive solution*/
    public boolean searchRecursive(ListNode head, int data) {
        if (head == null) {
            return false;
        }
        if (head.data == data) {
            return true;
        }
        return searchRecursive(head.next, data);
    }

    /* Write a function to get Nth node in a Linked List */
    public ListNode getNode(int position) {
        ListNode node = head;
        int i = 0;
        while (node != null && i < position) {
            i++;
            node = node.next;
        }
        return node;
    }

    public static void main(String args[]) {
        LinkedList ll = new LinkedList(new ListNode(10));
        ListNode a = new ListNode(20);
        ListNode b = new ListNode(30);
        ListNode c = new ListNode(40);
        ListNode d = new ListNode(50);
        ListNode e = new ListNode(60);
        ListNode f = new ListNode(70);

        ll.head.next = a;
        ll.head.next.next = b;
        ll.head.next.next.next = c;
        ll.head.next.next.next.next = d;
        ll.head.next.next.next.next.next = e;
        ll.head.next.next.next.next.next.next = f;
        ll.append(10);
        ll.append(10);
        ll.append(10);
        ll.push(5);
        ll.push(1);
        ll.pop();
        ll.pop();
        ll.insertAfter(a, 25);

        ll.display();
        System.out.println("Length of linked list: " + ll.length());
        System.out.println(ll.searchRecursive(ll.head, 10));
        System.out.println(ll.getNode(9));
        ll.display();
    }

}
