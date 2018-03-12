package learn.ds.linkedlist.singly;

/**
 * @author Varma Penmetsa
 */

import learn.ds.nodes.SListNode;
import learn.ds.util.LinkedList;
import learn.ds.util.RandLinkedListGenetator;

public class GetMiddleElement {

    /* Print middle element of a linked list, if even nodes print second then there would be two middle nodes,
   we need to print second middle element */
    public static SListNode getMiddleElement(SListNode head){
        SListNode slow = head;
        SListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    /* Print middle element of a linked list, if even nodes print second then there would be two middle nodes,
    we need to print first middle element */
    public int getMiddleElement2(SListNode head){
        SListNode slow = head;
        SListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
    }

    //Get middle element using length
    public int getMiddleElement3(LinkedList ll){
        SListNode node = ll.head;
        if(node == null) return 0;
        for(int i=0;i<ll.length()/2;i++){
            node=node.next;
        }
        return node.data;
    }

    public static void main(String args[]) {
        LinkedList ll = new RandLinkedListGenetator().create(10);
        ll.display();

        GetMiddleElement gm = new GetMiddleElement();

        System.out.println(gm.getMiddleElement(ll.head));
        System.out.println(gm.getMiddleElement2(ll.head));
        System.out.println(gm.getMiddleElement3(ll));
    }
}
