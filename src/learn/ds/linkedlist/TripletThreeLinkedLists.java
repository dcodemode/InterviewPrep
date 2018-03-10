package learn.ds.linkedlist;

import learn.ds.nodes.SListNode;
import learn.ds.util.HelperLinkedList;
import learn.ds.util.LinkedList;
import learn.ds.util.RandLinkedListGenetator;

/**
 * @author Varma Penmetsa
 *
 * Given three linked lists, say a, b and c, find one node from each list such that the sum of the values of the nodes is equal to a given number.
 * Input:
 *   L1: 12->6->29
 *   L2: 23->5->8
 *   L3: 90->20->59
 *   Given number : 101,
 * Output:
 *   Tripel : 6->5->90.
 *
 * https://www.geeksforgeeks.org/find-a-triplet-from-three-linked-lists-with-sum-equal-to-a-given-number/
 */
public class TripletThreeLinkedLists {

    /**
     *
     * 1) Sort list b in ascending order, and list c in descending order.
     * 2) After the b and c are sorted, one by one pick an element from list a and find the pair by traversing both b and c.
     *
     * Time complexity: O(n*n)
     *
     * The linked lists b and c can be sorted in O(nLogn) time using Merge Sort.
     * The step 2 takes O(n*n) time. So the overall time complexity is O(nlogn) + O(nlogn) + O(n*n) = O(n*n).
     */

    public static SListNode getTriplet(SListNode l1, SListNode l2, SListNode l3,int num){
        SListNode ret = null;
        //Sorting l2 & l3;
        SListNode newL2 = mergeSort(l2,"asc");
        SListNode newL3 = mergeSort(l3,"desc");
        SListNode nL2 = newL2;
        SListNode nL3 = newL3;
        HelperLinkedList.display(newL2);
        HelperLinkedList.display(newL3);

        while (l1!=null){
            newL2 = nL2;
            newL3 = nL3;
            while(newL2!=null && newL3!=null) {
                int sum = l1.data + newL2.data + newL3.data;
                if (sum == num) {
                    ret = l1;
                    ret.next = newL2;
                    ret.next.next = newL3;
                    return ret;
                }else if(sum<num){
                    newL2=newL2.next;
                }else {
                    newL3 = newL3.next;
                }
            }
            l1=l1.next;
        }
        return  ret;
    }

    public static SListNode mergeSort(SListNode head, String order){
        if (head==null || head.next==null) return head;

        SListNode mid = middleElement(head);
        SListNode midNext = mid.next;
        mid.next = null;

        SListNode left = mergeSort(head,order);
        SListNode right = mergeSort(midNext,order);

        return mergeSorted(left,right,order);
    }

    public static SListNode mergeSorted(SListNode a, SListNode b,String order){
        SListNode ret = null;
        if (a==null)
            return b;

        if (b==null)
            return a;

        if (order == "asc"){
            if (a.data < b.data){
                ret = a;
                ret.next=mergeSorted(a.next,b,order);
            }else{
                ret = b;
                ret.next=mergeSorted(a,b.next,order);
            }
        }else{
            if (a.data > b.data){
                ret = a;
                ret.next=mergeSorted(a.next,b,order);
            }else{
                ret = b;
                ret.next=mergeSorted(a,b.next,order);
            }
        }
        return ret;
    }

    public static SListNode middleElement(SListNode head){
        if(head==null) return head;
        SListNode slow = head;
        SListNode fast = head;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args){
        LinkedList l1 = new RandLinkedListGenetator().create(3);
        LinkedList l2 = new RandLinkedListGenetator().create(3);
        LinkedList l3 = new RandLinkedListGenetator().create(3);

        l1.display();

        HelperLinkedList.display(getTriplet(l1.head,l2.head,l3.head,10));

    }
}
