package TwoPointers;


public class RemoveDuplicates {
    public static void main(String[] args) {
        new RemoveDuplicates().removeDuplicates2(new int[]{1, 1, 1, 2, 2, 3});
    }

    /**
     * Leetcode#26
     */
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[i] == nums[j] && (j - i) > 1) {
                j++;
                continue;
            }
            i++;
            nums[i] = nums[j];
        }
        return i;
    }

    /**
     * Leetcode#27
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] == val) {
                j++;
                continue;
            }
            nums[i] = nums[j];
            i++;
            j++;
        }
        return i;
    }

    /**
     * Leetcode#80
     */
    public int removeDuplicates2(int[] nums) {
        int k = 2;

        for (int i = 2; i < nums.length; i++) {
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}
