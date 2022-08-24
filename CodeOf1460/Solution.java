package CodeOf1460;

/**
 * @author linsvert
 * leetcode 每日一题 【1460.通过翻转子数组使两个数组相等】
 * @url https://leetcode.cn/problems/make-two-arrays-equal-by-reversing-sub-arrays/
 * @tag
 */
public class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        int n = target.length;
        int num = 0;
        int[] cnt = new int[1010];
        for (int i = 0; i < n; i++) {
            cnt[target[i]]++;
            if (cnt[target[i]] == 1) {
                num++;
            }
            cnt[arr[i]]--;
            if (cnt[arr[i]] == 0) {
                num--;
            }
        }
        return num == 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canBeEqual(new int[]{1, 2, 3, 4}, new int[]{2, 4, 1, 3}));
    }
}
