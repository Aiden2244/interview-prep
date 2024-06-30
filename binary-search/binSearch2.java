import java.util.Arrays;
import java.util.Random;

public class binSearch2 {
    public static void main(String[] args) {
        try {
            
            int[] arr = generateRandomArray();
    
            System.err.println("ARRAY: " + arr + '\n');
            System.out.println("TESTING BIN SEARCH");
            Arrays.sort(arr); 

            for (int i = -10 + arr[0]; i < 10 + arr[arr.length-1]; i++) {
                System.out.print("i=" + i);
                System.out.println("\tindex: " + binarySearch(arr, i)); 
            }
        }
        catch (StackOverflowError e) {
            System.err.println("Stack dun fucked");
        }
    } 

    public static int binarySearch(int[] arr, int target) {
        Arrays.sort(arr);
        return binarySearch(arr, target, 0, arr.length-1);
    }

    private static int binarySearch(int[] arr, int target, int min, int max) {

        if ( min > max ) return -1;

        int mid = (max + min)/2;

        if (arr[mid] == target) {
            return mid;
        }

        else if (arr[mid] > target) {
            return binarySearch(arr, target, min, mid-1);
        }

        else {
            return binarySearch(arr, target, mid+1, max);
        }
    }

    public static int[] generateRandomArray() {
        Random rand = new Random();
        int size = 10 + rand.nextInt(30);

        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = -100 + rand.nextInt(200);
        }

        return arr;
    }
}