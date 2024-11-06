package SlidngWindow;

/**
 *
 *Sliding window with at most one 0 inside.
 *
 *
 * Leetcode#1493
 Longest Subarray of 1's After Deleting One Element
 Constrained Subsequence Sum
 Number of Substrings Containing All Three Characters
 Count Number of Nice Subarrays
 Replace the Substring for Balanced String
 Max Consecutive Ones III
 Binary Subarrays With Sum
 Subarrays with K Different Integers
 Fruit Into Baskets
 Shortest Subarray with Sum at Least K
 Minimum Size Subarray Sum
 */
public class LongestSubArraysOf1AfterDeleting1Element {
    public static void main(String[] args) {

    }

    /**
     * Algorithm
     * https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/discuss/708112/JavaC%2B%2BPython-Sliding-Window-at-most-one-0
     * @param A
     * @return
     */
    public int longestSubarray1(int[] A) {
        int i = 0, j, k = 1, res = 0;
        for (j = 0; j < A.length; ++j) {
            if (A[j] == 0) {
                k--;
            }
            while (k < 0) {
                if (A[i] == 0) {
                    k++;
                }
                i++;
            }
            System.out.println(j+","+i);
            res = Math.max(res, j - i);
        }
        return res;
    }
}
