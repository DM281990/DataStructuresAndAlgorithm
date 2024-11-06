package SlidngWindow;

import java.util.Arrays;

/**
 * Leetcode#1838
 *
 * Sort the input array A
 * Sliding window prolem actually,
 * the key is to find out the valid condition:
 * k + sum >= size * max
 * which is
 * k + sum >= (j - i + 1) * A[j]
 */
public class FrequencyOfMostFrequentElement {
    public int maxFrequency(int[] A, int k) {
        int res = 1, i = 0, j;
        long sum = 0;
        Arrays.sort(A);
        for (j = 0; j < A.length; ++j) {
            sum += A[j];
            while (sum + k < (long)A[j] * (j - i + 1)) {
                sum -= A[i];
                i += 1;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }

    public int maxFrequency1(int[] A, int k) {
        int res = 1, left = 0;
        long sumOfElementsInWindow = 0;
        Arrays.sort(A);
        for (int right = 0; right < A.length; ++right) {
            sumOfElementsInWindow += A[right];
            // increase the left pointer until the condition satisfies
            while (getNumberOfOperationsNeeded(left, right, sumOfElementsInWindow, A) > k) {
                sumOfElementsInWindow -= A[left];
                left += 1;
            }
            res = Math.max(res, right - left + 1); // update the window if its the max window
        }
        return res;
    }

    /**
     Number of operations needed for all elements in the window [startIndex, endIndex] to hit A[endIndex]
     Example:
     Consider arr with [1, 2, 3, 4] with startIndex = 0; endIndex = 3: i.e If 1, 2, 3 wants to become 4.
     Number of operations needed
     = (4-1)+(4-2)+(4-3)+(4-4) = 6.
     =  4 + 4 + 4 + 4 - (1 + 2 + 3+ 4)
     = 4 * 4 - (1 + 2 + 3 + 4)
     = (number of elements) * ElementToReach - sum of elements in the window
     */
    long getNumberOfOperationsNeeded(int startIndex, int endIndex, long sumOfElementsInWindow, int[] A){
        int numberOfElements = endIndex - startIndex + 1;
        int elementToReach = A[endIndex];
        return ((long) numberOfElements * elementToReach) - sumOfElementsInWindow;
    }
}
