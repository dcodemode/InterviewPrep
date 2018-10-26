package learn.ds.graph;

import learn.ds.nodes.GraphNode;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * @author Varma Penmetsa
 *
 * Program for Breadh First Search traveral of graph
 *
 * https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
 */
public class BreadthFirstTraversal {

    /**
     * BFS for a graph is similar to Breadth First Traversal of a tree. The only catch here is, unlike trees,
     * graphs may contain cycles, so we may come to the same node again. To avoid processing a node more than once.
     */

    public static void BFS(GraphNode graph, int start){

        boolean visited[] = new boolean[graph.V];

        LinkedList<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while (queue.size() != 0){
            start = queue.poll();
            System.out.print(start + " ");

            for(int i : graph.adjListArray[start]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
        System.out.println();
    }

    public static void addEdge(GraphNode g, int v, int w) {
        g.adjListArray[v].add(w);
    }

    public static void main(String[] args) {
        GraphNode g = new GraphNode(4);

        addEdge(g, 0, 1);
        addEdge(g, 0, 2);
        addEdge(g, 1, 2);
        addEdge(g, 2, 0);
        addEdge(g, 2, 3);
        addEdge(g, 3, 3);

        System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

        BFS(g, 2);
    }


}
