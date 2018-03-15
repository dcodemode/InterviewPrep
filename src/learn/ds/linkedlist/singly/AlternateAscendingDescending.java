package learn.ds.linkedlist.singly;


import learn.ds.nodes.ListNode;
import learn.ds.util.HelperLinkedList;
import learn.ds.util.LinkedList;
import learn.ds.util.RandLinkedListGenetator;

/**
 * @author Varma Penmetsa
 *
 * Given a Linked List. The Linked List is in alternating ascending and descending orders. Sort the list efficiently.
 *
 * Input List:   10->40->53->30->67->12->89->NULL
 * Output List:  10->12->30->43->53->67->89->NULL
 *
 * https://www.geeksforgeeks.org/how-to-sort-a-linked-list-that-is-sorted-alternating-ascending-and-descending-orders/
 */

public class AlternateAscendingDescending {

    public static ListNode sort(ListNode head){
        if(head == null && head.next == null){
            return head;
        }
        ListNode a = head;
        ListNode headA = a;
        ListNode b = head.next;
        ListNode headB = b;

        while (a != null && b!=null) {
            if (a.next != null) {
                a.next = a.next.next;
                a = a.next;
            }
            if (b.next != null) {
                b.next = b.next.next;
                b = b.next;
            }
        }

        ListNode revB = reverse(headB);

        HelperLinkedList.display(headA);
        HelperLinkedList.display(revB);


        return merge(headA,revB);
    }

    public static ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev, next;
        prev = next = null;
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static ListNode merge(ListNode a , ListNode b){
        ListNode res = null;
        if(a==null){
            return b;
        }
        if (b==null){
            return a;
        }

        if(a.data < b.data){
            res = a;
            res.next = merge(a.next,b);
        }else{
            res = b;
            res.next = merge(a,b.next);
        }
        return res;
    }

    public static void main(String[] args){

        LinkedList ll = new LinkedList();
        ll.push(8);
        ll.push(89);
        ll.push(12);
        ll.push(67);
        ll.push(30);
        ll.push(53);
        ll.push(40);
        ll.push(10);

        ll.display();

        HelperLinkedList.display(sort(ll.head));

    }
}
