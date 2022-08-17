package CodeOf1302;

/**
 * @author linsvert
 * leetcode 每日一题 【1302.层数最深子节点的和】
 * @url https://leetcode.cn/problems/deepest-leaves-sum/
 * @tag
 */
public class Solution {

    int deepM = 1;
    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
         deepestLeavesSum(root, 1);
         return sum;
    }
    public void deepestLeavesSum(TreeNode root, int deep) {
        if (root == null) {
           return;
        }
        if (deep == deepM) {
            if (root.left != null || root.right != null) {
                deepM ++;
                sum = 0;
            } else {
                sum += root.val;
            }
        }

        deepestLeavesSum(root.left, deep + 1);
        deepestLeavesSum(root.right, deep + 1);
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
        }
    }

}
