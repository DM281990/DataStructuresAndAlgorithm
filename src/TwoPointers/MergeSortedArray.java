package TwoPointers;

import java.util.Arrays;

/**
 * Leetcode#88
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        new MergeSortedArray().merge(new int[]{4,5,6,0,0,0},3,new int[]{1,2,3},3);
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int[] numstemp = new int[m];
        for (int k = 0; k < m; k++) {
            numstemp[k] = nums1[k];
        }
        Arrays.fill(nums1,0);
        int k=0;
        while (i < m && j < n) {
            if (numstemp[i] < nums2[j]) {
                nums1[k++] = numstemp[i];
                i++;
            } else if (numstemp[i] > nums2[j]) {
                nums1[k++] = nums2[j];
                j++;
            } else {
                nums1[k++] = nums2[j];
                nums1[k++] = numstemp[i];
                i++;
                j++;
            }
        }
        while (i < m) {
            nums1[k++] = numstemp[i];
            i++;
        }
        while (j < n) {
            nums1[k++] = nums2[j];
            j++;
        }
    }
}
