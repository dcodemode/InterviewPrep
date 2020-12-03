package learn.algo.random;

import learn.ds.nodes.ListNode;
import learn.util.LinkedList;
import learn.util.RandLinkedListGenetator;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
 *
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?
 *
 * Example:
 *
 * // Init a singly linked list [1,2,3].
 * ListNode head = new ListNode(1);
 * head.next = new ListNode(2);
 * head.next.next = new ListNode(3);
 * Solution solution = new Solution(head);
 *
 * // getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
 * solution.getRandom();
 *
 * https://leetcode.com/problems/linked-list-random-node/
 *
 *
 */
public class FindRandomNodeLinkedList {

    /**
     * Bruit Force approach -Not scalable
     *
     * Complexity Analysis:
     * ____________________
     *
     * Time Complexity:
     *
     * For the init(head) function, its time complexity is O(N) where
     * N is the number of elements in the linked list.
     *
     * For the getRandom() function, its time complexity is O(1).
     * The reason is two-fold: it takes a constant time to generate a random number
     * and the access to any element in the array is of constant time as well.
     *
     * Space Complexity:
     * O(N)
     *
     * The overall solution requires O(N) space complexity, since we make a copy of elements from the input list.
     */
//    List<Integer> list = new ArrayList<>();
//    public FindRandomNodeLinkedList(ListNode head){
//        while(head != null){
//            list.add(head.data);
//            head = head.next;
//        }
//    }
//
//    public int getRandom(){
//        int pick = (int)(Math.random() * list.size());
//        return list.get(pick);
//    }

    /**
     * Reservoir Sampling
     *
     * Time Complexity:
     * For the init(head) function, its time complexity is O(1).
     *
     * For the getRandom() function, its time complexity is O(N) is the number of elements in the input list.
     *
     * Space Complexity: O(1)
     * @param args
     */
    private ListNode head;
    public FindRandomNodeLinkedList(ListNode head){
        this.head = head;
    }

    public int getRandom(){
        int scope = 1, chosenVal = 0;
        ListNode curr = this.head;
        while (curr != null){
            // decide whether to include the element in reservoir
            if(Math.random() < 1.0 / scope){
                chosenVal = curr.data;
            }
            scope += 1;
            curr = curr.next;
        }
        return chosenVal;
    }

    public static void main(String[] args) {
        LinkedList ll = new RandLinkedListGenetator().create(15);
        ll.display();
        FindRandomNodeLinkedList frand = new FindRandomNodeLinkedList(ll.head);
        System.out.println(frand.getRandom());
    }
}
