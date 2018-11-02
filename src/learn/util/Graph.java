package learn.util;

import learn.ds.nodes.GraphNode;

/**
 * Basic Graph class
 * @author Varma Penmetsa
 */
public class Graph {
    public GraphNode node;

    public Graph(int vertex) {
        node = new GraphNode(vertex);
    }

    public void addEdge(int v, int w) {
        node.adjListArray[v].add(w);
    }
}
