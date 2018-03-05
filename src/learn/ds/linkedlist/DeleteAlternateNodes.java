package learn.ds.linkedlist;

import learn.ds.nodes.SListNode;
import learn.ds.util.LinkedList;
import learn.ds.util.RandLinkedListGenetator;

/**
 * @author Varma Penmetsa
 *
 * Given a Singly Linked List, starting from the second node delete all alternate nodes of it.
 * For example, if the given linked list is 1->2->3->4->5 then your function should convert it to 1->3->5,
 * and if the given linked list is 1->2->3->4 then convert it to 1->3.
 *
 * https://www.geeksforgeeks.org/delete-alternate-nodes-of-a-linked-list/
 *
 */

public class DeleteAlternateNodes {

    /*
     * Iterative Solution
     * Time Complexity : O(n)
     * Space Complexity : O(1)
     */
    public static void delAltNodes(SListNode head){
        if (head==null || head.next==null) return ;
        SListNode curr = head;
        while(curr!=null && curr.next!=null){
               curr.next = curr.next.next;
               curr=curr.next;
        }
    }

    public static void main(String args[]){
        LinkedList ll  = new RandLinkedListGenetator().create(7);
        ll.display();
        delAltNodes(ll.head);
        ll.display();
    }

}
