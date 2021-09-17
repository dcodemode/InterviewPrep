package learn.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.

Example 1:

Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 10
grid[i][j] is 0, 1, or 2.

https://leetcode.com/problems/rotting-oranges/
*/
public class RottenOranges {

    private final int[][] directions =  {{1,0},{-1,0},{0,1},{0,-1}};
    
    /**
     * BFS Solution 
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        
        int freshOranges = 0;
        
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 2){
                    q.offer(new int[]{i, j});
                }
                
                if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }
        
        if(freshOranges == 0){
            return 0;
        }
        
        int minutes = 0;
        
        while(!q.isEmpty()){
            int qCount = q.size();
            
            while(qCount > 0){
                int[] cell = q.poll();
                
                int row = cell[0];
                int col = cell[1];
                
                for(int[] neighbour : getNeighbours(grid, row, col)){
                    int nRow = neighbour[0];
                    int nCol = neighbour[1];
                    
                    grid[nRow][nCol] = 2;
                    
                    q.offer(new int[]{nRow, nCol});
                    freshOranges--;
                }
                qCount--;
            }
            minutes++;
        }
        return freshOranges == 0 ? minutes-1 : -1;
    }
    
    public List<int[]> getNeighbours(int[][] grid, int row, int col){
        List<int[]> neighbours = new ArrayList<>();
        
        for(int[] direction : directions){
            int nRow = row + direction[0];
            int nCol = col + direction[1];
            
            if(nRow < 0 || nCol < 0 || nRow >= grid.length || nCol >= grid[0].length || grid[nRow][nCol] == 0 || grid[nRow][nCol] == 2){
                continue;
            }
            
            neighbours.add(new int[]{nRow, nCol});
        }
        return neighbours;
    }
    
}
