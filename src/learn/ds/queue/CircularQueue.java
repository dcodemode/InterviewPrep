package learn.ds.queue;

import java.util.Arrays;

/**
 * @author Varma Penmetsa
 *
 * https://www.geeksforgeeks.org/circular-queue-set-1-introduction-array-implementation/
 */
public class CircularQueue {

    private int[] array;
    private int head, tail, size, len;

    public CircularQueue(int capacity){
        array = new int[capacity];
        head = tail = -1;
        size = 0;
        len = capacity;
    }

    public void enqueue(int val){
        if(size < len){
            if(tail==-1){
                array[0] = val;
                head = tail = 0;
                size++;
            }else if(len == (tail+1)% len){
                return;
            }else {
                tail = (tail+1)% len;
                array[tail] = val;
                size++;
            }
        }else {
            System.out.println("Queue is full");
        }
    }

    public int dequeue(){
        if(size != 0){
            if(head == -1){
                return -1;
            }else if(head == tail){
                int ret = array[head];
                head = -1;
                tail = -1;
                size--;
                return ret;
            }else {
                head = (head + 1) % len;
                int ret = array[head];
                size--;
                return ret;
            }
        }else {
            System.out.println("Queue is empty");
            return -1;
        }
    }

    public int rear(){
        if(tail == -1){
            return -1;
        }else {
            return array[tail];
        }
    }

    public int front(){
        if(head == -1){
            return -1;
        }else {
            return array[head];
        }
    }


    public static void main(String args[]){

        CircularQueue q = new CircularQueue(3);

        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);

        q.dequeue();
        q.dequeue();

        q.enqueue(3);
        q.enqueue(2);


        System.out.println("Front "+ q.front());
        System.out.println("Rear "+ q.rear());
    }
}
