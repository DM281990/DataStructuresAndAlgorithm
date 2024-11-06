package TwoPointers;

/**
 * Leecode#167
 */
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
        int i=0;
        int j = numbers.length-1;
        int []result = new int[2];
        while(i<j){
            if(numbers[i]+numbers[j] == target){
                result[0]=i+1;
                result[1]=j+1;
                break;
            }
            else if(numbers[i]+numbers[j] < target){
                i++;
            }
            else{
                j--;
            }
        }
        return result;
    }
}
