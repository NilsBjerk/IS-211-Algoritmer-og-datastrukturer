package dijkstra;


/**
 *
 * @author evenal
 */
public class Edge
{
    Node from;
    Node to;
    int length;

    public Edge(Node from, Node to, int length) {
        this.from = from;
        this.to = to;
        this.length = length;
    }
}
