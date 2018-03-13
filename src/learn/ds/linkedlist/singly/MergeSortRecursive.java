package learn.ds.linkedlist.singly;

import learn.ds.nodes.ListNode;
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
     * Time Complexity: O(n log n)
     * Space Complexity O(n)
     *
     */

    public static ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = middleElement(head);
        ListNode sec = mid.next;
        mid.next = null;

        ListNode left = mergeSort(head);
        ListNode right = mergeSort(sec);
        //Merge sorted linked lists
        return sortedMerge(left, right);
    }

    public static ListNode sortedMerge(ListNode a, ListNode b) {
        ListNode ret = null;

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

    public static ListNode middleElement(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;

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
