package learn.ds;

import learn.nodes.SListNode;

public class LinkedList {

    SListNode head;

    /* Push adds node on front of the list*/
    public void push(int data) {
        SListNode new_node = new SListNode(data);
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
    public void print(SListNode head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
    }

    /* Insert after a given node */
    public void insertAfter(SListNode prev, int new_data) {

        SListNode new_node = new SListNode(new_data);
        SListNode temp;

        if (null == prev) {
            System.out.println("Given node cant't be null");
            return;
        }
        new_node.next = prev.next;
        prev.next = new_node;
    }

    /* Add after last node */
    public void append(int new_data) {

        if (head == null) {
            head = new SListNode(new_data);
            return;
        }
        SListNode new_node = new SListNode(new_data);
        SListNode node = head;
        while (node.next != null) {
            node = node.next;
        }
        node.next = new_node;
    }

    /* Given a ‘key’, delete the first occurrence of this key in linked list. */
    public void deleteKey(int new_data) {
        SListNode node = head;
        SListNode prevNode = null;

        if (node != null && node.data == new_data) {
            head = node.next;
            return;
        }

        while (node != null && node.data != new_data) {
            prevNode = node;
            node = node.next;
        }

        if (node == null) {
            System.out.println("Key not found.");
            return;
        }
        prevNode.next = node.next;
    }

    /* Deletes the node at the given node */
    public void deleteNode(SListNode node) {
       SListNode temp =head;
       SListNode prev = null;

       if(temp == node){
           head=temp.next;
           return;
       }
       while(temp != null && temp != node){
           prev = temp;
           temp=temp.next;
       }

       if (temp == null){
           System.out.println("Give node not found");
           return;
       }
       prev.next=temp.next;
    }

    /* Deletes the node at the given position */
    public void deleteAfterPosition(int position){
       SListNode node = head;
       SListNode prev = null;

       if (position==0){
           head = node.next;
           return;
       }

       int i=0;
       while(node!=null && i<=position-1){
           prev=node;
           node=node.next;
           i++;
       }

       if(node == null) return;
       prev.next=node.next;

    }


    public static void main(String args[]) {
        LinkedList ll = new LinkedList();
        SListNode a = new SListNode(20);
        SListNode b = new SListNode(30);
        ll.head = new SListNode(10);

        ll.head.next = a;
        ll.head.next.next = b;

        ll.push(5);
        ll.push(1);

        ll.insertAfter(a, 25);
        ll.append(70);
        ll.print(ll.head);
        System.out.println("\n");
        ll.deleteKey(15);
        ll.deleteNode(ll.head);
        ll.deleteAfterPosition(7);
        ll.print(ll.head);
    }

}
