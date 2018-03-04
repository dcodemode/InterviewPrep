package learn.ds.linkedlist;

import learn.ds.nodes.SListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Varma Penmetsa
 */
public class RemoveDupsUnsorted {

    /*
      Remove duplicates from a unsorted linked list
     */
    public static void removeDups(SListNode head){
//        Set<Integer> set = new HashSet<>();
//        SListNode curr = head;
//        while(curr!=null){
//            set.add(curr.data);
//        }
//        curr = head;
//        while(curr!=null && curr.next!=null){
//            if(set.contains(curr.data)){
//                set.remove(curr.data);
//                curr=curr.next;
//            }else {
//                curr.next=curr.next.next;
//            }
//        }
    }

    public static void main(String args[]){
        LinkedList ll = new LinkedList(new SListNode(10));
        SListNode a = new SListNode(20);
        SListNode b = new SListNode(20);
        SListNode c = new SListNode(20);
        SListNode d = new SListNode(20);
        SListNode e = new SListNode(60);
        SListNode f = new SListNode(70);

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
