package learn.ds.linkedlist;

import learn.ds.nodes.SListNode;
import learn.ds.util.LinkedList;

/**
 * @author Varma Penmetsa
 * <p>
 * Two Linked Lists are identical when they have same data and arrangement of data is also same.
 * For example Linked lists a (1->2->3) and b(1->2->3) are identical.
 * Write a function to check if the given two linked lists are identical.
 * <p>
 * https://www.geeksforgeeks.org/identical-linked-lists/
 */
public class IdenticalLists {

    /*
     * Time Complexity : O(n)
     * Space Complexity: O(1)
     */
    public static boolean compareLists(SListNode a, SListNode b) {
        if (a == null && b == null) {
            return true;
        }

        if (a == null || b == null) {
            return false;
        }

        while (a != null && b != null) {
            if (a.data != b.data) {
                return false;
            }
            a = a.next;
            b = b.next;
        }

        if (a == null && b == null){
            return true;
        }
        return false;
    }

    /*
     * Time Complexity : O(n)
     * Space Complexity: O(1)
     */
    public static boolean compareLists2(SListNode a, SListNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a != null && b != null) {
            return compareLists2(a.next, b.next);
        }
        if (a == null && b == null) {
            return true;
        }
        return false;
    }

    public static void main(String args[]) {

        LinkedList a = new LinkedList();
        a.append(1);
        a.append(2);
        a.append(3);
        a.append(6);

        LinkedList b = new LinkedList();
        b.append(1);
        b.append(2);
        b.append(3);

        System.out.println(compareLists(a.head, b.head));
        System.out.println(compareLists2(a.head, b.head));
    }
}
