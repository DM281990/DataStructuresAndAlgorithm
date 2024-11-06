package TwoPointers;

/**
 * LeetCode#42
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        new TrappingRainWater().trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
    public int trap(int[] height) {
        int[]maxLeft=new int[height.length];
        int[] maxRight = new int[height.length];
        for(int i=0;i<height.length;i++){
            if(i==0){
                maxLeft[i]=height[i];
                maxRight[height.length-1-i]=height[height.length-1];
            }
            else{
                maxLeft[i]= Math.max(maxLeft[i-1],height[i]);
                maxRight[height.length-1-i] = Math.max(maxRight[height.length-i],height[height.length-i-1]);
            }
        }
        int area =0;
        for (int i=0;i<height.length;i++){
            area+=(Math.min(maxRight[i],maxLeft[i])-height[i]);
        }
        return area;
    }

}
