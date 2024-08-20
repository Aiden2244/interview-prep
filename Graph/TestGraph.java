import java.util.Random;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class TestGraph {

    private static final Random random = new Random();
    public static void main(String[] args) {
        firstTest();   
        secondTest();
        thirdTest();
        fourthTest();
        fifthTest();
        sixthTest();
        seventhTest();
        eighthTest();
        ninthTest();
        tenthTest();
        eleventhTest();
        twelfthTest();
        thirteenthTest();
    }

    /* UTILITIEs */

    // default graph
    public static Graph generateRandomGraph(int numNodes, int numEdges) {
        return generateRandomGraph(numNodes, numEdges, false, true);
    }

    // gives control over directedness
    public static Graph generateRandomGraph(int numNodes, int numEdges, boolean directed) {
        return generateRandomGraph(numNodes, numEdges, directed, true);
    }

    // total parameter control
    public static Graph generateRandomGraph(
        int numNodes, 
        int numEdges, 
        boolean directed, 
        boolean connected
    )
    {
        
        // inititalize constants
        Graph g = new Graph(directed);

        // limit the number of edges that can be in the graph
        if (numEdges > (2 * numNodes)) {
            System.out.println("Number of edges is too large, resetting to 2*n");
            numEdges = 2*numNodes;
        }

        // put a floor for the number of edges in connected graphs
        else if (connected && (numEdges < (numNodes - 1))) {
            System.out.println(
            "Number of edges is too small for a connected graph, setting to minimum numNodes - 1");
            numEdges = numNodes - 1;
        }

        // generate the node values
        for (int i = 0; i < numNodes; i++) {
            g.addNode(i);
        }

        // generate the edges 
        if (connected) {

            for (int i = 0; i < numNodes; i++) {

            }
            
            if (numEdges >= numNodes) {
                for (int j = numNodes; j < numEdges; j++) {
                    
                    Object[] nodeValuesArray = nodeValues.toArray();

                    // generate indices
                    int first = random.nextInt(nodeValues.size() - 1);
                    while (firstIndex == secondIndex) {
                        random.nextInt(nodeValues.size() - 1);
                    }

                    // add the edges
                    g.addEdge((int) nodeValuesArray[firstIndex], (int) nodeValuesArray[secondIndex]);

                }
            }
        }

        else {

        }


        return g;
    }


    /* TESTS */
    public static void firstTest() {
        System.out.println("Running First Test");
        Graph g = new Graph();

        // can we add nodes to the graph?
        g.addNode(0);
        g.addNode(1);
        g.addNode(2);

        // can we add edges to the graph?
        g.addEdge(0, 1);
        g.addEdge(1, 2);

        // can we print the graph?
        System.out.println(g);

        System.out.println();
    }

    public static void secondTest() {
        System.out.println("Running Second Test");
        Graph g = new Graph();

        g.addNode(0);
        g.addNode(1);
        g.addNode(2);
        g.addNode(2); // what happens when we try to add the same node twice?

        g.addEdge(0, 1);
        g.addEdge(1, 2);

        System.out.println(g);

        System.out.println();

        /* 
            should be the same as test 1, but with an additional error message 
            for inserting the duplicate node
        */
    }

    public static void thirdTest() {
        System.out.println("Running Third Test");
        Graph g = new Graph();

        g.addNode(0);
        g.addNode(1);
        g.addNode(2);

        g.addEdge(0, 1);
        g.addEdge(1, 2);
        g.addEdge(1, 2); // what happens when we try to add the same edge twice?

        System.out.println(g);

        System.out.println();

        /* 
            should be the same as test 1, but with an additional error message 
            for inserting the duplicate edge
        */
    }

    public static void fourthTest() {
        System.out.println("Running Fourth Test");
        Node n1 = new Node(1);
        Node n2 = new Node(2);

        // will edge work?
        Edge e = new Edge(n1, n2);
        System.out.println(e); 

        System.out.println();

        /* 
            should output the edge (1, 2)
        */
    }

    public static void fifthTest() {
        System.out.println("Running Fifth Test");
        Graph g = new Graph();

        // can you add an edge to the graph when they are not explicitly defined?
        g.addEdge(2, 3);

        // what happens when you add a node or edge that was implicitly added?
        g.addNode(2);
        g.addEdge(3, 2);

        // can you still add other nodes and edges?
        g.addNode(1);
        g.addEdge(1, 2);

        System.out.println(g);

        System.out.println();
    }

    public static void sixthTest() {
        System.out.println("Running Sixth Test");
        // what about a directed graph?
        Graph g = new Graph(true);

        g.addEdge(2, 3);
        g.addEdge(3, 2); // unlike test 5, this should not result in an error message

        g.addNode(1);
        g.addEdge(1, 2); // (2, 1) should not be in this graph

        System.out.println(g);

        System.out.println();
    }

    public static void seventhTest() {
        System.out.println("Running Seventh Test");

        // does the integer parameter constructor work?
        Edge e1 = new Edge(2, 3);
        Edge e2 = new Edge(3, 2);
        System.out.println(e1);
        System.out.println(e2);

        // are these two edges equal? (they should not be)
        System.out.println(e1.compareTo(e2));

        System.out.println();
    }

    public static void eighthTest() {
        System.out.println("Running Eighth Test");

        // more extensive edge comparison testing
        Edge e1 = new Edge(2, 3);
        Edge e2 = new Edge(3, 2);
        Edge e3 = new Edge(1, 2);
        Edge e4 = new Edge(1, 2);

        System.out.println(e1.compareTo(e2)); // should be false
        System.err.println(e2.compareTo(e1)); // should be false
        System.out.println(e2.compareTo(e3)); // should be false
        System.out.println(e3.compareTo(e3)); // should be true
        System.out.println(e3.compareTo(e4)); // should be false
        System.out.println(e4.compareTo(e3)); // should be false

        System.out.println();
    }

    public static void ninthTest() {
        System.out.println("Running Ninth Test");

        // comparing edges, but this time using the equals() method
        Edge e1 = new Edge(2, 3);
        Edge e2 = new Edge(3, 2);
        Edge e3 = new Edge(1, 2);
        Edge e4 = new Edge(1, 2);

        System.out.println(e1.equals(e2)); // should be false
        System.err.println(e2.equals(e1)); // should be false
        System.out.println(e2.equals(e3)); // should be false
        System.out.println(e3.equals(e3)); // should be true
        System.out.println(e3.equals(e4)); // should be true
        System.out.println(e4.equals(e3)); // should be true

        System.out.println();
    }

    public static void tenthTest() {
        System.out.println("Running Tenth Test");

        // testing the general functionality of the connections data structure
        Graph g = new Graph();

        g.addNode(0);
        g.addNode(1);
        g.addNode(2);
        g.addNode(3);
        g.addNode(4);

        g.addEdge(3, 1);
        g.addEdge(2, 3);
        g.addEdge(2, 1);
        g.addEdge(1, 4);

        System.out.println(g.getEdgesForNode(0)); // 0 should have no edges
        System.out.println(g.getEdgesForNode(1)); // 1 should have edges (1, 3), (1, 4) and (1, 2)
        System.out.println(g.getEdgesForNode(2)); // 2 should have edges (2, 3) and (2, 1)
        System.out.println(g.getEdgesForNode(3)); // 3 should have edge (3, 1) and (3, 2)
        System.out.println(g.getEdgesForNode(4)); // 4 should have edge (4, 1)

        System.out.println();
    }

    public static void eleventhTest() {
        System.out.println("Running Eleventh Test");

        // testing the functionality of the connections data structure on a directed graph
        Graph g = new Graph(true);

        g.addNode(0);
        g.addNode(1);
        g.addNode(2);
        g.addNode(3);
        g.addNode(4);

        g.addEdge(3, 1);
        g.addEdge(2, 3);
        g.addEdge(2, 1);
        g.addEdge(1, 4);

        System.out.println(g.getEdgesForNode(0)); // 0 should have no edges
        System.out.println(g.getEdgesForNode(1)); // 1 should have edges (1, 4)
        System.out.println(g.getEdgesForNode(2)); // 2 should have edges (2, 3) and (2, 1)
        System.out.println(g.getEdgesForNode(3)); // 3 should have edge (3, 1)
        System.out.println(g.getEdgesForNode(4)); // 4 should have no edges

        System.out.println();
    }

    public static void twelfthTest() {
        System.out.println("Running Twelfth Test");

        // Testing what the graph knows about itself
        Graph g = new Graph();

        g.addNode(0);
        g.addNode(1);
        g.addNode(2);
        g.addNode(3);
        g.addNode(4);

        g.addEdge(0, 1);
        g.addEdge(1, 3);
        g.addEdge(3, 2);
        g.addEdge(3, 0);
        g.addEdge(2, 0);
        g.addEdge(3, 4);

        System.out.println(g);

        // test the get neighbors feature
        System.out.println("Neighbors:");
        System.out.println(g.getNeighbors(4)); // should just be 3
        System.out.println(g.getNeighbors(3)); // should be 4, 0, 1, and 2
        System.out.println(g.getNeighbors(2)); // should be 3 and 0
        System.out.println(g.getNeighbors(1)); // should be 3 and 0
        System.out.println(g.getNeighbors(0)); // should be 1, 3 and 2
        
        System.out.println();
    }

    public static void thirteenthTest() {
        System.out.println("Running Thirteenth Test");

        // Testing DFS
        Graph g = new Graph();

        g.addNode(0);
        g.addNode(1);
        g.addNode(2);
        g.addNode(3);
        g.addNode(4);

        g.addEdge(0, 1);
        g.addEdge(1, 3);
        g.addEdge(3, 2);
        g.addEdge(3, 0);
        g.addEdge(2, 0);
        g.addEdge(3, 4);

        System.out.println("DFS(0): " + g.DFS(0));
        System.out.println("DFS(1): " + g.DFS(1));
        System.out.println("DFS(2): " + g.DFS(2));
        System.out.println("DFS(3): " + g.DFS(3));
        System.out.println("DFS(4): " + g.DFS(4));

        System.out.println();
    }

}
