package learn.ds.linkedlist.singly;

/**
 * @author Varma Penmetsa
 */

import learn.ds.nodes.ListNode;
import learn.ds.util.LinkedList;

public class DeleteKey {

    LinkedList ll;

    public DeleteKey(LinkedList ll){
        this.ll=ll;
    }

    /* Given a ‘key’, delete the first occurrence of this key in linked list. */
    public void deleteKey(int new_data) {
        ListNode node = ll.head;
        ListNode prevNode = null;

        if (node != null && node.data == new_data) {
            ll.head = node.next;
            return;
        }

        while (node != null && node.data != new_data) {
            prevNode = node;
            node = node.next;
        }

        if (node == null) {
            System.out.println("Key not found.");
            return;
        }
        prevNode.next = node.next;
    }

    /* Deletes the node at the given node */
    public void deleteNode(ListNode node) {
        ListNode temp = ll.head;
        ListNode prev = null;

        if(temp == node){
            ll.head = temp.next;
            return;
        }
        while(temp != null && temp != node){
            prev = temp;
            temp=temp.next;
        }

        if (temp == null){
            System.out.println("Give node not found");
            return;
        }
        prev.next=temp.next;
    }

    /* Deletes the node at the given position */
    public void deleteAfterPosition(int position){
        ListNode node = ll.head;
        ListNode prev = null;

        if (position==0){
            ll.head = node.next;
            return;
        }

        int i=0;
        while(node!=null && i<=position-1){
            prev=node;
            node=node.next;
            i++;
        }

        if(node == null) return;
        prev.next=node.next;

    }


    public static void main(String args[]){
        LinkedList ll = new LinkedList(new ListNode(10));

        ListNode a = new ListNode(20);
        ListNode b = new ListNode(30);
        ListNode c = new ListNode(40);
        ListNode d = new ListNode(50);
        ListNode e = new ListNode(60);
        ListNode f = new ListNode(70);

        ll.head.next = a;
        ll.head.next.next = b;
        ll.head.next.next.next = c;
        ll.head.next.next.next.next = d;
        ll.head.next.next.next.next.next = e;
        ll.head.next.next.next.next.next.next = f;

        DeleteKey del  = new DeleteKey(ll);

        ll.display();
        del.deleteKey(20);
        del.deleteNode(a);
        del.deleteAfterPosition(1);
        ll.display();
    }
}
