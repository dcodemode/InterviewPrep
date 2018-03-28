package learn.ds.queue;

import java.util.Arrays;

/**
 * @author Varma Penmetsa
 * <p>
 * https://www.geeksforgeeks.org/circular-queue-set-1-introduction-array-implementation/
 */
public class CircularQueue<T> {

    private int QUEUE_LENGTH;
    private T data[] = null;

    public CircularQueue(int size){
        this.QUEUE_LENGTH = size;
        data = (T[]) new Object[QUEUE_LENGTH];
    }
    private int top=-1;
    private int end = -1;

    public void offer(T t){
        if(top == -1){
            data[0] = t;
            top =0;
            end = 0;
        }else if(top == (end + 1) % QUEUE_LENGTH){
            throw new IllegalArgumentException();
        }else{
            end = (end + 1) % QUEUE_LENGTH;
            data[end] = t;
        }
    }

    public T top(){
        if(top == -1){
            throw new IllegalArgumentException();
        }else{
            return data[top];
        }
    }

    public T rear(){
        if(top == -1){
            throw new IllegalArgumentException();
        }else{
            return data[end];
        }
    }

    public T poll(){
        if(top == -1){
            throw new IllegalArgumentException();
        }else if(top == end){
            T t =  data[top];
            top = -1;
            end = -1;
            return t;
        }
        else{
            T t =  data[top];
            top = (top +1)% QUEUE_LENGTH;
            return t;
        }

    }

    public boolean isEmpty(){
        if(top == -1){
            return true;
        }
        return false;
    }

    public boolean isFull(){
        if(top == (end + 1)% QUEUE_LENGTH){
            return true;
        }
        return false;
    }

    public static void main(String args[]){
        CircularQueue<Integer> circularQueue = new CircularQueue<Integer>(5);

        circularQueue.offer(1);
        circularQueue.offer(2);
        circularQueue.offer(3);

        circularQueue.poll();
        circularQueue.poll();
        circularQueue.poll();

        circularQueue.offer(3);
        circularQueue.offer(2);

        circularQueue.poll();

        System.out.println("Top " +circularQueue.top());
        System.out.println("Rear " +circularQueue.rear());


        System.out.println(Arrays.toString(circularQueue.data));


    }
}
