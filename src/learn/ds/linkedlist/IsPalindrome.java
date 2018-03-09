package learn.ds.linkedlist;

import learn.ds.nodes.SListNode;
import learn.ds.util.LinkedList;

/**
 * @author Varma Penmetsa
 */
public class IsPalindrome {

    /*
       Check if give linked list is palindrome, using stacks
         1. Find middle element
         2. Reverse list
         3. Compare elements
     */
    public static Boolean palindromeCheck(SListNode head){

        if(head==null){
            return false;
        }

        SListNode middle = getMiddle(head);
        SListNode end = reverse(middle);

        while(head!=null && end!=null){
            if(head.data==end.data){
                return true;
            }
            head=head.next;
            end=end.next;
        }
      return false;
    }

    public static SListNode getMiddle(SListNode head){
        SListNode slow = head;
        SListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;

    }

    public static SListNode reverse(SListNode head){
        if(head==null){
            return null;
        }

        SListNode prev = null;
        SListNode curr  = head;
        SListNode next;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }

    /*
      Check if give linked list is palindrome using recursion
     */
    public static boolean palindromeCheck2(SListNode node){
        //ToDo
        return false;
    }

    public static void main(String args[]){

        LinkedList ll = new LinkedList(new SListNode(10));

        SListNode a = new SListNode(20);
        SListNode b = new SListNode(30);
        SListNode c = new SListNode(40);
        SListNode d = new SListNode(30);
        SListNode e = new SListNode(20);
        SListNode f = new SListNode(10);

        ll.head.next = a;
        ll.head.next.next = b;
        ll.head.next.next.next = c;
        ll.head.next.next.next.next = d;
        ll.head.next.next.next.next.next = e;
        //ll.head.next.next.next.next.next.next = f;

        ll.display();
        System.out.println(palindromeCheck(ll.head));

    }
}
