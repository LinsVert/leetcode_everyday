package CodeOf814;

/**
 * @author linsvert
 * leetcode 每日一题 【814.二叉树剪枝】
 * @url https://leetcode.cn/problems/binary-tree-pruning/
 * @tag 递归
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = pruneTree(root.left);
        TreeNode right = pruneTree(root.right);
        if (left == null || left.val == 0 && left.left == null && left.right == null) {
            root.left = null;
        }
        if (right == null || right.val == 0 && right.left == null && right.right == null) {
            root.right = null;
        }
        if (root.left == null && root.right == null && root.val == 0) {
            root = null;
        }
        return root;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
