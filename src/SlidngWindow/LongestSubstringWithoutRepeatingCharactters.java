package SlidngWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode#3,159,340
 */
public class LongestSubstringWithoutRepeatingCharactters {
    public int lengthOfLongestSubstring(String s) {
        char[] ch = s.toCharArray();
        Map<Character, Integer> mp = new HashMap<>();
        int result = 0;
        int j = 0;
        for (int i = 0; i < ch.length; i++) {
            if (mp.containsKey(ch[i])) {
                while (mp.get(ch[i]) != 0) {
                    mp.put(ch[j], 0);
                    j++;
                }
            }
            mp.put(ch[i], 1);
            result = Math.max(result, i - j+1);
        }
        return result;
    }

}
