package learn.ds.graph;

import learn.ds.nodes.GraphNode;
import learn.util.Graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Varma Penmetsa
 *
 * Find a Mother Vertex in a Graph
 *
 * A mother vertex in a graph G = (V,E) is a vertex v such that all other vertices in G can be reached by a path from v.
 *
 * https://www.geeksforgeeks.org/find-a-mother-vertex-in-a-graph/
 */
public class FindMotherVertex {

    /**
     * Brute force : Very Inefficient
     * Algo : Perform DFS/BFS on all nodes to find whether we can reach all vertices from current vertex.
     * Time Complexity : O(V(E+V))
     */
    public static void getMotherVertix(GraphNode graph) {
        int allVertices = graph.vertices;

        for (int i = 0; i < allVertices; i++) {
            if (dfs(graph, i).size() == allVertices) {
                System.out.println("Mother Vertex is " + i);
            }
        }
    }

    //DFS of a graph
    public static List<Integer> dfs(GraphNode graph, int start){
        boolean visited[] = new boolean[graph.vertices];
        visited[start] = true;
        List<Integer> vList = new ArrayList<>();

        Stack<Integer> st = new Stack();
        st.push(start);

        while (!st.isEmpty()) {
            start = st.pop();
            vList.add(start);

            for (int i : graph.adjListArray[start]) {
                if (!visited[i]) {
                    visited[i] = true;
                    st.push(i);
                }
            }
        }
        return vList;
    }

    /**
     * Using Strongly Connected Elements(Kosaraju's Algorithm)
     *
     * Algo:
     * 1) Create an empty stack ‘S’ and do DFS traversal of a graph. In DFS traversal, after calling recursive DFS for adjacent vertices of a vertex, push the vertex to stack.
     * 2) Reverse directions of all arcs to obtain the transpose graph.
     * 3) One by one pop a vertex from S while S is not empty. Let the popped vertex be ‘v’. Take v as source and do DFS (call DFSUtil(v)). The DFS starting from v prints strongly connected component of v. In the above example, we process vertices in order 0, 3, 4, 2, 1 (One by one popped from stack).
     *
     * Time Complexity  : O(V + E) where V is number of vertices and E is number of edges
     * Space Complexity : O(V)
     */

    //To-Do
    


    public static void main(String[] args) {
        Graph g = new Graph(7);

        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 3);
        g.addEdge(4, 1);
        g.addEdge(6, 4);
        g.addEdge(5, 6);
        g.addEdge(5, 2);
        g.addEdge(6, 0);

        getMotherVertix(g.node);
    }
}
