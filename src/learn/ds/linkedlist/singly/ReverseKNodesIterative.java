package learn.ds.linkedlist.singly;

import learn.ds.nodes.ListNode;
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

public class ReverseKNodesIterative {

    /**
     * Reverse a link list between begin and end exclusively
     * an example:
     * a linked list:
     * 0->1->2->3->4->5->6
     * |           |
     * begin       end
     * after call begin = reverse(begin, end)
     * <p>
     * 0->3->2->1->4->5->6
     * |  |
     * begin end
     *
     * @return the reversed list's 'begin' node, which is the precedence of node end
     */

    public static ListNode revK(ListNode head, int k) {
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode first = dummyHead;

        int i = 0;
        while (head != null) {
            i++;
            if (i % k == 0) {
                first = reverseBetween(first, head.next);
                head = first.next;
            } else {
                head = head.next;
            }
        }
        return dummyHead.next;
    }

    //Reverse between two nodes
    public static ListNode reverseBetween(ListNode start, ListNode end) {
        ListNode prev = start;
        ListNode curr = start.next;
        ListNode next;

        ListNode first = curr;
        while (curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        start.next = prev;
        first.next = curr;
        return first;
    }

    public static void main(String args[]) {
        LinkedList ll = new RandLinkedListGenetator().create(7);
        ll.display();

        HelperLinkedList.display(revK(ll.head, 3));

    }
}
