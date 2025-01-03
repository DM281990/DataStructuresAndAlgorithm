package PrefixSum;

import java.util.HashMap;

public class FindLongestSubString {
    /**
     * ALGORITHM
     * Leetcode#1371
     * https://www.youtube.com/watch?v=6Xf5LfM-ciI
     * @param s
     * @return
     */
    public int findTheLongestSubstring(String s) {
        int res = 0 , cur = 0, n = s.length();
        HashMap<Integer, Integer> seen = new HashMap<>();
        seen.put(0, -1);
        for (int i = 0; i < n; ++i) {
            // for consonant "aeiou".indexOf(s.charAt(i) will return -1 hence 0.xor
            cur ^= 1 << ("aeiou".indexOf(s.charAt(i)) + 1 ) >> 1;
            seen.putIfAbsent(cur, i);
            res = Math.max(res, i - seen.get(cur));
        }
        return res;
    }

}
