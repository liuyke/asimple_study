package com.liuyk.asimple.leetcode;

public class TreeToDoubleLink {

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node left, Node right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    class Solution {
        Node head, pre;

        public Node treeToDoublyList(Node root) {
            if (root == null) {
                return null;
            }
            dfs(root);
            head.left = pre;
            pre.right = head;
            return head;
        }

        private void dfs(Node root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            if (pre == null) {
                head = root;
                pre = head;
            } else {
                pre.right = root;
                root.left = pre;
                pre = root;
            }
            dfs(root.right);
        }

    }
    /*
    class Solution {
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    void dfs(Node cur) {
        if(cur == null) return;
        dfs(cur.left);
        if(pre != null) pre.right = cur;
        else head = cur;
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }
}
     */

}
