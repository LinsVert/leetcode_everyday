package CodeOf871;

import java.util.PriorityQueue;

/**
 * @author linsvert
 * leetcode 每日一题 【871.最低加油次数】
 * @url https://leetcode.cn/problems/minimum-number-of-refueling-stops/
 * @tag
 */
public class CodeOf871 {
    /**
     * 动态规划
     * @param target target
     * @param startFuel startFuel
     * @param stations stations
     * @return int
     */
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        //dp[i] => 加油i次能到达最远的距离
        //dp[i + 1] = Max{dp[i + 1], dp[i] + loc}
        //dp[0] = startFuel
        long[] dp = new long[stations.length + 1];
        dp[0] = startFuel;
        //所能到达的最远距离
        for (int i = 0; i < stations.length; i++) {
            for (int j = i;j >=0; j --) {
                //求 到达 加油站 i  加油 j + 1 次所能达到的最远距离
                //当前能到距离一定大于加油站的位置
                //求 dp[j + 1] => 防止 dp[j + 1] 因 stations[j][1] 重复计算 所以要 从大往小
                if (dp[j] >= stations[i][0]) {
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
                }
            }
        }
        //寻找第 i 次加油能到达 >= target
        for (int i = 0;i <= stations.length;i++) {
            if (dp[i] >= target) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 优先队列
     * @param target target
     * @param startFuel startFuel
     * @param stations stations
     * @return int
     */
    public int solution(int target, int startFuel, int[][] stations) {
        //优先队列 油量优先
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        int n = stations.length;
        int r = 0;
        int loc = 0;
        //加队列下标记
        int idx = 0;
        while (loc < target) {
            //没油的时候判断
            if (startFuel == 0) {
                if (!q.isEmpty()) {
                    //加一次油
                    r ++;
                    startFuel = q.poll();
                } else {
                    return -1;
                }
            }
            loc += startFuel;
            startFuel = 0;
            //添加队列 油站位置小于当前位置距离近
            while (idx < n && stations[idx][0] <= loc) {
                q.add(stations[idx][1]);
                idx++;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        CodeOf871 c = new CodeOf871();
        int target = 100;
        int startFuel = 50;
        int[][] stations = {{25,25}, {50,50}};
        System.out.println(c.minRefuelStops(target, startFuel, stations));
    }
}
