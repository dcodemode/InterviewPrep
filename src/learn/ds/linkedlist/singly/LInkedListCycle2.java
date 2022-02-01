package learn.ds.linkedlist.singly;

import learn.ds.nodes.ListNode;

/**
    Given the head of a linked list, return the node where the cycle begins. If there is no cycle, return null.

    There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to (0-indexed). It is -1 if there is no cycle. Note that pos is not passed as a parameter.

    Do not modify the linked list.

    Example 1:

    Input: head = [3,2,0,-4], pos = 1
    Output: tail connects to node index 1
    Explanation: There is a cycle in the linked list, where tail connects to the second node.
    
    Example 2:

    Input: head = [1,2], pos = 0
    Output: tail connects to node index 0
    Explanation: There is a cycle in the linked list, where tail connects to the first node.
    Example 3:

    Input: head = [1], pos = -1
    Output: no cycle
    Explanation: There is no cycle in the linked list.

    Constraints:

    The number of the nodes in the list is in the range [0, 104].
    -105 <= Node.val <= 105
    pos is -1 or a valid index in the linked-list.

    https://leetcode.com/problems/linked-list-cycle-ii/
 */
public class LInkedListCycle2 {
    

    /**
     * Intuition
     * What happens when a fast runner (a hare) races a slow runner (a tortoise) on a circular track? At some point,
     * the fast runner will catch up to the slow runner from behind.
     * Algorithm
     * 
     * Floyd's algorithm is separated into two distinct phases. In the first phase, it determines whether a cycle is present in the list. 
     * If no cycle is present, it returns null immediately, as it is impossible to find the entrance to a nonexistant cycle. 
     * Otherwise, it uses the located "intersection node" to find the entrance to the cycle.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        
        ListNode node = checkForLoop(head);
        
        if(node == null){
            return node;
        }
        
        ListNode slow = head;
        ListNode fast = node;
        
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
    
    public ListNode checkForLoop(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
            if(slow == fast){
                return slow;
            }
        }
        return null;
    }
}
