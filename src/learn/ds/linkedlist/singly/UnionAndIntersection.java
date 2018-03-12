package learn.ds.linkedlist.singly;

import learn.ds.nodes.SListNode;
import learn.ds.util.HelperLinkedList;
import learn.ds.util.LinkedList;

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
        //ToDo
        return null;
    }

    public static SListNode union(SListNode l1, SListNode l2){
        //ToDo
          return null;
    }

    public static void main(String[] args){
        LinkedList ll = new LinkedList(new SListNode(1));
        ll.push(10);
        ll.push(15);
        ll.push(4);
        ll.push(20);

        LinkedList l2 = new LinkedList();
        l2.push(8);
        l2.push(4);
        l2.push(2);
        l2.push(10);

        ll.display();
        l2.display();

        HelperLinkedList.display(intersection(ll.head,l2.head));
        HelperLinkedList.display(union(ll.head,l2.head));
    }
}
