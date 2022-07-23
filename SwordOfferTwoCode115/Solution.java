package SwordOfferTwoCode115;

import java.util.*;

/**
 * @author linsvert
 * leetcode 每日一题 【剑指 Offer II 115.重建序列】
 * @url https://leetcode.cn/problems/ur2n8P/
 * @tag 拓扑排序 有向无环图「DAG」
 */
public class Solution {
    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        //限制1： sequences 组合出来的超序列 最短
        //限制2： 最短超序列 唯一
        //限制3： nums 是 [1,n] 的排列组合
        //每个点度数的记录 默认全部点度数为0
        int[] ro = new int[nums.length + 1];
        //各个边的关联
        Map<Integer, Set<Integer>> rel = new HashMap<>();
        for (int[] sequence : sequences) {
            for (int i = 1; i < sequence.length; i++) {
                int from = sequence[i - 1];
                int to = sequence[i];
                //把边关联上
                rel.putIfAbsent(from, new HashSet<>());
                rel.get(from).add(to);
                //将 to这个点度数+1 意思是它有前置依赖 即 依赖from
                ro[to]++;
            }
        }
        //使用队列优先消费度数为0 即成排序
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i < ro.length;i++) {
            if (ro[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            //度数为0的只能有一个 有多个说明路径不唯一
            if (queue.size() > 1) {
                return false;
            }
            Integer poll = queue.poll();
            Set<Integer> to = rel.getOrDefault(poll, new HashSet<>());
            for (Integer next : to) {
                ro[next] --;
                if (ro[next] == 0) {
                    queue.offer(next);
                }
            }
        }
        return true;

    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int[][] sequences = {{1, 2}, {1, 3}};
        Solution solution = new Solution();
        System.out.println(solution.sequenceReconstruction(nums, sequences));
    }
}
