package learn.ds.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.\
 * 
 * The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).
 *
 * Example 1:
 * Input: graph = [[1,2],[3],[3],[]]
 * Output: [[0,1,3],[0,2,3]]
 * Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 * 
 * Example 2:
 * Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * 
 * Example 3:
 * Input: graph = [[1],[]]
 * Output: [[0,1]]
 * 
 * Example 4:
 * Input: graph = [[1,2,3],[2],[3],[]]
 * Output: [[0,1,2,3],[0,2,3],[0,3]]
 * 
 * Example 5:
 * Input: graph = [[1,3],[2],[3],[]]
 * Output: [[0,1,2,3],[0,3]]
 * 
 * https://leetcode.com/problems/all-paths-from-source-to-target/
 * https://www.youtube.com/watch?v=CYnvDzMprdc
 */

public class AllPathToTarget {
    /**
     * DFS Solution
     * 
     * Time Complexity: O(2^n * n^2)
     * Space Complexity: O(2^N) 
     * @param graph
     * @return
     */
    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<List<Integer>> st = new Stack<>();

        int dest = graph.length - 1;
        st.push(Arrays.asList(0));
        
        while(!st.isEmpty()){
            List<Integer> path = st.pop();
            int lastNode = path.get(path.size() - 1);
            
            if(lastNode == dest){
                result.add(new ArrayList<>(path));
            }else{
                int[] neighbours = graph[lastNode];
                for(int neighbour : neighbours){
                    List<Integer> list = new ArrayList<>(path);
                    list.add(neighbour);
                    st.add(list);
                }
            }
            
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] graph  = {{1,2},{3},{3},{}};
        List<List<Integer>> res = allPathsSourceTarget(graph);
        System.out.println(res);
    }
    
}
