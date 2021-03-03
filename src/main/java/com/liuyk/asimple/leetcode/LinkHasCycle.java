package com.liuyk.asimple.leetcode;

public class LinkHasCycle {

    static class ListNode<T> {
        ListNode<T> next;
        T v;

        public ListNode(T v) {
            this.v = v;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(v);
            if (next != null) {
                sb.append(" -> ").append(next.toString());
            }
            return sb.toString();
        }
    }

    public static <T> boolean hasCycle(ListNode<T> head) {
        ListNode<T> fastNode = head;
        ListNode<T> slowNode = head;

        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (fastNode == slowNode) {
                return true;
            }
        }

        return false;
    }


}
