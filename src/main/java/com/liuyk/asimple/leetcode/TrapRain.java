package com.liuyk.asimple.leetcode;

/**
 * 接雨水
 */
public class TrapRain {

    public int trap(int[] height) {
        int ans = 0;
        int left = 0, right = height.length - 1;
        int leftMax = 0, rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                ans += leftMax - height[left];
                ++left;
            } else {
                ans += right - height[right];
                --right;
            }
        }
        return ans;
    }

}
