package SlidngWindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Leetcode#187
 */
public class FindRepeatedDNASequeence {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> setAvailable = new HashSet<>();
        Set<String> resList = new HashSet<>();
        if (s.length() < 10) {
            return new ArrayList<>();
        }
        //	System.out.println(s);
        for(int i=10;i<=s.length();i++) {
            //	System.out.println(s.substring(i-10,i));
            if(setAvailable.contains(s.substring(i-10,i))) {
                resList.add(s.substring(i-10,i));
            }
            else {
                setAvailable.add(s.substring(i-10,i));
            }
        }
        return new ArrayList<>(resList);
    }
}
