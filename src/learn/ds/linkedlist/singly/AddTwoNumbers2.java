package learn.ds.linkedlist.singly;

import learn.ds.nodes.ListNode;
import learn.ds.util.HelperLinkedList;
import learn.ds.util.LinkedList;

/**
 * @author Varma Penmetsa
 *
 * Given two numbers represented by two linked lists, write a function that returns sum list.
 * The sum list is linked list representation of addition of two input numbers.
 * It is not allowed to modify the lists. Also, not allowed to use explicit extra space
 *
 * Input:
 *    First List: 5->6->3  // represents number 563
 *    Second List: 8->4->2 //  represents number 842
 * Output:
 *    Resultant list: 1->4->0->5  // represents number 1405
 *
 * https://www.geeksforgeeks.org/sum-of-two-linked-lists/
 */
public class AddTwoNumbers2 {

    /*
     * Time Complexity: O(m+n)
     */
    public static ListNode addNumbers(ListNode a, ListNode b) {
        ListNode resultHead = new ListNode(-1);
        ListNode result = resultHead;
        int lenA = HelperLinkedList.length(a);
        int lenB = HelperLinkedList.length(b);

        if (lenA > lenB) {
            while (lenA != lenB) {
                result.next = new ListNode(a.data);
                result = result.next;
                a = a.next;
                lenA--;
            }
        }

        if (lenA < lenB) {
            while (lenA != lenB) {
                result.next = new ListNode(b.data);
                result = result.next;
                b = b.next;
                lenB--;
            }
        }

        // when length of both lists are equal
        int finalCarry = getSum(a, b);
        if (finalCarry > 0) {
            result.next = new ListNode(finalCarry);
            result.next.next = a;
        } else {
            result.next = a;
        }
        return resultHead.next;
    }

    /*
     * Recursively go to the last node linked list a & b and sum them up, if sum is > 10
     * change value in last node and return carry to previous node
     */
    public static int getSum(ListNode a, ListNode b) {
        if (a.next == null && b.next == null) {
            int sum = a.data + b.data;
            int carry = sum / 10;
            a.data = sum % 10;
            return carry;
        }
        int sum = a.data + b.data + getSum(a.next, b.next);
        int carry = sum / 10;
        a.data = sum % 10;
        return carry;
    }

    public static void main(String[] args) {
        LinkedList a = new LinkedList();
        a.append(5);
        a.append(3);
        a.append(3);
        a.append(0);

        LinkedList b = new LinkedList();
        b.append(5);
        b.append(0);
        b.append(0);

        a.display();
        b.display();

        HelperLinkedList.display(addNumbers(a.head, b.head));
    }

}
