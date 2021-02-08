package com.liuyk.asimple.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] array, int target) {
        if (array == null || array.length < 2) {
            return null;
        }

        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            int value = target - array[i];
            Integer index = valueIndexMap.get(value);
            if (index != null) {
                return new int[]{index, i};
            }
            valueIndexMap.put(array[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] as = new int[]{1,5,7,99,2};
        int[] ints = twoSum(as, 9);
        System.out.println(Arrays.toString(ints));
    }

}
