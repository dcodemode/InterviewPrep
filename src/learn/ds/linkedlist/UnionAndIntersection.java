package learn.ds.linkedlist;

import learn.ds.nodes.SListNode;
import learn.ds.util.HelperLinkedList;
import learn.ds.util.LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Varma Penmetsa
 *
 *  Create union and intersection lists that contain union & intersection of the elements present in the given lists.
 *  Order of elments in output lists doesn’t matter.
 *
 *  Input:
 *     List1: 10->15->4->20
 *     List2:  8->4->2->10
 *  Output:
 *     Intersection List: 4->10
 *     Union List: 2->8->20->4->15->10
 *
 * https://www.geeksforgeeks.org/union-and-intersection-of-two-linked-lists/
 *
 */
public class UnionAndIntersection {

    /**
     *
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     */

    public static SListNode intersection(SListNode l1, SListNode l2){
        Set<Integer> set = new HashSet<Integer>();
        SListNode curr = l1;
        SListNode ret = new SListNode(-1);

        SListNode retHead = ret;

        while(curr!=null){
            set.add(curr.data);
            curr=curr.next;
        }

        curr = l2;
        while(curr!=null){
            if(set.contains(curr.data)){
                ret.next = curr;
                ret=ret.next;
            }
            curr=curr.next;
        }
        return retHead.next;
    }

    public static void union(SListNode l1, SListNode l2){

    }

    public static void main(String[] args){
        LinkedList ll = new LinkedList(new SListNode(10));
        ll.push(5);
        ll.push(4);
        ll.push(3);
        ll.push(2);
        ll.push(1);

        LinkedList l2 = new LinkedList();
        l2.push(1);
        l2.push(4);
        l2.push(5);
        l2.push(0);
        l2.push(11);

        HelperLinkedList.display(intersection(ll.head,l2.head));
        //HelperLinkedList.display(union(ll.head,l2.head));
    }
}
