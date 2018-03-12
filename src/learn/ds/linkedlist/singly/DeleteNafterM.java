package learn.ds.linkedlist.singly;

import learn.ds.nodes.SListNode;
import learn.ds.util.HelperLinkedList;
import learn.ds.util.LinkedList;
import learn.ds.util.RandLinkedListGenetator;

/**
 * @author Varma Penmetsa
 *
 * Delete N nodes after M nodes in a linked list.
 *
 */
public class DeleteNafterM {

    public static SListNode delete(SListNode head, int n, int m) {
        if (head == null) {
            return head;
        }
        int len = HelperLinkedList.length(head);

        int i = 0;

        if (m == 0) {
            while (head.next != null && i < n) {
                head = head.next;
                i++;
            }
            return head;
        }

        if (len < m) {
            return head;
        }

        SListNode curr = head;

        while (curr != null && i < m - 1) {
            i++;
            curr = curr.next;
        }

        SListNode prev = curr;
        i = 0;
        while (curr.next != null && i < n) {
            i++;
            curr = curr.next;
        }

        prev.next = curr.next;

        return head;
    }

    public static void main(String[] args) {
        LinkedList ll = new RandLinkedListGenetator().create(7);
        ll.display();

        HelperLinkedList.display(delete(ll.head, 2, 2));

    }


}
