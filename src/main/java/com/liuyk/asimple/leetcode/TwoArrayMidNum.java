package com.liuyk.asimple.leetcode;

/**
 * 2个数组的中位数
 */
public class TwoArrayMidNum {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLength = nums1.length + nums2.length;
        if (totalLength % 2 == 0) {
            //偶数
            int midNumIndex1 = totalLength / 2;
            int midNumIndex2 = midNumIndex1 + 1;

        } else {
            //奇数
            int midNumIndex = totalLength / 2;

        }
    }

}
