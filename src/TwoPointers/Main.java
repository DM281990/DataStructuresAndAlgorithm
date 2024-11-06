package TwoPointers;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //new Main().reverseVowels("IceCreAm");
       // new Main().intersection(new int[]{4,9,5},new int[]{9,4,9,8,4});
        new Main().reverseStr("abcdefg",2);
    }
    //LEETCODE#344
    public void reverseString(char[] s) {
        if(s.length==0 || s.length ==1){
            return;
        }
        int i=0;
        int j=s.length-1;
        while(i<j){
            char temp = s[i];
            s[i]=s[j];
            s[j]=temp;
            i++;
            j--;
        }
    }
    /**
     * LeetCode#345
     */
    public String reverseVowels(String s) {
        char[] sChar = s.toCharArray();
        if(sChar.length==0 || sChar.length ==1){
            return s;
        }
        int i=0;
        int j=sChar.length-1;
        while(i<j){
            while(i <sChar.length && !isVowel( sChar[i])){
                i++;
            }
            while(j>=0 && !isVowel( sChar[j])){
                j--;
            }
            if(i<j){
                char temp = sChar[i];
                sChar[i]=sChar[j];
                sChar[j]=temp;
            }
            i++;
            j--;
        }
        s = new String(sChar);
        return s;
    }

    /**
     *
     * Leetcode#349
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<>();
        int i= 0;
        int j=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                i++;
            }
            else if(nums1[i]>nums2[j]){
                j++;
            }
            else{
                result.add(nums1[i]);
                i++;
                j++;
            }
        }
        int []resultA = new int[result.size()];
        int k=0;
        for(Integer num: result){
            resultA[k++]=num;
        }
        return resultA;
    }


    /**
     *
     * Leetcode#350
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        List<Integer> result = new ArrayList<>();
        int i= 0;
        int j=0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<nums2[j]){
                i++;
            }
            else if(nums1[i]>nums2[j]){
                j++;
            }
            else{
                result.add(nums1[i]);
                i++;
                j++;
            }
        }
        int []resultA = new int[result.size()];
        int k=0;
        for(Integer num: result){
            resultA[k++]=num;
        }
        return resultA;
    }

    /**
     * Leetcode#392
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        int sp = 0;
        int tp = 0;

        while (sp < s.length() && tp < t.length()) {
            if (s.charAt(sp) == t.charAt(tp)) {
                sp++;
            }
            tp++;
        }

        return sp == s.length();
    }

    private boolean isVowel(char c) {
        return( c=='a' || c =='e'|| c=='i'|| c=='o'|| c=='u'|| c=='A'||
        c=='E'||c=='I'||c=='O'||c=='U');
    }

    /**
     * Leetcode#532
     */
    public String reverseStr(String s, int k) {
        int count = s.length() /k;
        if(count==0){
            return reverseStr1(s);
        }
        StringBuilder sb=new StringBuilder();
        int i=0;
        boolean b=true;
        while(i<s.length() && count>=0){
            int start = i;
            int end = i+k;
            String temp ="";
            if (end>=s.length()){
                temp = s.substring(start);
            }
            else{
                temp = s.substring(start,end);
            }
            if(b){
                sb.append(reverseStr1(temp));
            }
            else{
                sb.append(temp);
            }
            i+=k;
            b=!b;
            count--;
        }
        return sb.toString();
    }
    public String reverseStr1(String s){
        if(s.isEmpty() || s.length() ==1){
            return s;
        }
        int i=0,j=s.length()-1;
        char[] charArray = s.toCharArray();
        while(i<j){
            char temp = charArray[i];
            charArray[i]=charArray[j];
            charArray[j]=temp;
            i++;
            j--;
        }
        return new String(charArray);
    }

    /**
     * Leetcode#557
     * @param s
     * @return
     */
    public String reverseWords(String s) {
       String []sArray = s.split(" ");
       for(int i=0;i<sArray.length;i++){
           sArray[i] = reverseStr1(sArray[i]);
       }
       return Arrays.stream(sArray).collect(Collectors.joining(" "));
    }
}


/**
 * 321
 * 295
 *457
 * 481
 * 522
 *
 */


