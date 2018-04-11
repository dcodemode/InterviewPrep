package learn.ds.linkedlist.singly;

import learn.ds.nodes.ListNode;
import learn.util.HelperLinkedList;
import learn.util.LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Varma Penmetsa
 *
 * Given two singly linked lists find intersecton node
 */
public class IntersectionNode {

    /*
      Mark two nodes.
      Time complexity : O(m+n)
      Space complexity : O(m)
     */
    public static ListNode findIntersection(ListNode l1, ListNode l2) {
        List<ListNode> list = new ArrayList<ListNode>();

        if (l1 == null || l2 == null) {
            return null;
        }

        while (l1 != null) {
            list.add(l1);
            l1 = l1.next;
        }

        while (l2 != null) {
            if (list.contains(l2)) {
                return l2;
            }
            l2 = l2.next;
        }

        return null;
    }

    /* Using difference of node counts.
       Time complexity : O(m+n)
       Space complexity : O(1)
    */
    public static ListNode findIntersection2(ListNode l1, ListNode l2) {
        int len1 = HelperLinkedList.length(l1);
        int len2 = HelperLinkedList.length(l2);

        while(len1 > len2) {
            l1=l1.next;
            len1--;
        }

        while (len1 < len2){
            l2=l2.next;
            len2--;
        }

        while(l1!=l2){
            l1=l1.next;
            l2=l2.next;
        }

     return l1;
    }

    /* Using ternary operator.
       Time complexity : O(n)
       Space complexity : O(1)
    */
    public static ListNode findIntersection3(ListNode l1, ListNode l2) {
        if(l1==null || l2==null){
             return null;
        }

        ListNode a = l1;
        ListNode b = l2;

        while( a != b){
            a = (a == null) ? l2 : a.next;
            b = (b == null) ? l1 : b.next;
        }
        return a;
    }
    public static void main(String args[]) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(6);
        ListNode f = new ListNode(8);

        LinkedList l1 = new LinkedList();
        l1.head = a;
        l1.head.next = b;
        l1.head.next.next = c;
        l1.head.next.next.next = d;
        l1.head.next.next.next.next = e;

        LinkedList l2 = new LinkedList();
        l2.head = b;
        l2.head.next = d;
        l2.head.next.next = e;
        l2.head.next.next.next = f;

        l1.display();
        l2.display();

        System.out.println(findIntersection(l1.head,l2.head).data);
        System.out.println(findIntersection2(l1.head,l2.head).data);
        System.out.println(findIntersection3(l1.head,l2.head).data);
    }

}
