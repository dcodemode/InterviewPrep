package learn.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
Given an n x n binary matrix grid, return the length of the shortest clear path in the matrix. If there is no clear path, return -1.

A clear path in a binary matrix is a path from the top-left cell (i.e., (0, 0)) to the bottom-right cell (i.e., (n - 1, n - 1)) such that:

All the visited cells of the path are 0.
All the adjacent cells of the path are 8-directionally connected (i.e., they are different and they share an edge or a corner).
The length of a clear path is the number of visited cells of this path.

 

Example 1:


Input: grid = [[0,1],[1,0]]
Output: 2
Example 2:


Input: grid = [[0,0,0],[1,1,0],[1,1,0]]
Output: 4
Example 3:

Input: grid = [[1,0,0],[1,1,0],[1,1,0]]
Output: -1
 

Constraints:

n == grid.length
n == grid[i].length
1 <= n <= 100
grid[i][j] is 0 or 1

https://leetcode.com/problems/shortest-path-in-binary-matrix/

 */
public class ShortestPathBinaryMatrix {
    
    private static final int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    
    /**
     * Let 'n' be the number of cells in the grid.
     * 
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * 
     * @param grid
     * @return
     */
    public int shortestPathBinaryMatrix(int[][] grid) {
        
        if(grid[0][0] !=0 || grid[grid.length - 1][grid[0].length - 1] !=0 ){
            return -1;
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0,1});
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;
        int currentDistance = 1;
        
        while(!q.isEmpty()){
            
            int noNodes = q.size();
            
            while(noNodes > 0){
               int[] cell = q.poll();
    
                int row = cell[0];
                int col = cell[1];

                if (row == grid.length - 1 && col == grid[0].length - 1) {
                    return currentDistance;
                }


                for(int[] neighbour : getNeighbours(grid, row, col)){
                    int nRow = neighbour[0];
                    int nCol = neighbour[1];
                    
                    if(visited[nRow][nCol]){
                        continue;
                    }
                    visited[nRow][nCol] = true;
                    q.add(new int[]{nRow,nCol});
                } 
                noNodes--;
            }
            
            currentDistance++;
        }
        return -1;
    }
    

    /**
     directions = [(-1, -1), (-1, 0), (-1, 1), (0, -1), (0, 1), (1, -1), (1, 0), (1, 1)]

    define function get_neighbors(row, col):
    neighbors = a container to put the neighbors of (row, col) in
        for each (row_direction, col_direction) pair in directions:
            neighbor_row = row + row_direction
            neighbor_col = col + col_direction
            if (neighbor_row, neighbor_col) is NOT over the edge of the grid AND is 0:
                add (neighbor_row, neighbor_col) to neighbors
    return neighbors

     * @param grid
     * @param row
     * @param col
     * @return
     */
    public List<int[]> getNeighbours(int[][] grid, int row, int col){
        List<int[]> neighbours = new ArrayList<>();
        
        for(int[] direction : directions){
            int nRow = row - direction[0];
            int nCol = col - direction[1];
            
            if(nRow < 0 || nCol < 0 || nRow >=grid.length || nCol >= grid[0].length || grid[nRow][nCol] != 0 ){
                continue;
            }
            neighbours.add(new int[]{nRow, nCol});
        }
        return neighbours;
    }
}
