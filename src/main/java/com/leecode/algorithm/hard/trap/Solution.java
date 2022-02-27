package src.main.java.com.leecode.algorithm.hard.trap;

class Solution {
    public int trap(int[] height) {
        int water  = 0;
        int max    = 0;
        int maxVal = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxVal) {
                maxVal = height[i];
                max = i;
            }
        }
        int init   = 0;
        for (int i = 0; i < max; i++) {
            if (height[i] > init) {
                init = height[i];
            } else {
                water += init - height[i];
            }
        }
        init   = 0;
        for (int i = height.length - 1; i > max; i--) {
            if (height[i] > init) {
                init = height[i];
            } else {
                water += init - height[i];
            }
        }
        return water;
    }
}