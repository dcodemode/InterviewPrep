package learn.ds.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
The demons had captured the princess and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of m x n rooms laid out in a 2D grid. Our valiant knight was initially positioned in the top-left room and must fight his way through dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons (represented by negative integers), so the knight loses health upon entering these rooms; other rooms are either empty (represented as 0) or contain magic orbs that increase the knight's health (represented by positive integers).

To reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Return the knight's minimum initial health so that he can rescue the princess.

Note that any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
 

Example 1:

Input: dungeon = [[-2,-3,3],[-5,-10,1],[10,30,-5]]
Output: 7
Explanation: The initial health of the knight must be at least 7 if he follows the optimal path: RIGHT-> RIGHT -> DOWN -> DOWN.
Example 2:

Input: dungeon = [[0]]
Output: 1
 

Constraints:

m == dungeon.length
n == dungeon[i].length
1 <= m, n <= 200
-1000 <= dungeon[i][j] <= 1000
*/
public class DungeonGame {

    /**
     * Dynamic Programming
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;

        int[][] dp = new int[m+1][n+1];

        for (int i = 0; i <= m; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        dp[m][n-1] = 1;
        dp[m-1][n] = 1;

        for (int i = m-1; i >= 0; i--) {
            for (int j = n-1; j >= 0; j--) {
                int minPower = Math.min(dp[i+1][j], dp[i][j+1])  - dungeon[i][j];
                
                dp[i][j] = (minPower <= 0) ? 1 : minPower;
            }
        }
        return dp[0][0];
    }
    
    final int[][] dirs = new int[][]{{-1, 0}, {0, -1}};
    
    /**
     * 
     * BFS 
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP2(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        
        int[][] rs = new int[dungeon.length][dungeon[0].length];

        for (int i = 0; i <= m; i++){
            Arrays.fill(rs[i], Integer.MAX_VALUE);
        }

        Queue<int[]> queue = new LinkedList<>();
        
        // right bottom corner is our starting point
        rs[m - 1][n - 1] = dungeon[m - 1][n - 1];
        queue.add(new int[]{dungeon.length - 1, dungeon[0].length - 1});

        while (queue.size() > 0) {
            int size = queue.size();
            while (size > 0) {
                int[] point = queue.poll();
                for (int[] dir : dirs) {
                    int ii = point[0] + dir[0];
                    int jj = point[1] + dir[1];
                    if (ii >= 0 && jj >= 0) {
                        // We don't want to add the same cell to the queue. 
						// This is important otherwise we will hit time limit
                        if (rs[ii][jj] == Integer.MIN_VALUE) {
                            queue.add(new int[]{ii, jj});
                        } 
                        rs[ii][jj] = Math.max(rs[ii][jj], Math.min(dungeon[ii][jj], rs[point[0]][point[1]] + dungeon[ii][jj]));
                   }
                }
                size--;
            }
        }
        if(rs[0][0] >= 0) // if we have positive at top left corner, that means we only need 1 health to reach the end.
            return 1;
        else // otherwise, we need to compensate the negetive health that we are going to lose alone the way.
            return -rs[0][0] + 1;
    }
    
}
