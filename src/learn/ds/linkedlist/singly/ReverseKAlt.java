package learn.ds.linkedlist.singly;

import learn.ds.nodes.ListNode;
import learn.util.HelperLinkedList;
import learn.util.LinkedList;
import learn.util.RandLinkedListGenetator;

/**
 * @author Varma Penmetsa
 * <p>
 * Given a linked list, write a function to reverse every alternate k nodes (where k is an input to the function) in an efficient way.
 * Give the complexity of your algorithm.
 * <p>
 * Example:
 * Inputs:   1->2->3->4->5->6->7->8->9->NULL and k = 3
 * Output:   3->2->1->4->5->6->9->8->7->NULL.
 * <p>
 * https://www.geeksforgeeks.org/reverse-alternate-k-nodes-in-a-singly-linked-list/
 */
public class ReverseKAlt {

    /*
     * Recursive approach
     * Reverse first k nodes.
     * In the modified list head points to the kth node.  So change next
     * of head to (k+1)th node
     * Move the current pointer to skip next k nodes.
     * Call the kAltReverse() recursively for rest of the n - 2k nodes.
     * Return new head of the list.
     */

    public static ListNode reverse(ListNode head, int k) {
        if (isValid(head, k) == false) {
            return head;
        }
        int i = 0;

        ListNode prev, next;
        ListNode curr = head;
        prev = next = null;

        while (curr != null && i < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }

        /* Now head points to the kth node.  So change next
         of head to (k+1)th node*/
        if (head != null) {
            head.next = curr;
        }

        /* We do not want to reverse next k nodes. So move the current
         pointer to skip next k nodes */
        i = 0;
        while (curr != null && i < k - 1) {
            curr = curr.next;
            i++;
        }

        /* Recursively call for the list starting from current->next.
         And make rest of the list as next of first node */
        if (curr != null) {
            curr.next = reverse(curr.next, k);
        }
        return prev;

    }

    public static boolean isValid(ListNode head, int k) {
        if (head == null) return false;
        while (head != null && k-1 > 0) {
            head = head.next;
            k--;
        }
        return head != null;
    }

    public static void main(String args[]) {
        LinkedList ll = new RandLinkedListGenetator().create(11);
        ll.display();

        HelperLinkedList.display(reverse(ll.head, 3));
    }


}
