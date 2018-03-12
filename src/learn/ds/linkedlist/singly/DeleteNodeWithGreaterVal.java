package learn.ds.linkedlist.singly;

import learn.ds.nodes.SListNode;
import learn.ds.util.HelperLinkedList;
import learn.ds.util.LinkedList;
import learn.ds.util.RandLinkedListGenetator;

/**
 * @author Varma Penmetsa
 * <p>
 * Given a singly linked list, remove all the nodes which have a greater value on right side.
 * <p>
 * Example:
 * Q: 12->15->10->11->5->6->2->3->NULL
 * A: 15->11->6->3->NULL
 * <p>
 * Q: 10->20->30->40->50->60->NULL
 * A: 60->NULL
 * https://www.geeksforgeeks.org/delete-nodes-which-have-a-greater-value-on-right-side/
 */
public class DeleteNodeWithGreaterVal {

    public static SListNode delLesserNodes(SListNode head) {
        SListNode dummy = new SListNode(Integer.MAX_VALUE);
        dummy.next = head;

        SListNode prev = dummy;
        SListNode curr = dummy.next;

        while (curr != null && curr.next != null) {
            if (curr.data < curr.next.data) {
                prev.next = curr.next;
            } else {
                prev = curr;
            }
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String args[]) {
        LinkedList ll = new RandLinkedListGenetator().create(5);
        ll.display();

        HelperLinkedList.display(delLesserNodes(ll.head));
    }
}
