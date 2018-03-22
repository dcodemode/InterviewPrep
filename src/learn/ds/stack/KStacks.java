package learn.ds.stack;

import java.util.Arrays;

/**
 * @author Varma Penmetsa
 *
 * https://www.byte-by-byte.com/nstacks/
 */
public class KStacks {

    int[] topOfStack;
    int[] stackArray;

    int[] availIndex;
    int nextAvail = 0;

    KStacks(int k, int n){
        topOfStack = new int[k];
        stackArray = new int[n];
        availIndex = new int[n];

        Arrays.fill(stackArray, 0);
        Arrays.fill(topOfStack, -1);
        int len = availIndex.length;
        for (int i = 0; i < len; i++) {
            availIndex[i] = i+1;
        }
        availIndex[len-1] = -1;
    }

    public void push(int k, int val){
        if(nextAvail==-1){
            System.out.println("Stack is full");
            return;
        }
        stackArray[nextAvail] = val;
        int prevTopOfStack = topOfStack[k];
        topOfStack[k] = nextAvail;
        int prevAvailIndex = availIndex[nextAvail];
        availIndex[nextAvail] = prevTopOfStack;
        nextAvail = prevAvailIndex;
    }


    public Integer pop(int k){
        if(topOfStack[k] == -1){
            System.out.println("Nothing to pop");
            return topOfStack[k];
        }
        int ret = stackArray[topOfStack[k]];
        int prevTopStack = topOfStack[k];
        int prevAvailIndex = availIndex[topOfStack[k]];
        availIndex[topOfStack[k]]= nextAvail;
        topOfStack[k] = prevAvailIndex;
        nextAvail = prevTopStack;
        return ret;
    }

    public static void main(String[] args) {
        KStacks ks = new KStacks(3,6);
        ks.push(0,5);
        ks.push(0,9);
        ks.push(1,5);
        ks.push(1,7);
        ks.pop(0);
        ks.push(0,11);
        ks.push(2,1);

        System.out.println("topOfStack: "+Arrays.toString(ks.topOfStack));
        System.out.println("stackArray: "+Arrays.toString(ks.stackArray));
        System.out.println("AvailIndex: "+Arrays.toString(ks.availIndex));
        System.out.println("nextAvail: "+ks.nextAvail);
    }
}
