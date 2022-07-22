package CodeOf757;


import java.util.Arrays;

/**
 * @author linsvert
 * leetcode 每日一题 【757.设置交集大小至少为2】
 * @url https://leetcode.cn/problems/set-intersection-size-at-least-two/
 * @tag 贪心算法
 */
public class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int n = intervals.length;
        System.out.println(Arrays.deepToString(intervals));
        //交集数量
        int pos = 2;
        //最小交集长度
        int ans = 2;
        //从大往小看：
        int cur = intervals[n - 1][0];
        int next = cur + 1;
        for (int i = n - 2; i >= 0; i--) {
            if (intervals[i][1] >= next) {
                continue;
            } else if (intervals[i][1] < cur) {
                ans += 2;
                next = intervals[i][0] + 1;
            } else {
                //=0 的情况
                ans ++;
                next = cur;
            }
            cur = intervals[i][0];
        }
        return ans;
    }

    public static void main(String[] args) {
        //[[1, 3], [1, 4], [2, 5], [3, 5]]
        int[][] intervals = {{1, 3}, {1, 4}, {2, 5}, {3, 5}};
        Solution solution = new Solution();
        System.out.println(solution.intersectionSizeTwo(intervals));
    }

}
