package CodeOf1413;

import java.util.function.Supplier;

/**
 * @author linsvert
 * leetcode 每日一题 【1413.逐步求和得到正数的最小值】
 * @url https://leetcode.cn/problems/minimum-value-to-get-positive-step-by-step-sum/
 * @tag
 */
public class Solution {
    public int minStartValue(int[] nums) {
        int min = 1;
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum < 0) {
                min = Math.max(min, sum * -1 + 1);
            }
            sum += nums[i];
        }
        if (sum < 0) {
            min = Math.max(min, sum * -1 + 1);
        }
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minStartValue(new int[]{-5,-2,4,4,-2}));
    }
}
