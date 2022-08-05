package CodeOf623;

/**
 * @author linsvert
 * leetcode 每日一题 【623.在二叉树中增加一行】
 * @url https://leetcode.cn/problems/k-diff-pairs-in-an-array/
 * @tag 二叉树
 */
public class Solution {

    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (root == null) {
            return root;
        }
        if (depth == 1) {
            return new TreeNode(val, root, null);
        }

        if (depth == 2) {
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = new TreeNode(val, left, null);
            root.right = new TreeNode(val, null, right);
            return root;
        }
        root.left = addOneRow(root.left, val, depth - 1);
        root.right = addOneRow(root.right, val, depth - 1);
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
