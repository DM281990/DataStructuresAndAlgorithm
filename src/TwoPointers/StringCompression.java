package TwoPointers;

/**
 * LeetCode443
 */
public class StringCompression {
    public static void main(String[] args) {
        new StringCompression().compress(new char[]{'a','a','b','b','c','c','c'});
    }
    public int compress(char[] chars) {
       int i=0;
       int j=0;
       int size = 0;
       String s="";
       while(j<chars.length){
           while(j<chars.length &&chars[i]==chars[j]){
               j++;
           }
           s+=""+chars[i]+""+(j-i)+"";
           i=j;
           j++;
       }
        chars = null;s.toCharArray();
       return s.length();
    }
}
