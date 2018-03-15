package learn.ds.linkedlist.singly;

import learn.ds.nodes.ListNode;
import learn.ds.util.HelperLinkedList;
import learn.ds.util.LinkedList;
import learn.ds.util.RandLinkedListGenetator;

/**
 * @author Varma Penmetsa
 *
 * Given a singly linked list L0 -> L1 -> … -> Ln-1 -> Ln.
 * Rearrange the nodes in the list so that the new formed list is : L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2
 *
 * https://www.geeksforgeeks.org/rearrange-a-given-linked-list-in-place/
 */

public class RearrangeLinkedList {

    public static ListNode rearrange(ListNode head){
        if(head==null){
            return head;
        }

        ListNode curr = head;
        ListNode mid = getMidNode(head);
        ListNode secList = mid.next;
        mid.next = null;
        ListNode rev = reverse(secList);

        while(curr!=null && curr.next!=null){
            ListNode temp = curr.next;
            rev.next =  curr.next;
            curr.next = rev;
            rev = rev.next;
            curr = temp.next;
        }
        return head;
    }

    public static ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev,next;
        prev = next = null;

        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode getMidNode(ListNode head){
        if (head==null) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args){
        LinkedList ll = new RandLinkedListGenetator().create(6);
        ll.display();

        HelperLinkedList.display(rearrange(ll.head));

    }
}
