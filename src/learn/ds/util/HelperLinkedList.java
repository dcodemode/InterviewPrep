package learn.ds.util;

import learn.ds.nodes.SListNode;

/**
 * @author Varma Penmetsa
 *
 * Until method for singley linked list
 */
public class HelperLinkedList {

    public static int length(SListNode head){
        int i=0;
        while(head!=null){
            i++;
            head=head.next;
        }
        return i;
    }

    public static void display(SListNode head){
        SListNode curr = head;
        while(curr!=null){
            System.out.print(curr.data+" --> ");
            curr=curr.next;
        }
        System.out.println("null");
    }
}
