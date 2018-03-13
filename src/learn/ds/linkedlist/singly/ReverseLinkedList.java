package learn.ds.linkedlist.singly;

/**
 * @author Varma Penmetsa
 */

import learn.ds.nodes.ListNode;
import learn.ds.util.LinkedList;
import learn.ds.util.RandLinkedListGenetator;

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

        ListNode prev = null;
        ListNode curr = ll.head;
        ListNode next = null;

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
    public void reverse2(ListNode prev, ListNode curr){
          if(curr.next == null){
              ll.head=curr;
              curr.next=prev;
              return;
          }
          reverse2(curr,curr.next);
          curr.next=prev;
    }


    public static void main(String args[]){
        LinkedList ll = new RandLinkedListGenetator().create(10);

        ll.display();
        ReverseLinkedList rl = new ReverseLinkedList(ll);
        rl.reverse();
        ll.display();
        rl.reverse2(null,ll.head);
        ll.display();

    }
}
