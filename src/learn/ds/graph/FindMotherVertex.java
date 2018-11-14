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
     * Based on Strongly Connected Elements(Kosaraju's Algorithm)
     *
     * Algo:
     *  1. Do DFS traversal of the given graph. While doing traversal keep track of last finished vertex ‘v’. This step takes O(V+E) time.
     *  2. If there exist mother vertex (or vetices), then v must be one (or one of them). Check if v is a mother vertex by doing DFS/BFS from v. This step also takes O(V+E) time.
     *
     * Time Complexity  : O(V + E) where V is number of vertices and E is number of edges
     * Space Complexity : O(V)
     */

    public static int getMotherVertex2(GraphNode graph) {
        boolean visited[] = new boolean[graph.vertices];
        int v = 0;

        for (int i = 0; i < graph.vertices; i++) {
            if (!visited[i]) {
                dfsRecursive(graph, i, visited);
                v = i;
            }
        }

        //Check if v visits all nodes in the graph
        visited = new boolean[graph.vertices];
        dfsRecursive(graph, v, visited);
        for (int i = 0; i < graph.vertices; i++) {
            if (!visited[i]) {
                return -1;
            }
        }
        return v;
    }

    public static void dfsRecursive(GraphNode graph, int start, boolean[] visited) {
        visited[start] = true;
        for (int i : graph.adjListArray[start]) {
            if (!visited[i]) {
                visited[i] = true;
                dfsRecursive(graph, i, visited);
            }
        }
    }

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

        //getMotherVertix(g.node);

        System.out.println(getMotherVertex2(g.node));
    }
}
