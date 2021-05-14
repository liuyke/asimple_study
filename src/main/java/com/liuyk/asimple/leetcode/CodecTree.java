package com.liuyk.asimple.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class CodecTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }

        StringBuilder res = new StringBuilder("");
        Queue<TreeNode> queue = new LinkedList<TreeNode>() { {add(root);}};
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode != null) {
                res.append(treeNode.val).append(",");
                queue.add(treeNode.left);
                queue.add(treeNode.right);
            } else {
                res.append("null,");
            }
        }

        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    public TreeNode deserialize(String data) {
        if ("".equals(data)) {
            return null;
        }
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<TreeNode>() { {add(root);}};
        int i = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            String val = values[i++];
            if (!"null".equals(val)) {
                node.left = new TreeNode(Integer.parseInt(val));
                queue.add(node.left);
            }
            val = values[i++];
            if (!"null".equals(val)) {
                node.right = new TreeNode(Integer.parseInt(val));
                queue.add(node.right);
            }

        }
        return root;
    }

}
