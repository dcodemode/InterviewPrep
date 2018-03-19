package learn.ds.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Build Stack Using Queues
 */

public class BuildStackUsingQueues {

    Queue<String> q1 = new LinkedList<>();
    Queue<String> q2 = new LinkedList<>();

    public void enqueue(String data){
        q1.add(data);
    }

    public void dequeue() {
        while (q1.size() > 1){
            q2.add(q1.remove());
        }
        Queue<String> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    public String peek() {
        return q2.peek();
    }

    public static void main(String[] args){

        BuildStackUsingQueues q = new BuildStackUsingQueues();

        q.enqueue("S");
        q.enqueue("T");
        q.enqueue("A");
        q.enqueue("C");
        q.enqueue("K");

        q.dequeue();
        System.out.println(q.peek());
        q.dequeue();
        System.out.println(q.peek());
        q.dequeue();
        System.out.println(q.peek());
        q.dequeue();
        System.out.println(q.peek());
        q.dequeue();
        System.out.println(q.peek());
    }

}
