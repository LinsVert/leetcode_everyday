package CodeOf873;

import java.util.HashMap;
import java.util.Map;

/**
 * @author linsvert
 * leetcode 每日一题 【873.最长的斐波那契子序列的长度】
 * @url https://leetcode.cn/problems/length-of-longest-fibonacci-subsequence/
 * @tag
 */
public class CodeOf873 {
    int max = 0;
    int[][] dp;
    Map<Integer, Integer> record = new HashMap<>();

    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        //dp
        //条件1: X_1 + X_2 = X_3
        //条件2: arr 严格递增
        //dp[i][j] arr[i] arr[j] 结尾时的最大长度
        //dp[1][2] = dp[arr[j] - arr[i]][i] + 1
        //状态转移方程: dp[i][j] = Max{3, dp[j][arr[i] - [j]] + 1}
        dp = new int[n][n - 1];
        for (int i = 0; i < arr.length; i++) {
            record.put(arr[i], i);
        }
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0 && j + 2 > max; j--) {
                int t = record.getOrDefault(arr[i] - arr[j], -1);
                if (t == -1 || j <= t) {
                    continue;
                }
                dp[i][j] = Math.max(3, dp[j][t] + 1);
                max= Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        CodeOf873 codeOf873 = new CodeOf873();
        int[] arr = {1,2,4};
        System.out.println(codeOf873.lenLongestFibSubseq(arr));
    }
}
