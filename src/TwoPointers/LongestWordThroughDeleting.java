package TwoPointers;

import java.util.List;

/**
 * leetcode#524
 */
public class LongestWordThroughDeleting {
/*
    "abpcplea"
            ["ale","apple","monkey","plea"]
            */

    public static void main(String[] args) {
        new LongestWordThroughDeleting().findLongestWord("abcplea",List.of("ale","apple","monkey","plea"));
    }
    public String findLongestWord(String s, List<String> dictionary) {
        int length =0;
        String subSequence="";
        for(int i=0 ;i< dictionary.size();i++){
            if(isSubsequence(s,dictionary.get(i)) && dictionary.get(i).length()>=length){
                if(dictionary.get(i).length()==length){
                    subSequence = subSequence.compareTo(dictionary.get(i))>0?dictionary.get(i):subSequence;
                }
                else{
                    subSequence = dictionary.get(i);
                }
                length = subSequence.length();
            }
        }
        return subSequence;
    }

    private boolean isSubsequence(String s, String s1) {
        String large = s.length()>s1.length()?s:s1;
        String small = large.equals(s)?s1:s;
        int i=0, j=0;
        while(i<small.length() && j<large.length()){
            if(large.charAt(j)==small.charAt(i))
                i++;
            j++;
        }
        return i==small.length();
    }

}
