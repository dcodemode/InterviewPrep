package learn.ds.linkedlist;

/**
 * @author Varma Penmetsa
 */

import learn.ds.nodes.SListNode;
import learn.ds.util.RandLinkedListGenetator;

public class GetMiddleElement {

    LinkedList ll;

    public GetMiddleElement(LinkedList ll){
        this.ll=ll;
    }

    /* Print middle element of a linked list, if even nodes print second then there would be two middle nodes,
   we need to print second middle element */
    public int getMiddleElement(){
        SListNode slow = ll.head;
        SListNode fast = ll.head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
    }

    /* Print middle element of a linked list, if even nodes print second then there would be two middle nodes,
    we need to print first middle element */
    public int getMiddleElement2(){
        SListNode slow = ll.head;
        SListNode fast = ll.head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow.data;
    }

    //Get middle element
    public int getMiddleElement3(){
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

        GetMiddleElement gm = new GetMiddleElement(ll);

        System.out.println(gm.getMiddleElement());
        System.out.println(gm.getMiddleElement2());
        System.out.println(gm.getMiddleElement3());
    }
}
