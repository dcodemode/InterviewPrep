package learn.ds.linkedlist;

/**
 * @author Varma Penmetsa
 */

import learn.ds.nodes.SListNode;

public class ReverseLinkedList {

    LinkedList ll;

    public ReverseLinkedList(LinkedList ll){
        this.ll = ll;
    }

    /*  Reverse nodes of a linked list */
    public void reverse(){
        SListNode curr = ll.head;
        SListNode prev = null;

        if (curr==null) return;

        while(curr.next!=null){
            prev=curr;
            curr=curr.next;
        }
        SListNode temp = curr;
        curr.next=ll.head;
        prev.next=null;
        ll.head= curr;

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
        ReverseLinkedList rl = new ReverseLinkedList(ll);
        rl.reverse();
        ll.display();

    }
}
