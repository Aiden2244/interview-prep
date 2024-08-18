public class Node {

    private int value;
    private boolean discovered;
    private boolean explored;

    private final int PRIME = 17;

    private void initialize() {
        discovered = false;
        explored = false;
    }

    public Node() {
        initialize();
        value = 0;
    }

    public Node(int v) {
        initialize();
        value = v;
    }

    public String toString() {
        Integer v = (Integer) value;
        return v.toString();
    }

    public int getValue() { return value; }

    public void setDiscovered(boolean d) { discovered = d; }
    public void setExplored(boolean e) { explored = e; }

    public boolean getDiscovered() { return discovered; }
    public boolean getExplored() { return explored; }

    public int hashCode() {
        int val = 1;

        Integer v = (Integer) value;
        Boolean b1 = (Boolean) discovered;
        Boolean b2 = (Boolean) explored;

        val *= v.hashCode() + PRIME;
        val *= b1.hashCode() + PRIME;
        val *= b2.hashCode() + PRIME;

        return val;
    }

    public boolean equals(Node other) {
        return (
            ((value == other.value) 
            && (discovered == other.discovered)) 
            && (explored == other.explored)
        );
    }

}