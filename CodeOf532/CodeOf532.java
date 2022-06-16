package CodeOf532;

import java.util.Arrays;

/**
 * @author linsvert
 * leetcode 每日一题 【532.数组中的 k-diff 数对】
 * @url https://leetcode.cn/problems/k-diff-pairs-in-an-array/
 * @tag
 */
public class CodeOf532 {

    /**
     *
     * @param nums int[]
     * @param k int
     * @return int
     */
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt = 0;
        int lastI = (int) 1e7 + 1;
        for (int i = 0; i < nums.length - 1; i++) {
            int lastJ = (int) 1e7 + 1;
            for (int j = i + 1; j < nums.length; j++) {
                if (lastI != nums[i] && lastJ != nums[j] && nums[j] - nums[i] == k) {
                    cnt ++;
                } else if (nums[j] - nums[i] > k) {
                    break;
                }
                lastJ = nums[j];
            }
            lastI = nums[i];
        }
        return cnt;
    }
}
