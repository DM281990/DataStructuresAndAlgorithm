package SlidngWindow;

/**
 * Leetcode#1456
 */
public class MaximumNumberOfVowelsInGivenSubstring {
    public int maxVowels(String s, int k) {
        int maxCount=0;
        int count=0;
        for(int i=0;i<k;i++){
            if(isVowel(s,i))count++;
        }
        maxCount =Math.max(count,maxCount);
        for(int j=k;j<s.length();j++){
            if(isVowel(s,j))count++;
            if(isVowel(s,j-k))count--;
            maxCount =Math.max(count,maxCount);
        }
        return maxCount;
    }
    private boolean isVowel(String word, int index) {
        return word.charAt(index) == 'a' || word.charAt(index) == 'e' || word.charAt(index) == 'i'
                || word.charAt(index) == 'o' || word.charAt(index) == 'u';
    }

}
