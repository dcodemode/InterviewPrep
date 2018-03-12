package learn.ds.linkedlist.singly;

/**
 * @author Varma Penmetsa
 */

import learn.ds.nodes.SListNode;
import learn.ds.util.LinkedList;
import learn.ds.util.RandLinkedListGenetator;

public class GetNthElementFromLast {

    LinkedList ll;

    public GetNthElementFromLast(LinkedList ll){
        this.ll=ll;
    }

    /*
     Print nth node from end of linked list
    */
    public int getNthFromLast(int position){
        SListNode node = ll.head;
        int i= 1;
        while(node!=null && i<ll.length()-position){
            i++;
            node=node.next;
        }
        return node.data;
    }

    /*
      Print nth node from end of linked list two pointer approach
     */
    public int getNthFromLast2(int position){
        if (ll.head==null) return 0;
        SListNode slow = ll.head;
        SListNode fast = ll.head;
        for(int i=0;i<position;i++){
            fast=fast.next;
        }
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow.data;
    }

    public static void main(String args[]) {
        LinkedList ll = new RandLinkedListGenetator().create(10);

        ll.display();

        GetNthElementFromLast gn = new GetNthElementFromLast(ll);

        System.out.println(gn.getNthFromLast(0));
        System.out.println(gn.getNthFromLast(1));
        System.out.println(gn.getNthFromLast2(2));

    }
}
