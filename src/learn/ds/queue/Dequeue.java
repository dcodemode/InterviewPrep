package learn.ds.queue;

/**
 * @author Varma Penmetsa
 *
 * https://www.geeksforgeeks.org/implementation-deque-using-circular-array/
 *
 * Implement Double ended queue using circular array
 *
 */

public class Dequeue {

    int[] array;
    int head, tail, size, len;

    public Dequeue(int capacity){
        this.array = new int[capacity];
        head = tail = -1;
        size = 0;
        len = capacity;
    }

    public boolean isEmpty(){
        if(size == 0){
            return true;
        }else {
            return false;
        }
    }

    public boolean isFull(){
        if(head >= len){
            return true;
        }else {
            return false;
        }
    }

    public void insetFront(int val) {}

    public void insertRear(int val) {}

    public void deleteFront(){}

    public void deleteRear(){}

    public void getFront(){}

    public void getRear(){}


}
