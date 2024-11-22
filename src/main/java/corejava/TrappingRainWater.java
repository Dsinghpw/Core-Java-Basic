package corejava;

public class TrappingRainWater {
    public static void main(String[] args) {

        int[] height = {0, 1, 0, 3, 0, 1, 0, 4, 0, 2};
        System.out.println("Trapped Water: " + trap(height));

        int[] height1 = {3,-2,1,0,2,0,5};
        System.out.println("Trapped Water for negative : " + trap(height1));
    }

    public static int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int n = height.length;
        int totalWater = 0;

        for (int i = 1; i < n; i++) {
            if(height[i]<0){
                totalWater =-height[i] +totalWater;
                height[i]=0;
            }
        }

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];


        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }


        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }



        for (int i = 0; i < n; i++) {
            totalWater += Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return totalWater;

    }
}
