package SwordOfferTwoCode091;

/**
 * @author linsvert
 * leetcode 每日一题 【剑指 Offer II 091.粉刷房子】
 * @url https://leetcode.cn/problems/JEj789/
 * @tag dp 状态机
 */
public class SwordOfferTwoCode091 {

    /**
     * 基本的dp 存任意i的状态
     * @param costs costs
     * @return int
     */
    public int minCost(int[][] costs) {
        int n = costs.length;
        int[][] dp = new int[n][3];

        for (int i = 0; i < n;i++) {
            if (i == 0) {
                dp[i][0] = costs[i][0];
                dp[i][1] = costs[i][1];
                dp[i][2] = costs[i][2];
            } else {
                dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = costs[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
                dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
        }
        return Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
    }

    /**
     * 简单状态机dp 只存上一个i的状态
     * @param costs costs
     * @return int
     */
    public int minCost2(int[][] costs) {
        int n = costs.length;
        int r = costs[0][0];
        int b = costs[0][1];
        int g = costs[0][2];
        for (int i = 1; i < n;i++) {
            int r1 = Math.min(b, g) + costs[i][0];
            int b1 = Math.min(r, g) + costs[i][1];
            int g1 = Math.min(b, r) + costs[i][2];
            r = r1;b = b1;g=g1;
        }
        return Math.min(Math.min(r, g), b);
    }
}
