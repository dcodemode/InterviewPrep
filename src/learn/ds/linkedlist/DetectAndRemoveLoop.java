package learn.ds.linkedlist;

import learn.ds.nodes.SListNode;
import learn.ds.util.HelperLinkedList;
import learn.ds.util.LinkedList;

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

    public static void removeLoop(SListNode head) {
        if (head == null || head.next == null)
            return;

        SListNode slow = head.next;
        SListNode fast = head.next.next;

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
        LinkedList ll = new LinkedList(new SListNode(10));

        SListNode a = new SListNode(20);
        SListNode b = new SListNode(30);
        SListNode c = new SListNode(40);
        SListNode d = new SListNode(50);
        SListNode e = new SListNode(60);
        SListNode f = new SListNode(70);

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
