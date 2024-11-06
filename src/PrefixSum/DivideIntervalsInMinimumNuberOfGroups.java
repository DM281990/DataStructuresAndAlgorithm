package PrefixSum;

import java.util.Arrays;
import java.util.Comparator;
/*
Leetcode#2406
Exactly same as meeting rooms.



Explanation
At time point intervals[i][0],
start using a meeting room(group).


At time point intervals[i][1] + 1,
end using a meeting room.


Sort all events by time,
and accumulate the number of room(group) used.

 */
public class DivideIntervalsInMinimumNuberOfGroups {
    public int minGroups(int[][] intervals) {
        int res = 0, cur = 0, n = intervals.length, A[][] = new int[n * 2][2];
        for (int i = 0; i < n; ++i) {
            A[i * 2] = new int[]{intervals[i][0], 1};
            A[i * 2 + 1] = new int[]{intervals[i][1] + 1, -1};
        }
        Arrays.sort(intervals, (interval1, interval2) -> interval2[0] == interval1[0] ? interval1[1] - interval2[1]
                : interval1[0] - interval2[0]);
        Arrays.sort(A, Comparator.comparingInt(o -> o[0] * 3 + o[1]));
        for (int[] a: A)
            res = Math.max(res, cur += a[1]);
        return res;
    }
}
