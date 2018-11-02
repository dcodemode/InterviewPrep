package learn.ds.graph;

import learn.ds.nodes.GraphNode;
import learn.util.Graph;

import java.util.Stack;

/**
 * @author Varma Penmetsa
 *
 * Write a program to DFS on Graph DS
 *
 * https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
 */
public class DepthFirstSearch {

    /**
     * Iterative DFS Traversal
     */
    public static void DFS(GraphNode graph, int start){

        boolean visited[] = new boolean[graph.vertices];

        visited[start] = true;

        Stack<Integer> st = new Stack<>();
        st.push(start);

        while (!st.isEmpty()){
            start = st.pop();
            System.out.print(start + " ");

            for (int  i : graph.adjListArray[start]){
                if(!visited[i]){
                    visited[i] = true;
                    st.push(i);
                }
            }
        }
        System.out.println();
    }




    public static void main(String[] args) {
        Graph g = new Graph(5);

        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge( 0, 3);
        g.addEdge( 1, 4);

        System.out.println("Following is Depth First Traversal " + "(starting from vertex 0)");

        DFS(g.node, 0);
    }
}
