package SlidngWindow;

/**
 * ALGORITHM
 * Leetcode#1248
 */
public class CountNumberOfNiceSubArrays {
    public int numberOfSubarrays(int[] A, int k) {
        return atMost(A, k) - atMost(A, k - 1);
    }

    public int atMost(int[] A, int k) {
        int res = 0, i = 0, n = A.length;
        for (int j = 0; j < n; j++) {
            //System.out.println("i=" + i + "J=" + j + ",k=" + k + "result=" + res);
            k -= A[j] % 2;
            while (k < 0)
                k += A[i++] % 2;
            res += j - i + 1;
        }
        return res;
    }
}
