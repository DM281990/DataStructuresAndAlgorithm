package PrefixSum;

/**
 * ALGORITHM
 We will split the array into two parts, left and right.
 Firstly we count the sum to an array right,
 where right[0] = A[0] + A[2] +...
 and right[1] = A[1] + A[3] +...


 Now we iterates the whole array A, and try to split at each A[i].
 When move one element from right to left,
 we reduce the sum in right,
 check the if it's fair,
 then increse the sum in left.
 * Leetcode#1664
 */
public class WaysToMakeArrayFairer {
    public int waysToMakeFair(int[] A) {
        int res = 0, n = A.length, left[] = new int[2], right[] = new int[2];
        for (int i = 0; i < n; i++)
            right[i%2] += A[i];
        for (int i = 0; i < n; i++) {
            right[i%2] -= A[i];
            if (left[0]+right[1] == left[1]+right[0]) res++;
            left[i%2] += A[i];
        }
        return res;
    }
}
