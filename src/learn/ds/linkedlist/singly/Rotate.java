package learn.ds.linkedlist.singly;

import learn.ds.nodes.ListNode;
import learn.ds.util.HelperLinkedList;
import learn.ds.util.LinkedList;
import learn.ds.util.RandLinkedListGenetator;

/**
 * @author Varma Penmetsa
 * <p>
 * Given a singly linked list, rotate the linked list counter-clockwise by k nodes. Where k is a given positive integer
 * Assume that k is smaller than the count of nodes in linked list.
 * <p>
 * Input :
 * 10->20->30->40->50->60
 * k : 4
 * Output:
 * 50->60->10->20->30->40
 * <p>
 * https://www.geeksforgeeks.org/rotate-a-linked-list/
 */
public class Rotate {

    //Iterative
    public static ListNode rev(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        int i = 0;
        ListNode curr = head;
        ListNode prev, next;
        prev = next = null;

        while (curr != null && i < k) {
            i++;
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        head.next = curr;
        return prev;
    }

    public static void main(String[] args) {
        LinkedList ll = new RandLinkedListGenetator().create(8);
        ll.display();
        HelperLinkedList.display(rev(ll.head, 3));
    }
}
