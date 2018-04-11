package learn.util;

import learn.ds.nodes.ListNode;

import java.util.Random;

/**
 * @author Varma Penmetsa
 *
 */
public class RandomCircularLinkedList {

    public ListNode head;

    public RandomCircularLinkedList(){

    }

    public RandomCircularLinkedList(int data){
        this.head = new ListNode(data);
    }

    public LinkedList create(int size){
        LinkedList ll = new LinkedList();
        int i=0;

        while(i<size){
            ll.push(new Random().nextInt(9));
            i++;
        }

        ListNode tail = ll.head;
        while(tail.next!=null){
            tail=tail.next;
        }

        tail.next = ll.head;

        return ll;
    }

    public static void main(String args[]) {
        RandomCircularLinkedList cl = new RandomCircularLinkedList(10);
        //HelperLinkedList.displayCircularList(new RandomCircularLinkedList().create(6).head);
    }
}
