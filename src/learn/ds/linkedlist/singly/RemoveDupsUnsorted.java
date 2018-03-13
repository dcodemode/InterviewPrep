package learn.ds.linkedlist.singly;

import learn.ds.nodes.ListNode;
import learn.ds.util.LinkedList;

import java.util.HashSet;

/**
 * @author Varma Penmetsa
 */
public class RemoveDupsUnsorted {

    /*
      Remove duplicates from a unsorted linked list using hashing
      Time Complexity: O(n)
      Space O(n) on average (assuming that hash table access time is O(1) on average).
     */
    public static void removeDups(ListNode head){
        HashSet<Integer> set = new HashSet<Integer>();
        ListNode curr = head;
        ListNode prev = null;

        while(curr!=null){
            if(set.contains(curr.data)){
                prev.next = curr.next;
            }else{
                prev = curr;
                set.add(curr.data);
            }
            curr=curr.next;
        }
    }

    public static void main(String args[]){
        LinkedList ll = new LinkedList(new ListNode(10));
        ListNode a = new ListNode(20);
        ListNode b = new ListNode(30);
        ListNode c = new ListNode(20);
        ListNode d = new ListNode(20);
        ListNode e = new ListNode(70);
        ListNode f = new ListNode(10);

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
