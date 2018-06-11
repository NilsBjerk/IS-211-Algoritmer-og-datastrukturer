package dijkstra;


import java.util.ArrayList;
import java.util.List;


/**
 * Simple node class
 *
 * @author evenal
 */
public class Node
{
    // This is an adjacency list based graph implementation
    List<Edge> neighbours; // the adjacency list
    // the adjacency list contains edges rather than
    // nodes, because we have data that belongs to
    //specific edges
    String navn; // node name
    Node prev; // the previous node in the shortest path to this node
    int dist; // the distance from the start node to this node
    boolean done;

    public Node(String navn) {
        neighbours = new ArrayList<>();
        this.navn = navn;
    }

}
