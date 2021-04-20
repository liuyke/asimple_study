package com.liuyk.asimple.leetcode;

/**
 * 二叉树第k个大的数
 */
public class KthTreeNode {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    int k;
    int result;

    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        kthLargest(root);
        return this.result;
    }

    private void kthLargest(TreeNode node) {
        if (node == null) {
            return;
        }

        kthLargest(node.right);

        if (--k <= 0) {
            this.result = node.val;
            return;
        }

        kthLargest(node.left);
    }

}
