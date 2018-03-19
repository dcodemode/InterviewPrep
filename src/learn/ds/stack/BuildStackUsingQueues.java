package learn.ds.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Build Stack Using Queues
 */

public class BuildStackUsingQueues {

    Queue<String> q1 = new LinkedList<>();
    Queue<String> q2 = new LinkedList<>();

    public void push(String data){
        q1.add(data);
    }

    public void pop() {
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
