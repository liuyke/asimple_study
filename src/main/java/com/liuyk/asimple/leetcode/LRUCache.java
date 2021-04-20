package com.liuyk.asimple.leetcode;


import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liuyk
 */
public class LRUCache<K, V> {

    private final int capacity;
    private final Map<K, Node<K,V>> map;
    private final Node<K, V> head;
    private final Node<K, V> tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        head = new Node<>();
        tail = new Node<>();
        head.next = tail;
        tail.pre = head;
    }

    public V get(K k) {
        Node<K, V> node = map.get(k);
        if (node == null) {
            return null;
        }
        moveToHead(node);
        return node.v;
    }

    public void put(K k, V v) {
        Node<K, V> node = map.get(k);
        if (node == null) {
            if (map.size() >= capacity) {
                map.remove(tail.pre.k);
                removeTailNode();
            }

            Node<K, V> newNode = new Node<>(k, v);
            map.put(k, newNode);
            addToHead(newNode);
        } else {
            node.v = v;
            moveToHead(head);
        }
    }

    private void removeTailNode() {
        removeNode(tail.pre);
    }

    private void moveToHead(Node<K,V> node) {
        removeNode(node);
        addToHead(node);
    }

    private void addToHead(Node<K,V> node) {
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
    }

    private void removeNode(Node<K, V> node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private class Node<K, V> {
        K k;
        V v;
        Node<K, V> next;
        Node<K, V> pre;

        public Node() {
        }

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<K,V> cur = head.next;
        while (cur != null && cur != tail) {
            sb.append(cur.v).append("->");
            cur = cur.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> cache = new LRUCache<>(5);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.put(4,4);
        cache.put(5,5);
        cache.get(1);
        cache.put(6,6);
        System.out.println(cache);

        List<String> strings = Arrays.asList("D354", "D42", "D88", "D127", "D129", "D164",
                "D189", "D217", "D276", "D289", "D395", "D547", "D701", "D1122", "D1189", "D1322", "D1353",
                "D1374", "D1375", "D1596", "D46", "D462", "D1533", "D1612", "D1613");

        System.out.println(StringUtils.join(strings, ","));

        String str = "{\"D354\",\"D42\",\"D88\",\"D127\",\"D129\",\"D164\",\"D189\",\"D217\",\"D276\",\"D289\",\"D395\",\"D547\",\"D701\",\"D1122\",\"D1189\",\"D1322\",\"D1353\",\"D1374\",\"D1375\",\"D1596\",\"D46\",\"D462\",\"D1533\", \"D1612\", \"D1613\",\"D1831\"}";
        for (String s : str.split(",")) {
            System.out.println(s);
        }

    }

}
