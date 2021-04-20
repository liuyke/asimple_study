package com.liuyk.asimple.leetcode;

/**
 * 回文数字
 */
public class PalindromeNum {

    public static boolean isPalindrome(int x) {
        int a = x;
        System.out.println(a);
        int res = 0;
        for (; x > 0; x /= 10) {
            res = res * 10 + x % 10;
            System.out.println(res);
        }
        return res == a;
    }


}
