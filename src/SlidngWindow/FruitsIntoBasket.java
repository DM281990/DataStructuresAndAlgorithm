package SlidngWindow;

import java.util.HashMap;
import java.util.Map;

/**
 * Leetcode#904
 */
public class FruitsIntoBasket {
    public int totalFruit(int[] fruits) {
        int i=0,j=0;
        Map<Integer,Integer> mp = new HashMap<>();
        int size=0;
        while(j<fruits.length){
            mp.compute(fruits[j],(k,val)->val!=null?val+=1:1);
            while (mp.size()>=3){
                mp.compute(fruits[i],(k,val)->val-=1);
                if(mp.get(fruits[i])==0)mp.remove(fruits[i]);
                i++;
            }
            size = Math.max(size,j-i+1);
            j++;
        }
        return size;
    }
}
