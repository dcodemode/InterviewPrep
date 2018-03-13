package learn.ds.linkedlist.singly;

import learn.ds.nodes.ListNode;
import learn.ds.util.LinkedList;

/**
 * @author Varma Penmetsa
 */
public class RemoveDupsSorted {

    /*
      Remove duplicate from a sorted linked list
      Time complexity : O(n)
      Space complexity : O(1)
     */
    public static void removeDups(ListNode head){
        if(head==null){
           return;
        }

        while(head!=null && head.next!=null){
            if(head.data == head.next.data){
                head.next=head.next.next;
            }else {
                head = head.next;
            }
        }
    }

    public static void main(String args[]){
        LinkedList ll = new LinkedList(new ListNode(10));
        ListNode a = new ListNode(20);
        ListNode b = new ListNode(20);
        ListNode c = new ListNode(20);
        ListNode d = new ListNode(20);
        ListNode e = new ListNode(60);
        ListNode f = new ListNode(70);

        ll.head.next = a;
        ll.head.next.next = b;
        ll.head.next.next.next = c;
        ll.head.next.next.next.next = d;
        ll.head.next.next.next.next.next = e;
        ll.head.next.next.next.next.next.next = f;

        ll.display();
        removeDups(ll.head);
        ll.display();

    }
}
