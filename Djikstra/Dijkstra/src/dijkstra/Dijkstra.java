package dijkstra;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


/**
 *
 * @author evenal
 */
public class Dijkstra
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Create the graph");

        List<Node> nodes = createGraph();
        findShortestPathsFrom(nodes.get(0), nodes);
    }

    public static void findShortestPathsFrom(Node s, List<Node> nodes) {
        System.out.println("Finding shortest path");

        // create comparator needed to compare lengths of paths
        Comparator<Node> comp = new Comparator<Node>()
        {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.dist - o2.dist;
            }
        };

        // create the priority queue
        PriorityQueue<Node> pq = new PriorityQueue<>(comp);

        // initialize fields needed for the algorithm,
        // these fields serve the same purpose as tne d and p
        // arrays in the lecture slides
        for (int i = 1; i < nodes.size(); i++) {
            Node n = nodes.get(i);
            n.done = false;
            n.dist = Integer.MAX_VALUE;
            n.prev = s;
            pq.add(n);
        }

        // set the distance to the nodes adjacent to the start node.
        for (Edge e : s.neighbours) {
            e.to.dist = e.length;
            s.done = true;
        }

        // setup complete - now start the real algorithm
        while (!pq.isEmpty()) {
            // get the node with shortest path from s
            Node u = pq.poll();

            // check if the distance to any of the neighbours can be
            // shortened by going through this node
            for (Edge e : u.neighbours) {
                Node v = e.to;
                if (!u.done && u.dist + e.length < v.dist) {
                    v.dist = u.dist + e.length;
                    v.prev = u;

                    // we should remove v from pq, and add it again
                    // to ensure that it's in the right place
                    // or use a priority queue implementation that
                    // supports changing priorities
                }
            }
        }

        for (Node tn : nodes) {
            System.out.println(tn.navn + " " + tn.dist);
        }
    }

    static List<Node> createGraph() {
        List<Node> nodes = new ArrayList<Node>();

        // create the nodes from the lecture example
        nodes.add(new Node("0"));
        nodes.add(new Node("1"));
        nodes.add(new Node("2"));
        nodes.add(new Node("3"));
        nodes.add(new Node("4"));
        System.out.println("Adding edges");

        createEdge(nodes.get(0), nodes.get(1), 10);
        createEdge(nodes.get(0), nodes.get(3), 30);
        createEdge(nodes.get(0), nodes.get(4), 100);
        createEdge(nodes.get(1), nodes.get(2), 50);
        createEdge(nodes.get(2), nodes.get(3), 20);
        createEdge(nodes.get(2), nodes.get(4), 10);
        createEdge(nodes.get(3), nodes.get(4), 60);

        return nodes;
    }

    // this graph is undirected so we need to edge objects
    // for each "real" edge, to allow navigation in both directions
    // along the edge
    static void createEdge(Node n1, Node n2, int length) {
        n1.neighbours.add(new Edge(n1, n2, length)); // forward
        n2.neighbours.add(new Edge(n2, n1, length)); // and back
    }
}
