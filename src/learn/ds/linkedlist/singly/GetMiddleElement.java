package learn.ds.linkedlist.singly;

/**
 * @author Varma Penmetsa
 */

import learn.ds.nodes.ListNode;
import learn.util.LinkedList;
import learn.util.RandLinkedListGenetator;

public class GetMiddleElement {

    /* Print middle element of a linked list, if even nodes print second then there would be two middle nodes,
   we need to print second middle element */
    public static ListNode getMiddleElement(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    /* Print middle element of a linked list, if even nodes print second then there would be two middle nodes,
    we need to print first middle element */
    public int getMiddleElement2(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
    }

    //Get middle element using length
    public int getMiddleElement3(LinkedList ll){
        ListNode node = ll.head;
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

        System.out.println(getMiddleElement(ll.head));
        System.out.println(gm.getMiddleElement2(ll.head));
        System.out.println(gm.getMiddleElement3(ll));
    }
}
