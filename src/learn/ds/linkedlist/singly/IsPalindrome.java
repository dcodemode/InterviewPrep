package learn.ds.linkedlist.singly;

import learn.ds.nodes.ListNode;
import learn.util.LinkedList;

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
    public static Boolean palindromeCheck(ListNode head){

        if(head==null){
            return false;
        }

        ListNode middle = getMiddle(head);
        ListNode end = reverse(middle);

        while(head!=null && end!=null){
            if(head.data==end.data){
                return true;
            }
            head=head.next;
            end=end.next;
        }
      return false;
    }

    public static ListNode getMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;

    }

    public static ListNode reverse(ListNode head){
        if(head==null){
            return null;
        }

        ListNode prev = null;
        ListNode curr  = head;
        ListNode next;

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
    public static boolean palindromeCheck2(ListNode node){
        //ToDo
        return false;
    }

    public static void main(String args[]){

        LinkedList ll = new LinkedList(new ListNode(10));

        ListNode a = new ListNode(20);
        ListNode b = new ListNode(30);
        ListNode c = new ListNode(40);
        ListNode d = new ListNode(30);
        ListNode e = new ListNode(20);
        ListNode f = new ListNode(10);

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
