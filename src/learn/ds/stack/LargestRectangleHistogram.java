package learn.ds.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
    Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, 
    return the area of the largest rectangle in the histogram.

    Example 1:
    Input: heights = [2,1,5,6,2,3]
    Output: 10
    Explanation: The above is a histogram where width of each bar is 1.
    The largest rectangle is shown in the red area, which has an area = 10 units.

    Example 2:
    Input: heights = [2,4]
    Output: 4
    
    Constraints:
    1 <= heights.length <= 105
    0 <= heights[i] <= 104

    https://leetcode.com/problems/largest-rectangle-in-histogram/

 */
public class LargestRectangleHistogram {

    /**
     * Using Monotonic Stacks
     * 
     * Because if the length of the array is n, the largest possible rectangle has to have a height one of the elements of the array, that is to say, there are only n possible largest rectangles. So we don't really need to go through every pair of bars, but should rather search by the height of the bar.
     * 
     * Why Stack?
     * 
     * At each step we need the information of previously seen "candidate" bars - bars which give us hope. These are the bars of increasing heights. 
     * And since they'll need to be put in the order of their occurence, stack should come to your mind.
     * 
     * Lets take the example [2, 1, 5, 6, 2, 3]
     * 
     * Lets start by adding a bar of height 0 as starting point to the stack. This has no inherent meaning, and is just done to make the solution more elegant.
     * 
     * The first bar we see is the bar at position 0 of height 2. It is definitely as "candidate bar" as it gives us hope of finding a larger rectangle, so we just add it to the stack.
     * 
     * The next one we see is the bar at position 1 with height 1. At this point, we look at the stack and see that the "candidate bar" at the top of the stack is of height 2, and because of this 1, we definitely can't do a rectangle of height 2 now, so the only natural thing to do at this point is to pop it out of the stack, and see what area it could have given us.
     * 
     * This bar started at position -1 (which is now at the top of the stack), and ended at position 1, thus giving a width of 1-(-1)-1 = 1, and height of 2 hence we update our maxArea to 2, and now check the next element on top of the stack (to see if that could be popped out as well) - and since it is 0 < 1, it can't be popped out. Thus,
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> st = new ArrayDeque<>();
        st.push(-1);
        int maxArea = 0;

        for(int i = 0 ; i < heights.length ; i++){
            while(st.peek() != -1 && st.peek() >= heights[i]){
                int height = heights[st.pop()];
                int width = i - st.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            st.push(i);
        }

        while(st.peek() != -1){
            int height = heights[st.pop()];
            int width = heights.length - st.peek() - 1;
            maxArea = Math.max(maxArea, height * width);
        }
        return maxArea;
    }
    
}
