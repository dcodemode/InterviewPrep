package learn.ds.linkedlist;

import learn.ds.nodes.SListNode;

/**
 * @author Varma Penmetsa
 */
public class SwapNode {

    LinkedList ll;

    public SwapNode(LinkedList ll){
        this.ll=ll;
    }

    public void swap(SListNode x, SListNode y) {

        //Search prev of node x
        SListNode currX = ll.head;
        SListNode prevX = null;

        if (currX == null) return;
        while (currX != null && currX != x) {
            prevX = currX;
            currX = currX.next;
        }
        if (currX == null) return;

        //Search prev of node Y
        SListNode currY = ll.head;
        SListNode prevY = null;

        if (currY == null) return;
        while (currY != null && currY != y) {
            prevY = currY;
            currY = currY.next;
        }
        if (currY == null) return;

        //If x is head
        if(prevX == null){
            SListNode temp = currX.next;
            currX.next = currY.next;
            currY.next = temp;

            prevY.next=currX;
            ll.head=currY;
            return;
        }

        //If Y is head
        if(prevY == null){
            SListNode temp = currY.next;
            currY.next = currX.next;
            currX.next = temp;

            prevX.next=currY;
            ll.head=currX;
            return;
        }

        //Swapping nodes
        SListNode temp = currX.next;
        currX.next = currY.next;
        currY.next= temp;

        prevX.next=currY;
        prevY.next=currX;

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

        SwapNode sn = new SwapNode(ll);
        sn.swap(ll.head,c);
        ll.display();

    }
}
