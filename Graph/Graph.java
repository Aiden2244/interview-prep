import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.lang.StringBuilder;

public class Graph {
    private HashMap<Integer, Node> nodes;
    private HashSet<Edge> edges;
    private boolean directed;

    private void initialize() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }

    public Graph() {
        initialize();
        directed = false;
    }

    public Graph(boolean d) {
        initialize();
        directed = d;
    }

    public void addNode(int n) {
        if (nodes.get(n) != null) {
            System.out.println("Node " + n + " is already in the graph");
            return;
        }
        nodes.put(n, new Node(n));
    }

    private void attemptToAdd(int n) {
        if (nodes.get(n) == null) {
            System.out.println("Node " + n + " is not in the graph, adding node " + n);
            addNode(n);
        }
    }

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
        if (!directed && (first != second)) edges.add(sToF);
    }

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
