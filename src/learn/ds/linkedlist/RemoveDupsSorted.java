package learn.ds.linkedlist;

import learn.ds.nodes.SListNode;

/**
 * @author Varma Penmetsa
 */
public class RemoveDupsSorted {

    /*
      Remove duplicate from a sorted linked list
      Time complexity : O(n)
      Space complexity : O(1)
     */
    public static void removeDups(SListNode head){
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
