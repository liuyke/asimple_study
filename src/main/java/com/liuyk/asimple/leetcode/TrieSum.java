package com.liuyk.asimple.leetcode;

import java.util.Map;
import java.util.TreeMap;

/**
 * 前缀树求和
 * 比如：
 * app 2
 * apple 3
 * application 4
 *
 * 输入app，输出9
 * 输入appl， 输出7
 *
 */
public class TrieSum {

    private Node root = new Node();

    private class Node {
        public int value;
        public Map<Character, Node> next;

        public Node() {
            next = new TreeMap<>();
        }

        public Node(int value) {
            this.value = value;
            next = new TreeMap<>();
        }
    }

    public void add(String word, int value) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }

        cur.value = value;
    }

    public int sum(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }

        return sum(cur);
    }

    private int sum(Node node) {
        int res = node.value;
        for (Character c : node.next.keySet()) {
            res += sum(node.next.get(c));
        }
        return res;
    }

    public static void main(String[] args) {
        TrieSum trieSum = new TrieSum();
        trieSum.add("apple", 3);
        trieSum.add("app", 2);
        trieSum.add("application", 6);

        System.out.println(trieSum.sum("app"));
    }


}
