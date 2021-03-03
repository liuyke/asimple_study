package com.liuyk.asimple.leetcode;

import java.util.List;

public class LinkAddTwoSumNum {

    static class ListNode {
        public ListNode next;
        public int val;

        public ListNode(int v) {
            this.val = v;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(val);
            if (next != null) {
                sb.append(" -> ").append(next.toString());
            }
            return sb.toString();
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode cur = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;

            carry = sum / 10;

            ListNode sumNode = new ListNode(sum % 10);
            cur.next = sumNode;
            cur = sumNode;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return dummyHead.next;
    }

}
