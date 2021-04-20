package com.liuyk.asimple.leetcode;

/**
 * 合并2个链表
 */
public class MergeTwoLink {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode pre = dummyHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                pre.next = l1;
                l1 = l1.next;
            } else {
                pre.next = l2;
                l2 = l2.next;
            }
            pre = pre.next;
        }

        if (l1 != null) {
            pre.next = l1;
        }

        if (l2 != null) {
            pre.next = l2;
        }

        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = generateNode(5);
        ListNode listNode2 = generateNode(3);

        System.out.println(listNode1);
        System.out.println(listNode2);

        ListNode listNode = new MergeTwoLink().mergeTwoLists(listNode1, listNode2);
        System.out.println(listNode);
    }

    private static ListNode generateNode(int num) {
        ListNode node0 = new ListNode(0);
        final ListNode head = node0;
        for (int i = 1; i < num; i++) {
            ListNode node1 = new ListNode(i);
            node0.next = node1;
            node0 = node1;
        }
        return head;
    }


}
