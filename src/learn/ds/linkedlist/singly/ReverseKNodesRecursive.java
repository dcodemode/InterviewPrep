package learn.ds.linkedlist.singly;

import learn.ds.nodes.ListNode;
import learn.util.HelperLinkedList;
import learn.util.LinkedList;
import learn.util.RandLinkedListGenetator;

/**
 * @author Varma Penmetsa
 * <p>
 * Given a linked list, write a function to reverse every k nodes (where k is an input to the function).
 * <p>
 * Example:
 * Inputs:  1->2->3->4->5->6->7->8->NULL and k = 3
 * Output:  3->2->1->6->5->4->8->7->NULL.
 * <p>
 * Inputs:   1->2->3->4->5->6->7->8->NULL and k = 5
 * Output:  5->4->3->2->1->8->7->6->NULL.
 * <p>
 * https://www.geeksforgeeks.org/reverse-a-list-in-groups-of-given-size/
 */
public class ReverseKNodesRecursive {

    //Time Complexity: O(n)
    public static ListNode reverse(ListNode head, int k) {
        if (isValidSection(head, k) == false)
            return head;
        int i = 0;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;

        while (curr != null && i < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            i++;
        }

        if (next != null) {
            head.next = reverse(next, k);
        }
        return prev;
    }

    public static boolean isValidSection(ListNode node, int k) {
        if (node == null)
            return false;
        ListNode cur = node;
        while (cur != null && k > 0) {
            cur = cur.next;
            k--;
        }
        return k <= 0;
    }

    public static void main(String args[]){
        LinkedList ll = new RandLinkedListGenetator().create(8);
        ll.display();

        HelperLinkedList.display(reverse(ll.head,3));
    }
}
