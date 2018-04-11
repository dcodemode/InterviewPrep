package learn.ds.linkedlist.singly;

import learn.ds.nodes.ListNode;
import learn.util.LinkedList;
import learn.util.RandLinkedListGenetator;

/**
 * @author Varma Penmetsa
 *
 * Given a linked list, swap every two adjacent nodes(Key is to swap values instead of nodes)
 * For example, given 1->2->3->4, you should return the list as 2->1->4->3.
 *
 */
public class SwapPairs {

    /*
     * Swap node using iteration
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    public static void swap1(ListNode head) {
        int i = 0;
        ListNode curr = head;
        ListNode prev = null;

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

    /*
     * Swap node using recursion
     * Time complexity : O(n)
     * Space complexity : O(1)
     */
    public static void swap2(ListNode head) {
       if(head==null || head.next ==null){
           return;
       }
       int temp = head.data;
       head.data=head.next.data;
       head.next.data=temp;
       swap2(head.next.next);
       return;
    }

    public static void main(String args[]) {
        LinkedList ll = new RandLinkedListGenetator().create(7);
        ll.display();
        swap2(ll.head);
        ll.display();
    }
}
