package learn.ds.linkedlist.singly;

import learn.ds.nodes.ListNode;
import learn.util.HelperLinkedList;
import learn.util.LinkedList;

/**
 * @author Varma Penmetsa
 * <p>
 * write a function detectAndRemoveLoop() that checks whether a given Linked List contains loop and
 * if loop is present then removes the loop and returns true.
 * And if the list doesn’t contain loop then returns false. Below diagram shows a linked list with a loop.
 * detectAndRemoveLoop() must change the below list to 1->2->3->4->5->NULL.
 * <p>
 * https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
 */

public class DetectAndRemoveLoop {

    public static void removeLoop(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode slow = head.next;
        ListNode fast = head.next.next;

        while (fast != null && fast.next!= null) {
            if (slow == fast)
                break;
            slow = slow.next;
            fast = fast.next.next;
        }
        // After detecting the loop, if we start slow pointer from head and move both slow and fast pointers at same speed
        // until fast don’t meet, they would meet at the beginning of the loop.
        if (slow == fast) {
            slow = head;
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;
        }
    }

    public static void main(String args[]) {
        LinkedList ll = new LinkedList(new ListNode(10));

        ListNode a = new ListNode(20);
        ListNode b = new ListNode(30);
        ListNode c = new ListNode(40);
        ListNode d = new ListNode(50);
        ListNode e = new ListNode(60);
        ListNode f = new ListNode(70);

        ll.head.next = a;
        ll.head.next.next = b;
        ll.head.next.next.next = c;
        ll.head.next.next.next.next = d;
        ll.head.next.next.next.next.next = e;
        ll.head.next.next.next.next.next.next = f;
        f.next = c;

        removeLoop(ll.head);
        HelperLinkedList.display(ll.head);
    }
}
