import java.util.ArrayList;
import java.lang.Math;

public class Solution {

    public static final int MAX = 10000;

    public static void main(String[] args) {
        System.out.println("Hello World!");
        ArrayList<Integer> squares = populate(MAX);
        System.err.println(squaresToSum(12, squares));
        System.err.println(squares);
    }

    public static ArrayList<Integer> populate(int max) {
        System.out.println("Populate runs!");
        ArrayList<Integer> squares = new ArrayList<>();
        int sqrt = (int) Math.sqrt(max);
        System.err.println("Sqrt: " + sqrt);
        for (int i = 0; i <= sqrt; i++) {
            squares.add(i * i);
        }
        
        return squares;
    }

    public static int squaresToSum(int target, ArrayList<Integer> squares) {

        int sum = 0;
        int temp = target;

        int i = squares.size() - 1;
        while (temp != 0) {
            temp -= squares.get(i);
            if (temp < target) {
                temp += squares.get(i);
                i--;
                sum--;
            }
            sum++;
        }

        return sum;
    }
}
