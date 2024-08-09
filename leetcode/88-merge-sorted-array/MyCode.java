public class MyCode {

    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};
        merge(nums1, nums1.length, nums2, nums2.length)
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int i = 0;
        int j = 0;
        int k = m;

        while (i < ((m + n) - 1) ) {
            if (nums1[i] > nums2[j] ) {
                int temp = nums1[i];
                nums1[i] = nums1[k];
                nums1[k] = temp;

                j++; k++;
            }
            i++;
        }
    }
}
