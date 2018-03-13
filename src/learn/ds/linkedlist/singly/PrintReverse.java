package learn.ds.linkedlist.singly;

import learn.ds.nodes.ListNode;
import learn.ds.util.LinkedList;
import learn.ds.util.RandLinkedListGenetator;

/**
 * @author Varma Penmetsa
 */
public class PrintReverse {

    /*
     Recursive function to print reverse of a linked list
     */
    public static void printRev(ListNode head){
        if(head==null){
            return;
        }
        printRev(head.next);
        System.out.print(head.data + " --> ");
    }

    public static void main(String args[]){
        LinkedList ll = new RandLinkedListGenetator().create(5);

        ll.display();
        printRev(ll.head);
    }
}
