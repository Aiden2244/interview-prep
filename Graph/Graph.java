import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
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
    } // initialize

    // no paramters constructor  (default: directed=false)
    public Graph() {
        initialize();
        directed = false;
    } // Graph (no parameters)

    // boolean parameter constructor (directed=d)
    public Graph(boolean d) {
        initialize();
        directed = d;
    } // Graph (boolean d)

    // add a node to the node set of the graph
    public void addNode(int n) {
        if (nodes.get(n) != null) {
            System.out.println("Node " + n + " is already in the graph");
            return;
        }
        nodes.put(n, new Node(n));
    } // addNode

    // helper method that checks if a node is already in the graph and adds it if not
    private void attemptToAdd(int n) {
        if (nodes.get(n) == null) {
            System.out.println("Node " + n + " is not in the graph, adding node " + n);
            addNode(n);
        }
    } // attemptToAdd

    // helper function that adds a node-edge pair to the connections ds
    private void addConnection(Node n, Edge e) {
        HashSet<Edge> hashSet = connections.get(nodes.get(n.getValue()));
        if (hashSet == null) hashSet = new HashSet<>();
        hashSet.add(e);
        connections.put(n, hashSet);
    } // addConnection

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
    } // addEdge

    public HashSet<Edge> getEdgesForNode(Integer n) {
        return connections.get(nodes.get(n));
    } // getEdgesForNode

    // essentially just converts a hash set of edges into a hash set of nodes
    public HashSet<Node> getNeighbors(Integer n) {
        HashSet<Node> neighborNodes = new HashSet<>();
        HashSet<Edge> neighborEdges = getEdgesForNode(n);

        for (Edge e : neighborEdges) {
            neighborNodes.add(e.getEnd());
        }

        return neighborNodes;
    } // getNeighbors

    // returns a string representation of the graph
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Nodes:\n");
        sb.append(getNodes() + "\n");
        
        sb.append("\nEdges:\n");
        sb.append(getEdges() + "\n");

        sb.append("\nConnections:\n");
        sb.append(getConnections() + "\n");

        return sb.toString();
    } // toString

    // get the nodes 
    public HashSet<Node> getNodes() { 
        Set<Integer> keys = nodes.keySet();
        HashSet<Node> returnMe = new HashSet<>();
        for (Integer k : keys) {
            returnMe.add(nodes.get(k));
        }
        return returnMe;
    } // getNodes

    public HashSet<Edge> getEdges() {
        return edges;
    } // getEdges

    public HashMap<Node, HashSet<Edge>> getConnections() {
        return connections;
    }


    // depth-first search algorithm (public method)
    public LinkedList<Node> DFS(Integer s) {
        LinkedList<Node> traversal = new LinkedList<>(); // this line is why 2 methods are necessary
        Node current = nodes.get(s);
        traversal = DFS(current, traversal);
        resetGraph();
        return traversal;
    } // DFS (public)

    // depth-first search algorithm (private method) 
    private LinkedList<Node> DFS(Node current, LinkedList<Node> traversal) {

        // System.err.println();
        HashSet<Node> neighbors = getNeighbors(current.getValue()); // get the node's neighbors

        // System.err.println("Neighbors of " + current + ": " + neighbors);

        current.setDiscovered(true); // set the discovered parameter to true
        traversal.add(current); // add the current node to the traversal

        // loop over current node's neighbors, and call alg again on all undisovered neighbors
        for (Node n : neighbors) {
            // System.out.print("Current = " + current + " " + "Discovevered: " + current.getDiscovered());
            // System.out.println(", n = " + n + " " + "Discovevered: " + n.getDiscovered());
            if (!n.getDiscovered()) {
                // System.err.println("DFS: " + traversal);
                DFS(n, traversal);
            }
        }
        return traversal; 
        // will only execute once current node has only discovered neighbors 
        // (and work via recursive magic)
    } // DFS (private)


    // utility that resets all nodes to their default values
    private void resetGraph() {
        for (Node n : getNodes()) {
            n.setDiscovered(false);
            n.setExplored(false);
        }
    }

}
