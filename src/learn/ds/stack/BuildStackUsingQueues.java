package learn.ds.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Build Stack Using Queues
 *
 * We are given a Queue data structure that supports standard operations like enqueue() and dequeue().
 * We need to implement a Stack data structure using only instances of Queue and queue operations allowed on the instances.
 *
 * https://www.geeksforgeeks.org/implement-stack-using-queue/
 */

public class BuildStackUsingQueues {

    Queue<String> q1 = new LinkedList<>();
    Queue<String> q2 = new LinkedList<>();

    //Time Complexity: O(1)
    public void push(String data){
        q1.add(data);
    }

    //Time Complexity: O(n)
    public void pop() {
        //Add all elements from q1 to q2 except last element, this element is the last element we need to pop this out;
        while (q1.size() > 1){
            q2.add(q1.remove());
        }
        Queue<String> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    //Time Complexity: O(1)
    public String peek() {
        return q2.peek();
    }

    public static void main(String[] args){

        BuildStackUsingQueues q = new BuildStackUsingQueues();

        q.push("S");
        q.push("T");
        q.push("A");
        q.push("C");
        q.push("K");

        q.pop();
        System.out.println(q.peek());
        q.pop();
        System.out.println(q.peek());
        q.pop();
        System.out.println(q.peek());
        q.pop();
        System.out.println(q.peek());
        q.pop();
        System.out.println(q.peek());
    }

}
