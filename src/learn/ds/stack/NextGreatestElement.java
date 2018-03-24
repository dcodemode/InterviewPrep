package learn.ds.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Varma Penmetsa
 *
 * https://www.geeksforgeeks.org/next-greater-element/
 */
public class NextGreatestElement {

    public static List<Integer> getNGE(int[] array) {
        List<Integer> list = new ArrayList<>();
        if (array.length == 0) {
            return list;
        }

        Stack<Integer> st = new Stack<>();
        st.push(array[0]);

        for (int i = 1; i < array.length; i++) {
            int prev = st.pop();
            int curr = array[i];

            while (prev < curr) {
                list.add(curr);
                System.out.println(prev+"-->"+curr);
                if(st.isEmpty()){
                    break;
                }
                prev = st.pop();
            }

            if(prev > curr){
                st.push(prev);
            }

            st.push(curr);
        }

        while(!st.isEmpty()){
            int prev = st.pop();
            System.out.println(prev+"--> -1");
            list.add(-1);
        }
        return list;
    }

    public static void main(String[] args) {
        getNGE(new int[]{9,64,8,5,6,9});
    }

}
