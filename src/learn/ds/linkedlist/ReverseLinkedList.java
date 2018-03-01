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

    /*  Reverse nodes of a linked list iterative approach
    *   10 --> 20 --> 30 --> null
    *   Step1:
    *   10 --> null, 20 --> 30 --> null
    *   Step2:
    *   20 --> 10 --> null, 30 --> null
    *   Step3:
    *   30 --> 20 --> 10 --> null, null
    *   Step4:
    *   Set head = 30
    * */

    public void reverse(){

        SListNode prev = null;
        SListNode curr = ll.head;
        SListNode next = null;

        if (curr==null) return;

        while (curr != null) {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        ll.head=prev;

    }

    /*
      Reverse a linked list in recursive approach
     */
    public void reverse2(SListNode prev,SListNode curr){
          if(curr.next == null){
              ll.head=curr;
              curr.next=prev;
              return;
          }
          reverse2(curr,curr.next);
          curr.next=prev;
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
        rl.reverse2(null,ll.head);
        ll.display();

    }
}
