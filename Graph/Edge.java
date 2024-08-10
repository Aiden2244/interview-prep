import java.lang.Comparable;

public class Edge implements Comparable<Edge>{
    private Node start;
    private Node end;
    private final int PRIME = 151;

    public Edge (int s, int e) {
        start = new Node(s);
        end = new Node(e);
    }
    
    public Edge(Node s, Node e) {
        start = s;
        end = e;
    }

    public Node getStart() { return start; }
    public Node getEnd() { return end; }

    public String toString() {
        return ("(" + start + ", " + end + ")");
    }

    public int hashCode() {
        int val = 1;
        val *= start.hashCode() + PRIME;
        val *= end.hashCode() + PRIME;

        return val;
    }    

    public int compareTo(Edge other) {
        Integer thisHashCode = (Integer) this.hashCode();
        Integer otherHashCode = (Integer) other.hashCode();
        return thisHashCode.compareTo(otherHashCode);
    }

    public boolean equals(Edge other) {
        return (start.equals(other.start)) && (end.equals(other.end));
    }

}
