package learn.ds.linkedlist.singly;

import learn.ds.nodes.ListNode;
import learn.util.LinkedList;

/**
 * @author Varma Penmetsa
 *
 * Given two lists sorted in increasing order, create and return a new list representing the intersection of the two lists.
 * The new list should be made with its own memory — the original lists should not be changed.
 *
 * For example, let the first linked list be 1->2->3->4->6 and second linked list be 2->4->6->8,
 * then your function should create and return a third list as 2->4->6.
 *
 * https://www.geeksforgeeks.org/intersection-of-two-sorted-linked-lists/
 */

public class SortedLinkedListIntersection {

    /*
     * Time Complexity: O(m+n)
     * Space Complexity: O(1)
     */

    public static LinkedList sortedIntersection(LinkedList l1, LinkedList l2) {
        LinkedList l3 = new LinkedList(new ListNode(0));

        ListNode h1 = l1.head;
        ListNode h2 = l2.head;

        while (h1 != null && h2 != null) {
            if (h1.data > h2.data) {
                h2 = h2.next;
            } else if (h1.data < h2.data) {
                h1 = h1.next;
            } else {
                l3.append(h1.data);
                h1 = h1.next;
                h2 = h2.next;
            }
        }
        l3.head = l3.head.next;
        return l3;
    }

    public static void main(String[] args) {
        LinkedList l1 = new LinkedList();
        l1.append(2);
        l1.append(4);
        l1.append(6);
        l1.append(7);

        LinkedList l2 = new LinkedList();
        l2.append(2);
        l2.append(3);
        l2.append(6);

        l1.display();
        l2.display();

        LinkedList l3 = sortedIntersection(l1, l2);
        l3.display();

    }

}
