package SlidngWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcoe#2024
 */
public class MaximizeConfusionOfExam {
    public static void main(String[] args) {
        new MaximizeConfusionOfExam().maxConsecutiveAnswers("TTFTTFTT",
                1);
    }
    public int maxConsecutiveAnswers(String answerKey, int k) {
        Map<Character,Integer> map = new HashMap<>();
        map.put('T',0);
        map.put('F',0);
        for(int i=0;i<answerKey.length();i++)map.compute(answerKey.charAt(i),(key,v)->v+=1);
        if (k >= Math.min(map.get('T'), map.get('F'))) return answerKey.length();
        int maxTrue = getMaxLength(answerKey,'T',k);
        int maxFalse = getMaxLength(answerKey,'F',k);
        return Math.max(maxFalse,maxTrue);
    }

    private int getMaxLength(String answerKey,char ch,int k) {
        int i=0,j=0;
        int result=0;
        while(j<answerKey.length()){
            if(answerKey.charAt(j)!=ch)
                k--;
            while (k<0){
                if(answerKey.charAt(i)!=ch)
                    k++;
                i++;
            }
            result =Math.max(result,j-i+1);
            j++;
        }
        return result;
    }
}
