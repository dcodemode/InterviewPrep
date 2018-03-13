package learn.ds.linkedlist.singly;

import learn.ds.nodes.ListNode;
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

    /**
     * Create even & odd linked lists separately and finally add them
     * Time Complexity: O(n)
     */

    public static ListNode sagregate(ListNode head) {
        ListNode curr = head;
        ListNode evenStart = new ListNode(-1);
        ListNode evenEnd = null;
        ListNode oddStart = new ListNode(-1);
        ListNode oddEnd = null;
        ListNode evenHead = evenStart;
        ListNode oddHead = oddStart;

        while (curr != null) {
            if (curr.data % 2 == 0) {
                evenStart.next = curr;
                evenEnd = evenStart.next;
                evenStart = evenStart.next;
            } else {
                oddStart.next = curr;
                oddEnd = oddStart.next;
                oddStart = oddStart.next;
            }
            curr = curr.next;
        }

        if (evenEnd == null) {
            return oddHead.next;
        }

        if (oddEnd == null) {
            return evenHead.next;
        }

        oddEnd.next = null;
        evenEnd.next = oddHead.next;
        return evenHead.next;
    }

    public static void main(String args[]) {

        LinkedList ll = new RandLinkedListGenetator().create(9);
        ll.display();

        HelperLinkedList.display(sagregate(ll.head));
    }
}
