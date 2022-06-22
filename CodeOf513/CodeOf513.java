package CodeOf513;

/**
 * @author linsvert
 * leetcode 每日一题 【513.找树左下角的值】
 * @url https://leetcode.cn/problems/find-bottom-left-tree-value/
 * @tag dfs 递归 遍历
 */
public class CodeOf513 {
    public int findBottomLeftValue(TreeNode root) {
        int[] r = findBottomLeftValueDeep(root, 0);
        return r[0];
    }

    public int[] findBottomLeftValueDeep(TreeNode root, int deep) {
        int[] maxDeep = {root.val, deep};
        if (root.left == null && root.right == null) {
            return maxDeep;
        }
        if (root.left != null) {
            int[] result = findBottomLeftValueDeep(root.left, deep + 1);
            if (result[1] > maxDeep[1]) {
                maxDeep = result;
            }
        }
        if (root.right != null) {
            int[] result = findBottomLeftValueDeep(root.right, deep + 1);
            if (result[1] > maxDeep[1]) {
                maxDeep = result;
            }
        }
        return maxDeep;
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
