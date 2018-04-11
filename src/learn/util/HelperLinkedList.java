package learn.util;

import learn.ds.nodes.ListNode;

/**
 * @author Varma Penmetsa
 *
 * Until method for singley linked list
 */
public class HelperLinkedList {

    public static int length(ListNode head){
        int i=0;
        while(head!=null){
            i++;
            head=head.next;
        }
        return i;
    }

    public static void display(ListNode head){
        ListNode curr = head;
        while(curr!=null){
            System.out.print(curr.data+" --> ");
            curr=curr.next;
        }
        System.out.println("null");
    }
}
