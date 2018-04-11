package learn.ds.linkedlist.singly;

import learn.ds.nodes.ListNode;
import learn.util.HelperLinkedList;
import learn.util.LinkedList;
import learn.util.RandLinkedListGenetator;

/**
 * @author Varma Penmetsa
 *
 * Given a singly linked list, write a function to swap elements pairwise.
 * For example, if the linked list is 1->2->3->4->5->6->7 then the function should change it to 2->1->4->3->6->5->7,
 * and if the linked list is 1->2->3->4->5->6 then the function should change it to 2->1->4->3->6->5
 *
 *
 * https://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list-by-changing-links/
 */
public class SwapPairs2 {

    public static ListNode pairWiseSwap(ListNode node){
        if (node == null || node.next == null) {
            return node;
        }

        ListNode remaing = node.next.next;

        ListNode newhead = node.next;

        newhead.next = node;

        node.next = pairWiseSwap(remaing);

        return newhead;
    }

    public static void main(String[] args){
        LinkedList ll = new RandLinkedListGenetator().create(5);

        ll.display();

        HelperLinkedList.display(pairWiseSwap(ll.head));
    }
}


