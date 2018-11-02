package learn.ds.nodes;

import java.util.LinkedList;

/**
 * @author Varma Penmetsa
 */
public class GraphNode {
    /*
     * Basic Graph Node
     */
    public int vertices;
    public LinkedList<Integer> adjListArray[];

    public GraphNode(int vertices){

        this.vertices = vertices;
        adjListArray = new LinkedList[vertices];

        for(int i = 0; i < vertices ; i++){
            adjListArray[i] = new LinkedList<>();
        }
    }
}
