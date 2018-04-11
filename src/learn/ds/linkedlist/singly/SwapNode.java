package learn.ds.linkedlist.singly;

import learn.ds.nodes.ListNode;
import learn.util.LinkedList;
import learn.util.RandLinkedListGenetator;

/**
 * @author Varma Penmetsa
 */
public class SwapNode {

    LinkedList ll;

    public SwapNode(LinkedList ll){
        this.ll=ll;
    }

    public void swap(ListNode x, ListNode y) {

        //Search prev of node x
        ListNode currX = ll.head;
        ListNode prevX = null;

        if (currX == null) return;
        while (currX != null && currX != x) {
            prevX = currX;
            currX = currX.next;
        }
        if (currX == null) return;

        //Search prev of node Y
        ListNode currY = ll.head;
        ListNode prevY = null;

        if (currY == null) return;
        while (currY != null && currY != y) {
            prevY = currY;
            currY = currY.next;
        }
        if (currY == null) return;

        //If x is head
        if(prevX == null){
            ListNode temp = currX.next;
            currX.next = currY.next;
            currY.next = temp;

            prevY.next=currX;
            ll.head=currY;
            return;
        }

        //If Y is head
        if(prevY == null){
            ListNode temp = currY.next;
            currY.next = currX.next;
            currX.next = temp;

            prevX.next=currY;
            ll.head=currX;
            return;
        }

        //Swapping nodes
        ListNode temp = currX.next;
        currX.next = currY.next;
        currY.next= temp;

        prevX.next=currY;
        prevY.next=currX;

    }

    public static void main(String args[]){
        LinkedList ll = new RandLinkedListGenetator().create(7);
        ll.display();

        SwapNode sn = new SwapNode(ll);
        sn.swap(ll.head,ll.getNode(3));
        ll.display();

    }
}
