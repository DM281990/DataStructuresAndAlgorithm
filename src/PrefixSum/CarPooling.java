package PrefixSum;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Failed
 * Leetcode#1094
 */

/**
 Track the change of capacity in time order.


 Explanation
 Save all time points and the change on current capacity
 Sort all the changes on the key of time points.
 Track the current capacity and return false if negative
 */
public class CarPooling {
    public static void main(String[] args) {
        new CarPooling().carPooling(new int[][]{{1,2,10},{2,3,20},{2,5,25}},5);
        new CarPooling().corpFlightBookings(new int[][]{{1,2,10},{2,3,20},{2,5,25}},5);

    }
    public boolean carPooling(int[][] trips, int capacity) {
        Map<Integer, Integer> m = new TreeMap<>();
        for (int[] t : trips) {
            m.put(t[1], m.getOrDefault(t[1], 0) + t[0]);
            m.put(t[2], m.getOrDefault(t[2], 0) - t[0]);
        }
        for (int v : m.values()) {
            capacity -= v;
            if (capacity < 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * Leetcode#1109
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] res = new int[n];
        for (int[] b : bookings) {
            res[b[0] - 1] += b[2];
            if (b[1] < n)
                res[b[1]] -= b[2];
        }
        for (int i = 1; i < n; ++i)
            res[i] += res[i - 1];
        return res;
    }
}
