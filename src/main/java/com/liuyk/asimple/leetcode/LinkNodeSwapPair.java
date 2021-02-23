package com.liuyk.asimple.leetcode;

public class LinkNodeSwapPair<T> {

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

    public static <T> Node<T> swapPairs(Node<T> head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node<T> next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;

        return next;
    }

    public static void main(String[] args) {
        Node<Integer> node0 = new Node<>(0);
        final Node<Integer> head = node0;
        for (int i = 1; i < 30; i++) {
            Node<Integer> node1 = new Node<>(i);
            node0.next = node1;
            node0 = node1;
        }

        System.out.println(head);
        System.out.println(swapPairs(head));
    }

}
