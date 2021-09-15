package learn.ds.graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * There is a bi-directional graph with n vertices, where each vertex is labeled from 0 to n - 1 (inclusive). The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. Every vertex pair is connected by at most one edge, and no vertex has an edge to itself.
 * 
 * You want to determine if there is a valid path that exists from vertex start to vertex end.
 *
 * Given edges and the integers n, start, and end, return true if there is a valid path from start to end, or false otherwise.
 * 
 * Example:
 * Input: n = 3, edges = [[0,1],[1,2],[2,0]], start = 0, end = 2
 * Output: true
 * Explanation: There are two paths from vertex 0 to vertex 2:
 * - 0 → 1 → 2
 * - 0 → 2
 * 
 * Input: n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], start = 0, end = 5
 * Output: false
 * Explanation: There is no path from vertex 0 to vertex 5.
 * 
 * https://leetcode.com/explore/learn/card/graph/619/depth-first-search-in-graph/3893/
 * 
 */

public class PathExists {

    /**
     * Graph formation is O(V + E) and BFS is additional O(V + E).
     * @param n
     * @param edges
     * @param start
     * @param end
     * @return
     */
    public boolean validPathBFS(int n, int[][] edges, int start, int end) {
        if(start == end){
            return true;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++){
            graph.put(i, new ArrayList<>());
        }
        
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        
        Queue<Integer> st = new LinkedList<>();
        st.offer(start);
        visited[start] = true;
        
        while(!st.isEmpty()){
            int vertice = st.poll();
            for(int neighbour: graph.get(vertice)){
                if(end == neighbour){
                    return true;
                }
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    st.offer(neighbour);
                }
            }
        }
        
        return false;
        
    }

    /**
     * Graph formation is O(V + E) and BFS is additional O(V + E).
     * @param n
     * @param edges
     * @param start
     * @param end
     * @return
     */
    public boolean validPathDFS(int n, int[][] edges, int start, int end) {
        if(start == end){
            return true;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        
        for(int i = 0 ; i < n ; i++){
            graph.put(i, new ArrayList<>());
        }
        
        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        boolean[] visited = new boolean[n];
        
        Deque<Integer> st = new ArrayDeque<>();
        st.add(start);
        visited[start] = true;
        
        while(!st.isEmpty()){
            int vertice = st.pop();
            for(int neighbour: graph.get(vertice)){
                if(end == neighbour){
                    return true;
                }
                if(!visited[neighbour]){
                    visited[neighbour] = true;
                    st.push(neighbour);
                }
            }
        }
        
        return false;
        
    }
    
}
