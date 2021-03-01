package com.liuyk.asimple.leetcode;

/**
 * 链表翻转
 * 1 -> 2 -> 3
 * 3 -> 2 -> 1
 */
public class LinkReverse {

    static class Node<T> {
        Node<T> next;
        T v;

        public Node(T v) {
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

    // 1 -> 2 -> 3

    public static <T> Node<T> reverse(Node<T> head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node<T> pre = null;
        Node<T> cur = head;
        while (cur != null) {
            Node<T> temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {
        LinkReverse.Node<Integer> node0 = new LinkReverse.Node<>(0);
        final LinkReverse.Node<Integer> head = node0;
        for (int i = 1; i < 5; i++) {
            LinkReverse.Node<Integer> node1 = new LinkReverse.Node<>(i);
            node0.next = node1;
            node0 = node1;
        }

        System.out.println(head);
        System.out.println(LinkReverse.reverse(head));
    }



}
