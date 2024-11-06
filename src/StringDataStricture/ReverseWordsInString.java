package StringDataStricture;

/**
 * Leetcode#151
 */
public class ReverseWordsInString {

    public static void main(String[] args) {
        new ReverseWordsInString().reverseWords("the sky is blue");
    }
    public String reverseWords(String s) {
        String []sArray = s.split(" ");
        String returnString = "";
        for (int i=0;i<sArray.length;i++){
            if(sArray[i].trim().equals("")){
                continue;
            }
            returnString= sArray[i].trim()+" "+returnString;
        }
        return returnString.trim();
    }
}
