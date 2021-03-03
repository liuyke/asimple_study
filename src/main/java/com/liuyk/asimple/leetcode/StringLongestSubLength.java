package com.liuyk.asimple.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 字符串最大子串长度
 */
public class StringLongestSubLength {


    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> map = new HashMap<>();
        int k = -1;
        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer indexC = map.get(c);
            if (indexC != null && indexC > k) {
                k = indexC;
            } else {
                maxLength = Math.max(maxLength, i - k);
            }
            map.put(c, i);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(StringLongestSubLength.lengthOfLongestSubstring(""));
    }

}
