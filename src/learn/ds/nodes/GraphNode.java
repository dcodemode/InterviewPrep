package learn.ds.nodes;

import java.util.LinkedList;

/**
 * @author Varma Penmetsa
 */
public class GraphNode {
    /*
     * Basic Graph Node
     */
    public int V;
    public LinkedList<Integer> adjListArray[];

    public GraphNode(int V){

        this.V = V;
        adjListArray = new LinkedList[V];

        for(int i = 0; i < V ; i++){
            adjListArray[i] = new LinkedList<>();
        }
    }
}
