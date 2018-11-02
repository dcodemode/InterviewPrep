package learn.ds.graph;

import learn.ds.nodes.GraphNode;

/**
 * @author Varma Penmetsa
 *
 * Print Asdjacancy Array of the below graph.
 *
 *       0 ---- 1 \
 *       |   /  |  2
 *       |  /   | /
 *       4 ---- 3
 *
 * https://www.geeksforgeeks.org/graph-and-its-representations/
 */
public class GraphRepresentation {

    // Adds an edge to an undirected graph
    public static void addEdge(GraphNode graph, int src, int dest) {
        graph.adjListArray[src].add(dest);

        // Since graph is undirected, add an edge from dest to src also
        graph.adjListArray[dest].add(src);
    }

    // A utility function to print the adjacency list representation of graph
    public static void printGraph(GraphNode graph) {
        for (int v = 0; v < graph.vertices; v++) {
            System.out.println("Adjacency list of vertex " + v);
            System.out.print("head");
            for (Integer pCrawl : graph.adjListArray[v]) {
                System.out.print(" -> " + pCrawl);
            }
            System.out.println("\n");
        }
    }

    public static void main(String args[]) {

        // create the graph given in above figure
        int V = 5;
        GraphNode graph = new GraphNode(5);

        addEdge(graph,0, 1);
        addEdge(graph,0, 4);
        addEdge(graph,1, 2);
        addEdge(graph,1, 3);
        addEdge(graph,1, 4);
        addEdge(graph,2, 3);
        addEdge(graph,3, 4);

        // print the adjacency list representation of
        // the above graph
        printGraph(graph);
    }
}
