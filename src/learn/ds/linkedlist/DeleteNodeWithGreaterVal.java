package learn.ds.linkedlist;

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
 * https://www.geeksforgeeks.org/delete-nodes-which-have-a-greater-value-on-right-side/
 */
public class DeleteNodeWithGreaterVal {

    public static SListNode delLesserNodes(SListNode head) {
        SListNode dummy = new SListNode(Integer.MAX_VALUE);
        dummy.next = head;

        SListNode prev = dummy;
        SListNode curr = dummy.next;

        while (curr != null && curr.next!=null) {
            if (curr.data < curr.next.data) {
                prev.next = curr.next;
            }
            prev = curr;
            curr = curr.next;
        }
        return dummy.next;
    }

    public static void main(String args[]){
//        LinkedList ll = new RandLinkedListGenetator().create(5);
        SListNode a = new SListNode(12);
        SListNode b = new SListNode(15);
        SListNode c = new SListNode(10);
        SListNode d = new SListNode(11);
        SListNode e = new SListNode(5);
        SListNode f = new SListNode(6);
        SListNode g = new SListNode(2);
        SListNode h = new SListNode(3);

        LinkedList l1 = new LinkedList();
        l1.head = a;
        l1.head.next = b;
        l1.head.next.next = c;
        l1.head.next.next.next = d;
        l1.head.next.next.next.next = e;
        l1.head.next.next.next.next.next = f;
        l1.head.next.next.next.next.next.next = g;
        l1.head.next.next.next.next.next.next.next = h;

        l1.display();

        HelperLinkedList.display(delLesserNodes(l1.head));
    }
}
