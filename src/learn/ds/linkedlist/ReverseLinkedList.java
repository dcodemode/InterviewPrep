package learn.ds.linkedlist;

/**
 * @author Varma Penmetsa
 */

import learn.ds.nodes.SListNode;

public class ReverseLinkedList {

    SListNode head;

    public ReverseLinkedList(SListNode node){
        this.head = node;
    }

    /*  Reverse nodes of a linked list */
    public void reverse(){

    }

    public static void main(String args[]){
        LinkedList ll = new LinkedList(new SListNode(10));

        SListNode a = new SListNode(20);
        SListNode b = new SListNode(30);
        SListNode c = new SListNode(40);
        SListNode d = new SListNode(50);
        SListNode e = new SListNode(60);
        SListNode f = new SListNode(70);

        ll.head.next = a;
        ll.head.next.next = b;
        ll.head.next.next.next = c;
        ll.head.next.next.next.next = d;
        ll.head.next.next.next.next.next = e;
        ll.head.next.next.next.next.next.next = f;

        ll.display();
        ReverseLinkedList rl = new ReverseLinkedList(ll.head);

    }
}
