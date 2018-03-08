package learn.ds.linkedlist;

import learn.ds.nodes.SListNode;
import learn.ds.util.HelperLinkedList;
import learn.ds.util.LinkedList;
import learn.ds.util.RandLinkedListGenetator;

/**
 * @author Varma Penmetsa
 * <p>
 * Given a linked list, write a function to reverse every k nodes (where k is an input to the function).
 * <p>
 * Example:
 * Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3
 * Output:  3->2->1->6->5->4->8->7->NULL.
 * <p>
 * Inputs:   1->2->3->4->5->6->7->8->NULL and k = 5
 * Output:  5->4->3->2->1->8->7->6->NULL.
 * <p>
 * https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
 */
public class ReverseKNodesRecursive {

    //Time Complexity: O(n)
    public static SListNode reverse(SListNode head, int k) {
        int i = 0;
        SListNode prev = null;
        SListNode curr = head;
        SListNode next = null;

        while (curr != null && i < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }

        if (next != null) {
            head.next = reverse(next, k);
        }
        return prev;
    }

    public static void main(String args[]){
        LinkedList ll = new RandLinkedListGenetator().create(7);
        ll.display();

        HelperLinkedList.display(reverse(ll.head,3));
    }
}
