import java.util.Arrays;

public class binSearch {

    public static void main(String[] args) {
        try {
        int[] arr1 = {2, 7, 11, 15};
        int[] arr2 = {3, 2, 4};
        int[] arr3 = {3, 3};

        System.out.println("Array 1");
        for (int i = -10; i < 21; i++) {
            System.out.print("i=" + i);
            System.out.println("\tindex: " + binarySearch(arr1, i)); 
        }

        System.out.println("Array 2");
        for (int i = -10; i < 21; i++) {
            System.out.println("i=" + i + "\tindex: " + binarySearch(arr2, i)); 
        }

        System.out.println("Array 3");
        for (int i = -10; i < 21; i++) {
            System.out.println("i=" + i + "\tindex: " + binarySearch(arr3, i)); 
        }

        // System.err.println(binarySearch(arr1, 8));

        }
        catch (StackOverflowError e) {
            System.err.println("Stack dun fucked");
        }

    }

    public static int binarySearch(int[] arr, int target) {
        Arrays.sort(arr);
        return binarySearch(arr, target, arr.length/2, 0, arr.length-1);
    }

    private static int binarySearch(int[] arr, int target, int searchIndex, int minIndex, int maxIndex) {
        
        if (target > arr[arr.length-1] || target < arr[0]) return -1;

        else if (minIndex == maxIndex && target != arr[searchIndex]) return -1;

        else if (target == arr[searchIndex]) return searchIndex;

        else if (target < arr[searchIndex]) {
            return binarySearch(arr, target, searchIndex/2, minIndex+1, searchIndex/2);
        }

        else { 
            return binarySearch(arr, target, ((arr.length - 1) - searchIndex/2), ((arr.length - 1) - searchIndex/2), maxIndex-1);
        }

    } 

}