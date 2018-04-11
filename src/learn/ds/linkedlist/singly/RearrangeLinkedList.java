package learn.ds.linkedlist.singly;

import learn.ds.nodes.ListNode;
import learn.util.HelperLinkedList;
import learn.util.LinkedList;
import learn.util.RandLinkedListGenetator;

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

        ListNode mid = getMidNode(head);
        ListNode secH = mid.next;
        mid.next = null;
        ListNode secHead = reverse(secH);

        ListNode dummy = new ListNode(-1);
        ListNode ret = dummy;

        HelperLinkedList.display(head);
        HelperLinkedList.display(secHead);

        while(head!=null || secHead !=null){
            if(head!=null){
                dummy.next = head;
                dummy = dummy.next;
                head = head.next;
            }
            if(secHead!=null){
                dummy.next = secHead;
                dummy = dummy.next;
                secHead = secHead.next;
            }
        }

        return ret.next;
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
        LinkedList ll = new RandLinkedListGenetator().create(5);
        ll.display();

        HelperLinkedList.display(rearrange(ll.head));

    }
}
