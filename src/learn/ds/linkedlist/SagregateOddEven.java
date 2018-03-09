package learn.ds.linkedlist;

import learn.ds.nodes.SListNode;
import learn.ds.util.HelperLinkedList;
import learn.ds.util.LinkedList;
import learn.ds.util.RandLinkedListGenetator;

/**
 * @author Varma Penmetsa
 * <p>
 * write a function to modify the linked list such that all even numbers appear before all the odd numbers.
 * Also, keep the order of even and odd numbers same.
 * <p>
 * Examples:
 * Q: 17->15->8->12->10->5->4->1->7->6->NULL
 * A  8->12->10->4->6->17->15->5->1->7->NULL
 * <p>
 * Q: 8->12->10->5->4->1->6->NULL
 * A: 8->12->10->4->6->5->1->NULL
 * <p>
 * https://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/
 */

public class SagregateOddEven {


    public static SListNode sagregate(SListNode head) {
        //ToDo
        return head;
    }

    public static void main(String args[]) {

        LinkedList ll = new RandLinkedListGenetator().create(7);
        ll.display();
        HelperLinkedList.display(sagregate(ll.head));
    }
}
