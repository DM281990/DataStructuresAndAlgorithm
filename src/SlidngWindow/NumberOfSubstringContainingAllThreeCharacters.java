package SlidngWindow;

/**
 * Leetcode#1358
 */
public class NumberOfSubstringContainingAllThreeCharacters {
    public int numberOfSubstrings(String s) {
        int n= s.length();
        char[]chArray=new char[3];
        int start=0;
        int end =0;
        int count =0;
        while(end<s.length()) {
            chArray[s.charAt(end)-'a']++;
            while(chArray[0]>0&&chArray[1]>0&&chArray[2]>0) {
                count+=n-end;
                if(start<s.length()) {
                    chArray[s.charAt(start)-'a']--;
                    start++;
                }
            }
            end++;
        }
        return count;
    }
}
