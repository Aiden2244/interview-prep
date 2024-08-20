import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

public class RandomQueue<E> {
    // member variables
    private ArrayList<E> values;
    private Random random;
    private boolean forceUnique;

    // constructors
    private void init() {
        values = new ArrayList<>();
        random = new Random();
    }

    public RandomQueue() {
        init();
        forceUnique = false;
    }

    public RandomQueue(boolean unique) {
        init();
        forceUnique = unique;
    }

    // check if an element is in the queue (O(n), ew, but a necessary evil)
    public boolean contains(E val) {
        for (E current : values) {
            if (current.equals(val)) {
                return true;
            }
        }
        return false;
    }
    
    // add element to the queue
    // O(1) if unique is not enforced, O(n) otherwise
    public void add(E val) {
        // if not unique, just add and return
        if (!forceUnique) {
            values.add(e);
            return;
        }

        // if forceUnique is on, then we have to first check if the element is in the list
        if (contains(val)) {
            System.err.println("WARNING: Attempt to add duplicate value with forceUnique true");
            System.err.println("Offending value: " + val);
            return;
        }
        values.add(e);
    }

    
}
