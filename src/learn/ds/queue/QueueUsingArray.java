package learn.ds.queue;

import java.util.Arrays;

/**
 * @author Varma Penmetsa
 *
 * https://www.geeksforgeeks.org/queue-set-1introduction-and-array-implementation/
 *
 * This is a basic implementaion, will not work for multiple push and pops, as circular array implementation is not used
 */
public class QueueUsingArray {

    int[] queueArray;
    int top, front;

    public QueueUsingArray(int size){
        queueArray = new int[size];
        top = front = 0;
    }

    public void enqueue(int val){
        if(top >= queueArray.length){
            System.out.println("Queue is full");
            return;
        }
        queueArray[top++] = val;
    }

    public int dequeue(){
        if(front < queueArray.length){
            int ret = queueArray[front];
            queueArray[front] = -1;
            front++;
            return ret;
        }else {
            System.out.println("Queue is empty");
            return -1;
        }
    }

    public int front(){
        if(front < queueArray.length){
            return queueArray[front];
        }else{
            return -1;
        }
    }

    public int rear(){
        if(front < queueArray.length){
            return queueArray[queueArray.length-1];
        }else{
            return -1;
        }
    }

    public boolean isEmpty(){
        if(front < queueArray.length){
            return false;
        }else{
            return true;
        }
    }

    public static void main(String[] args) {
        QueueUsingArray q = new QueueUsingArray(5);

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);

        q.dequeue();
        q.dequeue();
        q.dequeue();

        System.out.println(q.front());
        System.out.println(q.rear());

        System.out.println(q.isEmpty());

        System.out.println(Arrays.toString(q.queueArray));

    }
}
