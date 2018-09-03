package learn.ds.string;

/**
 * @author Varma Penmetsa
 *
 * Initially, there is a Robot at position (0, 0). Given a sequence of its moves, judge if this robot makes a circle,
 * which means it moves back to the original place.
 *
 * The move sequence is represented by a string. And each move is represent by a character. The valid robot moves are R (Right),
 * L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.
 *
 * Example 1:
 *    Input: "UD"
 *    Output: true
 *
 * Example 2:
 *    Input: "LL"
 *    Output: false
 *
 * https://leetcode.com/problems/judge-route-circle/description/
 */
public class JudgeRouteCircle {


    /**
     * Time Complexity  : O(n)
     * Space Complexity : O(1)
     */
    public static boolean judgeCircle(String moves) {
        if(moves == null || moves.length() == 0){
            return true;
        }

        if(moves.length() % 2 != 0){
            return false;
        }

        int lCount = 0;
        int rCount = 0;
        int uCount = 0;
        int dCount = 0;

        for(char c : moves.toCharArray()){
            if(c == 'L'){
                lCount = lCount + 1;
            }else if(c == 'R'){
                rCount = rCount + 1;
            }else if(c == 'U'){
                uCount = uCount + 1;
            }else if(c == 'D'){
                dCount = dCount + 1;
            }
        }
        if(lCount == rCount && uCount == dCount){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(judgeCircle("LL"));
        System.out.println(judgeCircle("LR"));
    }
}
