package learn.ds.unionfind;

import learn.ds.nodes.GraphNode;

/**
 * @timestamp: 11/14/2018 2:20 PM
 * @author: Varma Penmetsa
 *
 * Problem:
 *  Given a directed graph, find all strongly connected components in this graph.
 *  We are going to use Kosaraju's algorithm to find strongly connected component.
 *
 * Reference:
 *  https://en.wikipedia.org/wiki/Strongly_connected_component
 *  https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/StronglyConnectedComponent.java
 *  https://www.youtube.com/watch?v=RpgcYiky7uw
 **/
public class StronglyConnectedComponent {

    public static void findSCC(GraphNode graph) {
        boolean visited[] = new boolean[graph.vertices];

        for (int i = 0; i < graph.vertices; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited);
            }
        }

        //Reverse Graph

    }

    //Recursive DFS
    public static void dfs(GraphNode graph, int start, boolean[] visited) {
        visited[start] = true;

        for (int i : graph.adjListArray[start]) {
            if (!visited[i]) {
                dfs(graph, i, visited);
            }
        }
    }

    public static void main(String[] args) {

    }
}
