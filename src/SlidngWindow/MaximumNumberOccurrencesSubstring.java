package SlidngWindow;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Failed
 * Leetcode#1297
 */
public class MaximumNumberOccurrencesSubstring {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> map = new LinkedHashMap<>();
        int maxCount = 0;
        for (int i = minSize; i <= s.length(); i++) {
            map.compute(s.substring(i - minSize, i), (key, value) -> value == null ? 1 : value + 1);
            Set<Character> chrs = new HashSet<>();
            for (char c : s.substring(i - minSize, i).toCharArray()) {
                chrs.add(c);
            }
            if(chrs.size()<=maxLetters) {
                maxCount = Math.max(maxCount, map.get(s.substring(i - minSize, i)));
            }
        }
        return maxCount;
    }}
