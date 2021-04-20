package com.liuyk.asimple.leetcode;

/**
 * 链表倒数第K个
 */
public class LinkLastK {

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

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode cur = head;

        int size = getSize(head);
        System.out.println("size:" + size);
        int lastK = size - k;
        System.out.println("lastK:" + lastK);

        while (lastK -- > 0) {
            cur = cur.next;
        }
        return cur;
    }

    private int getSize(ListNode head) {
        if (head == null) {
            return 0;
        }
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }


    public static void main(String[] args) {
        ListNode node0 = new ListNode(0);
        final ListNode head = node0;
        for (int i = 1; i < 5; i++) {
            ListNode node1 = new ListNode(i);
            node0.next = node1;
            node0 = node1;
        }
        System.out.println(head);
        System.out.println(new LinkLastK().getKthFromEnd(head, 3));
    }

}
