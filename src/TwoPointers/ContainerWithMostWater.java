package TwoPointers;
//LeetCode#11
public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(new ContainerWithMostWater().maxArea(new int[]{1}));

    }
    public int maxArea(int[] height) {
        int i =0;
        int j= height.length-1;
        int result =0;
        while(i<j){
            result = Math.max((j-i)*Math.min(height[i],height[j]),result);
            if(height[i]<height[j]){
                i++;
            }
            else if(height[j]<height[i]){
                j--;
            }
            else{
                i++;
                j--;
            }
        }
        return result;
    }
}
