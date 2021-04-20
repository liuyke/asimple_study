package com.liuyk.asimple.leetcode;

public class FrogJump {

    public int numWays(int n) {
        int pre = 1, cur = 1, sum = 0;
        for (int i = 0; i < n; i++) {
            sum = (pre + cur) % 1_000_000_007;
            pre = cur;
            cur = sum;
        }
        return pre;
    }

}
