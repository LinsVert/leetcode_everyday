package CodeOf719;

import java.util.Arrays;

/**
 * @author linsvert
 * leetcode 每日一题 【719.找出第K小第数对距离】
 * @url https://leetcode.cn/problems/find-k-th-smallest-pair-distance/
 * @tag 二分查找 双指针
 */
public class CodeOf719 {

    /**
     * @param nums int[]
     * @param k    int
     * @return int
     */
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0, right = (int) 1e6;
        while(left < right) {
            //left + right / 2
            int mid = left + right >> 1;
            int cnt = 0;
            //i j 双指针 j随着i增加而增加 因为nums递增 所以不需要重置
            for (int i = 0, j = 1; i < nums.length; i++) {
                //查找距离小于mid的个数 while 快速查找
                while (j < nums.length && nums[j] - nums[i] <= mid) {
                    j++;
                }
                //因为递增 所以个数差值数量可以算出来为 j - i - 1
                cnt += j - i - 1;
            }
            if (cnt >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 3}; // 0 2 2
        int k = 2;
        CodeOf719 c = new CodeOf719();
        int r = c.smallestDistancePair(nums, k);
        System.out.println(r);
    }
}