package CodeOf1403;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> r = new LinkedList<>();
        Arrays.sort(nums);
        int n = nums.length;
        if (n == 1) {
            r.add(nums[n - 1]);
            return r;
        }
        int i = 0;
        int j = n - 1;
        int sum1 = 0;
        int sum2 = 0;
        while (i < j) {
            sum1 += nums[i];
            sum2 += nums[j];
            if (sum1 >= sum2) {
                r.add(nums[j]);
                j--;
                sum1 -= nums[i];
            } else {
                i ++;
                sum2 -= nums[j];
            }
        }
        r.add(nums[j]);
        return r;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSubsequence(new int[]{3,4,8,9,10}));
        System.out.println(solution.minSubsequence(new int[]{4,4,7,6,7}));
    }
}
