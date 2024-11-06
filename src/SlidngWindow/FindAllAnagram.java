package SlidngWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Leetcode#438
 */
public class FindAllAnagram {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result =new ArrayList<>();
        if(s.length()<p.length())return result;
       int windowLength = p.length();
       int[]freqPat =new int[26];
        int[]substrPat =new int[26];
        char[]chP=p.toCharArray();
        for(int i=0;i<chP.length;i++){
            freqPat[(int)chP[i]-97]++;
        }
        char[]chs=s.toCharArray();

        for(int i=0;i<windowLength;i++){
            substrPat[(int)chs[i]-97]++;
        }
        if (isAnagram(freqPat,substrPat))result.add(0);
        for(int i=windowLength;i<chs.length;i++){
            substrPat[(int)chs[i]-97]++;
            substrPat[(int)chs[i-windowLength]-97]--;
            if(isAnagram(freqPat,substrPat))result.add(i-windowLength+1);
        }
        return result;
    }

    private boolean isAnagram(int[] freqPat, int[] substrPat) {
        for(int i=0;i<freqPat.length;i++){
            if(freqPat[i]!=substrPat[i])return false;
        }
        return true;
    }

    /**
     * Leetcode#567
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {
        List<Integer> result=findAnagrams(s2,  s1);
        return !result.isEmpty();
    }
}
