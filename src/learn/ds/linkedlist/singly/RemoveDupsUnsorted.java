package learn.ds.linkedlist.singly;

import learn.ds.nodes.SListNode;
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
    public static void removeDups(SListNode head){
        HashSet<Integer> set = new HashSet<Integer>();
        SListNode curr = head;
        SListNode prev = null;

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
        LinkedList ll = new LinkedList(new SListNode(10));
        SListNode a = new SListNode(20);
        SListNode b = new SListNode(30);
        SListNode c = new SListNode(20);
        SListNode d = new SListNode(20);
        SListNode e = new SListNode(70);
        SListNode f = new SListNode(10);

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
