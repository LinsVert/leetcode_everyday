package CodeOf515;

import java.util.*;

/**
 * @author linsvert
 * leetcode 每日一题 【515.在每棵树行中寻找最大值】
 * @url https://leetcode.cn/problems/find-largest-value-in-each-tree-row/
 * @tag dfs bfs
 */
public class CodeOf515 {

    Map<Integer, Integer> deppMax = new HashMap<>();
    public List<Integer> largestValues(TreeNode root) {
        dfs(root, 0);
        List<Integer> r = new ArrayList<>();
        for (Integer key : deppMax.keySet()) {
            r.add(deppMax.get(key));
        }
        return r;
    }

    /**
     * dfs 深度搜索
     * @param root
     * @param deep
     */
    public void dfs(TreeNode root, int deep) {
        if (root == null) {
            return;
        }
        if (deep >= deppMax.size() || root.val > deppMax.get(deep)) {
            deppMax.put(deep, root.val);
        }
        dfs(root.left, deep + 1);
        dfs(root.right, deep + 1);
    }

    List<Integer> bfs = new ArrayList<>();
    Queue<TreeNode> queue = new LinkedList<>();
    /**
     * bfs 广度搜索
     *
     */
    public void bfs() {
        if (queue.isEmpty()) {
            return;
        }
        int max = Integer.MIN_VALUE;
        int nowSize = queue.size();
        while (nowSize > 0) {
            TreeNode node = queue.poll();
            if (max < node.val) {
                max = node.val;
            }
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
            nowSize--;
        }
        bfs.add(max);
        bfs();
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
