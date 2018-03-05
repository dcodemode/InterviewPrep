package learn.ds.linkedlist;
/*
 *@author Varma Penmetsa
 *Function that moves last element to front in a given Singly Linked List.
 *For example, if the given Linked List is 1->2->3->4->5, then the function should change the list to 5->1->2->3->4
 */

import learn.ds.nodes.SListNode;
import learn.ds.util.RandLinkedListGenetator;

public class LastToFirst {

    public static void moveToFront(LinkedList ll){
        SListNode head = ll.head;
        if(head==null ){
            return;
        }
        SListNode prev = null;
        SListNode curr = head;
        while(curr.next!=null){
            prev = curr;
            curr=curr.next;
        }
        curr.next = head;
        ll.head = curr;
        prev.next = null;

    }

    public static void main(String args[]) {
        RandLinkedListGenetator rg = new RandLinkedListGenetator();
        LinkedList ll = rg.create(7);
        ll.display();
        moveToFront(ll);
        ll.display();
    }
}
