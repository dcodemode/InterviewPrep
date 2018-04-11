package learn.ds.linkedlist.singly;

import learn.ds.nodes.ListNode;
import learn.util.HelperLinkedList;
import learn.util.LinkedList;

/**
 * @author Varma Penmetsa
 *
 * Given two numbers represented by two lists, write a function that returns sum list.
 * The sum list is list representation of addition of two input numbers.
 *
 * Input:
 *    First List: 5->6->3        // represents number 365
 *    Second List: 8->4->2       // represents number 248
 * Output:
 *    Resultant list: 3->1->6    // represents number 613
 *
 * Input:
 *    First List: 7->5->9->4->6  // 64957
 *    Second List: 8->4          // 48
 * Output
 *    Resultant list: 5->0->0->5->6  // 65005
 *
 * https://www.geeksforgeeks.org/add-two-numbers-represented-by-linked-lists/
 *
 */

public class AddTwoNumbers1 {

    /**
     * Time Complexity: O(n)
     * Space Complexity O(n)
     *
     */

    public static ListNode sum(ListNode l1, ListNode l2){
        if(l1==null && l2==null){
            return l1;
        }else if(l1!=null && l2==null){
            return l1;
        }else if(l1==null && l2!=null){
            return l2;
        }
        ListNode resHead = new ListNode(-1);
        ListNode res = resHead;
        int carry = 0;
        while(l1!=null && l2!=null){
            int sum = carry+l1.data+l2.data;
            carry =0;
            if(sum>=10){
                carry = 1;
                sum = sum%10;
            }
            res.next = new ListNode(sum);

            l1=l1.next;
            l2=l2.next;
            res= res.next;
        }

        if(l1==null && l2!=null){
            while(l2!=null){
                int sum = carry+l2.data;
                carry =0;
                if(sum>=10){
                    carry = 1;
                    sum = sum%10;
                }
                res.next = new ListNode(sum);
                l2=l2.next;
                res=res.next;
            }
        }

        if(l1!=null && l2==null){
            while(l1!=null){
                int sum = carry+l1.data;
                carry =0;
                if(sum>=10){
                    carry = 1;
                    sum = sum%10;
                }
                res.next = new ListNode(sum);
                l1=l1.next;
                res=res.next;
            }
        }
       if (carry==1){
            res.next = new ListNode(carry);
       }
       return resHead.next;
    }

    public static void main(String[] args){
        LinkedList l1 = new LinkedList();
        l1.append(1);
        l1.append(0);
        l1.append(0);
        l1.append(5);

        LinkedList l2 = new LinkedList();
        l2.append(9);
        l2.append(9);
        l2.append(4);

        HelperLinkedList.display(sum(l1.head,l2.head));
    }

}
