import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.lang.StringBuilder;

public class Graph {

    // private members
    private HashMap<Integer, Node> nodes;
    private HashSet<Edge> edges;
    private HashMap<Node, HashSet<Edge>> connections;
    private boolean directed;

    // helper method for constructors
    private void initialize() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
        connections = new HashMap<>();
    }

    // no paramters constructor  (default: directed=false)
    public Graph() {
        initialize();
        directed = false;
    }

    // boolean parameter constructor (directed=d)
    public Graph(boolean d) {
        initialize();
        directed = d;
    }

    // add a node to the node set of the graph
    public void addNode(int n) {
        if (nodes.get(n) != null) {
            System.out.println("Node " + n + " is already in the graph");
            return;
        }
        nodes.put(n, new Node(n));
    }

    // helper method that checks if a node is already in the graph and adds it if not
    private void attemptToAdd(int n) {
        if (nodes.get(n) == null) {
            System.out.println("Node " + n + " is not in the graph, adding node " + n);
            addNode(n);
        }
    }

    // helper function that adds a node-edge pair to the connections ds
    private void addConnection(Node n, Edge e) {
        HashSet<Edge> hashSet = connections.get(nodes.get(n.getValue()));
        if (hashSet == null) hashSet = new HashSet<>();
        hashSet.add(e);
        connections.put(n, hashSet);
    }

    // adds an edge to the edge set
    public void addEdge(int first, int second) {
        attemptToAdd(first);
        attemptToAdd(second);

        Edge fToS = new Edge(nodes.get(first), nodes.get(second));
        Edge sToF = new Edge(nodes.get(second), nodes.get(first));

        for (Edge e : edges) {
            if (e.equals(fToS)) {
                System.out.println("Edge " + fToS + " is already in the graph");
                return;
            }
        }

        

        edges.add(fToS);
        addConnection(nodes.get(first), fToS);

        if (!directed && (first != second)) {
            edges.add(sToF);
            addConnection(nodes.get(second), sToF);
        }
    }

    public HashSet<Edge> getEdgesForNode(Integer n) {
        return connections.get(nodes.get(n));
    }

    // returns a string representation of the graph
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Set<Integer> keys = nodes.keySet();

        sb.append("Nodes:\n");
        for (int key : keys) {
            sb.append(nodes.get(key) + "\n");
        }
        
        sb.append("\nEdges:\n");
        for (Edge edge : edges) {
            sb.append(edge + "\n");
        }

        return sb.toString();
    }
}
