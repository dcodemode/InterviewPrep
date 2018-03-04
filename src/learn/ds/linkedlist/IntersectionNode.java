package learn.ds.linkedlist;

import learn.ds.nodes.SListNode;
import learn.ds.util.HelperLinkedList;

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
    public static SListNode findIntersection(SListNode l1, SListNode l2) {
        List<SListNode> list = new ArrayList<SListNode>();

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
    public static SListNode findIntersection2(SListNode l1, SListNode l2) {
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
    public static SListNode findIntersection3(SListNode l1, SListNode l2) {
        if(l1==null || l2==null){
             return null;
        }

        SListNode a = l1;
        SListNode b = l2;

        while( a != b){
            a = (a == null) ? l2 : a.next;
            b = (b == null) ? l1 : b.next;
        }
        return a;
    }
}
