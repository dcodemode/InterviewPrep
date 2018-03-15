package learn.ds.linkedlist.singly;

import learn.ds.nodes.ListNode;
import learn.ds.util.HelperLinkedList;
import learn.ds.util.LinkedList;

/**
 * @author Varma Penmetsa
 *
 * https://www.geeksforgeeks.org/merge-two-sorted-linked-lists-such-that-merged-list-is-in-reverse-order/
 */
public class MergeSortedLinkedListReverseOrder {

    public static ListNode merge(ListNode a, ListNode b) {
        ListNode res = null;

        if (a == null && b == null) {
            return a;
        } else if (a != null && b == null) {
            return a;
        } else if (a == null && b != null) {
            return b;
        }

        while (a != null && b != null) {
            if (a.data < b.data) {
                ListNode temp = a.next;
                a.next = res;
                res = a;
                a = temp;
            } else {
                ListNode temp = b.next;
                b.next = res;
                res = b;
                b = temp;
            }
        }

        while (a != null) {
            ListNode temp = a.next;
            a.next = res;
            res = a;
            a = temp;
        }

        while (b != null) {
            ListNode temp = b.next;
            b.next = res;
            res = b;
            b = temp;
        }

        return res;
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList(10);
        list1.append(30);
        list1.append(50);
        list1.append(70);

        LinkedList list2 = new LinkedList(0);
        list2.append(20);
        list2.append(40);
        list2.append(60);

        list1.display();
        list2.display();

        HelperLinkedList.display(merge(list1.head, list2.head));
    }
}
