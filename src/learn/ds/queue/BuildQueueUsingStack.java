package learn.ds.queue;

import learn.ds.util.Stack;

/**
 * @author Varma Penmetsa
 *
 * https://www.geeksforgeeks.org/queue-using-stacks/
 */

public class BuildQueueUsingStack {

    Stack tStack  = new Stack(5);
    Stack qStack  = new Stack(5);

    public void enQueue(String val){
        tStack.push(val);
    }

    public String deQueue(){
        while(!tStack.isEmpty()){
            qStack.push(tStack.pop());
        }
        return qStack.pop();
    }

    public static void main(String[] args){
        BuildQueueUsingStack q = new BuildQueueUsingStack();
        q.enQueue("S");
        q.enQueue("T");
        q.enQueue("A");
        q.enQueue("C");
        q.enQueue("K");

        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
        System.out.println(q.deQueue());
    }
}
