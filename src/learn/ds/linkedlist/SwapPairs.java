package learn.ds.linkedlist;

import learn.ds.nodes.SListNode;
import learn.ds.util.RandLinkedListGenetator;

/**
 * @author Varma Penmetsa
 *
 * Given a linked list, swap every two adjacent nodes and return its head.
 * For example, given 1->2->3->4, you should return the list as 2->1->4->3.
 * Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.
 *
 */
public class SwapPairs {

    // This method chages data in the pointers
    public static void swap3(SListNode head) {
        int i = 0;
        SListNode curr = head;
        SListNode prev = null;

        while (curr != null) {
            if (i == 1) {
                int temp = prev.data;
                prev.data = curr.data;
                curr.data = temp;
                i = 0;
            } else {
                prev = curr;
                i++;
            }
            curr = curr.next;
        }

    }

    public static int swap2(SListNode head) {
       if(head==null){
           return 0;
       }
       int count = 1 + swap2(head.next);
       if(count%2==0){
           int temp = head.data;
           head.data=head.next.data;
           head.next.data=temp;
       }
       return count;
    }

    public static void swap(SListNode head){
       SListNode prev = null;
       SListNode curr = head;

       while(curr!=null){

       }
    }

    public static void main(String args[]) {
        RandLinkedListGenetator rg = new RandLinkedListGenetator();
        LinkedList ll = rg.create(7);
        ll.display();
        swap2(ll.head);
        ll.display();

    }


}
