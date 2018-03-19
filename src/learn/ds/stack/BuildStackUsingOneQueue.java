package learn.ds.stack;

import java.util.LinkedList;
import java.util.Queue;

public class BuildStackUsingOneQueue {

    Queue<String> q = new LinkedList<>();

    public void push(String data) {
        q.add(data);
        int size = q.size();
        while (size > 1) {
            q.add(q.remove());
            size--;
        }
    }

    public String pop() {
        return q.remove();
    }

    public static void main(String[] args) {

        BuildStackUsingOneQueue q = new BuildStackUsingOneQueue();

        q.push("S");
        q.push("T");
        q.push("A");
        q.push("C");
        q.push("K");

        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
    }
}
