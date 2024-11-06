package SlidngWindow;

/**
 * Leetcode#1839
 */
public class LongestSubSringOfAllVowelsInOrder {
    public int longestBeautifulSubstring(String word) {
        int result = 0, currentLength = 0, vowelCount = 0;
        for(int i=0;i<word.length();i++) {
            if(i!=0 && word.charAt(i) < word.charAt(i-1)) {
                vowelCount = 0;
                currentLength = 0;
            }
            currentLength++;
            if(i==0 || word.charAt(i) != word.charAt(i-1)) vowelCount++;
            if(vowelCount == 5) result = Math.max(result, currentLength);
        }
        return result;
    }

}
