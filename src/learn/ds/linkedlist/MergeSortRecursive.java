package learn.ds.linkedlist;

import learn.ds.nodes.SListNode;
import learn.ds.util.HelperLinkedList;
import learn.ds.util.LinkedList;
import learn.ds.util.RandLinkedListGenetator;

/**
 * @author Varma Penmetsa
 *
 * https://www.geeksforgeeks.org/merge-sort-for-linked-list/
 */
public class MergeSortRecursive {

    /*
     * MergeSort
     * 1) If head is NULL or there is only one element in the Linked List then return.
     * 2) Else divide the linked list into two halves.
     * 3) Sort the two halves a and b.
     * 4) Merge the sorted a & b and update the head pointer using headRef.
     *
     */

    public static SListNode mergeSort(SListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        SListNode mid = middleElement(head);
        SListNode sec = mid.next;
        mid.next = null;

        SListNode left = mergeSort(head);
        SListNode right = mergeSort(sec);
        //Merge sorted linked lists
        return sortedMerge(left, right);
    }

    public static SListNode sortedMerge(SListNode a, SListNode b) {
        SListNode ret = null;

        if (a == null) {
            return b;
        }

        if (b == null) {
            return a;
        }

        if (a.data < b.data) {
            ret = a;
            ret.next = sortedMerge(a.next, b);
        } else {
            ret = b;
            ret.next = sortedMerge(a, b.next);
        }
        return ret;
    }

    public static SListNode middleElement(SListNode head) {
        if (head == null) return null;
        SListNode slow = head;
        SListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String args[]) {
        LinkedList ll = new RandLinkedListGenetator().create(7);
        ll.display();

        HelperLinkedList.display(mergeSort(ll.head));
    }
}
