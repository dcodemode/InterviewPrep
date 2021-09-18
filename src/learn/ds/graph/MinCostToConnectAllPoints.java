package learn.ds.graph;

import java.util.PriorityQueue;

/*
You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].

The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.

Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.

Example 1:

Input: points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
Output: 20
Explanation:

We can connect the points as shown above to get the minimum cost of 20.
Notice that there is a unique path between every pair of points.
Example 2:

Input: points = [[3,12],[-2,5],[-4,1]]
Output: 18
Example 3:

Input: points = [[0,0],[1,1],[1,0],[-1,1]]
Output: 4
Example 4:

Input: points = [[-1000000,-1000000],[1000000,1000000]]
Output: 4000000
Example 5:

Input: points = [[0,0]]
Output: 0
 

Constraints:

1 <= points.length <= 1000
-106 <= xi, yi <= 106
All pairs (xi, yi) are distinct.

https://leetcode.com/problems/min-cost-to-connect-all-points/

 */
public class MinCostToConnectAllPoints {


    /**
     * Time Complexity : O(ElogE), E represents the number of edges.
     * Space Complexity : O(V)
     */
    class UnionFind{
        int[] root;
        int[] rank;
        
        public UnionFind(int m){
            root = new int[m];
            rank = new int[m];
            
            for(int i = 0 ; i < m ; i++){
                root[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int x){
            if(x == root[x]){
                return x;
            }
            return root[x] = find(root[x]);
        }
        
        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            
            if(rootX == rootY){
                return;
            }
            
            if(rank[rootX] > rank[rootY]){
                root[rootY] = rootX;
            }else if(rank[rootX] < rank[rootY]){
                root[rootX] = rootY;
            }else{
                root[rootY] = rootX;
                rank[rootX] += 1;
            }
        }
        
        public boolean isConnected(int x , int y){
            int rootX = find(x);
            int rootY = find(y);
            return rootX == rootY;
        }
    }

    public int minCostConnectPoints(int[][] points) {
        if(points == null || points.length == 0){
            return 0;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> x[2] - y[2]);
        
        for (int i = 0; i < points.length; i++) {
            for (int j = i+1; j < points.length; j++) {
                
                int[] pointI = points[i];
                int[] pointJ = points[j];
                int distance = Math.abs(pointI[0] - pointJ[0]) + Math.abs(pointI[1] - pointJ[1]);
                pq.add(new int[]{i, j, distance});
            }
        }
        
        //Kruskal's Alg
        int allVertices = points.length;
        UnionFind uf = new UnionFind(allVertices);
        
        int edgesConnected = allVertices -1;
        int cost = 0;
        
        while(!pq.isEmpty() && edgesConnected > 0){
            int[] vertice = pq.poll();
            
            if(!uf.isConnected(vertice[0], vertice[1])){
                uf.union(vertice[0], vertice[1]);
                cost += vertice[2];
                edgesConnected--;
            }
        }
        return cost;
    }
    
}
