package learn.ds.linkedlist.singly;

import learn.ds.nodes.ListNode;
import learn.util.LinkedList;
import learn.util.RandLinkedListGenetator;

/**
 * @author Varma Penmetsa
 * <p>
 * Write a function altSplit() that takes one list and divides up its nodes to make two smaller lists ‘a’ and ‘b’.
 * The sublists should be made from alternating elements in the original list.
 * So if the original list is 0->1->0->1->0->1 then one sublist should be 0->0->0 and the other should be 1->1->1.
 * <p>
 * https://www.geeksforgeeks.org/alternating-split-of-a-given-singly-linked-list/
 */

public class AlternatingSplit {

    /*
     * Time Complexity : O(n)
     */
    public static void altSplit(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode curr = head;
        LinkedList a = new LinkedList();
        LinkedList b = new LinkedList();

        while (curr != null) {
            a.append(curr.data);
            if (curr.next != null) {
                b.append(curr.next.data);
                curr = curr.next.next;
            }else{
                curr=null;
            }
        }
        a.display();
        b.display();
    }

    public static void main(String args[]) {

        LinkedList ll = new RandLinkedListGenetator().create(5);
        ll.display();
        altSplit(ll.head);

    }
}
