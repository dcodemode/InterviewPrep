package learn.ds.stack;

/**
 * @author Varma Penmetsa
 *
 * https://www.geeksforgeeks.org/implement-two-stacks-in-an-array/
 */
public class TwoStackUsingOneArray {
    String[] stackArray;
    int top1 = 0;
    int top2,head2;

    public TwoStackUsingOneArray(int size){
        stackArray = new String[size];
        top2 = size;
        head2 = size;
    }

    public void push1(String val) {
        if (top1 < top2) {
            stackArray[top1++] = val;
        } else {
            System.out.println("Stack Overflow");
        }
    }

    public void push2(String val){
        if (top1 < top2) {
            stackArray[--top2] = val;
        } else {
            System.out.println("Stack Overflow");
        }
    }

    public String pop1(){
        if(top1 > 0){
            String ret = stackArray[--top1];
            stackArray[top1] = null;
            return ret;
        }else {
            System.out.println("Stack Underflow");
            return "";
        }
    }

    public String pop2(){
        if(top2 > 0){
            String ret = stackArray[--head2];
            stackArray[head2] = null;
            return ret;
        }else {
            System.out.println("Stack Underflow");
            return "";
        }
    }


    public static void main(String args[]){
        TwoStackUsingOneArray st = new TwoStackUsingOneArray(10);

        st.push2("K");
        st.push2("C");
        st.push2("A");
        st.push2("T");
        st.push2("S");

        st.push1("S");
        st.push1("T");
        st.push1("A");
        st.push1("C");
        st.push1("K");
        st.push1("K");

        System.out.println(st.pop1());
        System.out.println(st.pop1());
        System.out.println(st.pop1());
        System.out.println(st.pop1());
        System.out.println(st.pop1());
        System.out.println(st.pop1());

        System.out.println(st.pop2());
        System.out.println(st.pop2());
        System.out.println(st.pop2());
        System.out.println(st.pop2());
        System.out.println(st.pop2());

    }
}
