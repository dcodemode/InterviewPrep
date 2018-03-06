package learn.ds.linkedlist;

import learn.ds.nodes.SListNode;
import learn.ds.util.LinkedList;

/**
 * @author Varma Penmetsa
 * <p>
 * Write a function AlternatingSplit() that takes one list and divides up its nodes to make two smaller lists ‘a’ and ‘b’.
 * The sublists should be made from alternating elements in the original list.
 * So if the original list is 0->1->0->1->0->1 then one sublist should be 0->0->0 and the other should be 1->1->1.
 * <p>
 * https://www.geeksforgeeks.org/alternating-split-of-a-given-singly-linked-list/
 */

public class AlternatingSplit {

    /*
     * Time Complexity :
     * Space Complexity :
     */
    public static void AltSplit(SListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        SListNode curr = head;

        //Building List 1
        LinkedList l1 = new LinkedList();
        SListNode h1 = l1.head;
        while (curr != null && curr.next != null) {
            h1.next = curr;
            h1 = h1.next;
            curr = curr.next.next;
        }

        //Building list 2
        curr = head.next;
        LinkedList l2 = new LinkedList();
        SListNode h2 = l2.head;
        while (curr != null && curr.next != null) {
            h2.next = curr;
            h2 = h2.next;
            curr = curr.next.next;
        }
    }

    public static void main(String args[]){

    }
}
