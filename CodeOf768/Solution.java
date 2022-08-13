package CodeOf768;

import java.util.*;

/**
 * @author linsvert
 * leetcode 每日一题 【768.最多能完成排序的块II】
 * @url https://leetcode.cn/problems/max-chunks-to-make-sorted-ii/
 * @tag 贪心
 */
public class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] cloneA = arr.clone();
        int n = cloneA.length;
        int ans = 0;
        //排序后
        Arrays.sort(arr);
        Map<Integer, Integer> record = new HashMap<>();
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int a = arr[i];
            int b = cloneA[i];
            if (record.getOrDefault(a, 0) == 0) {
                cnt++;
            } else if (record.getOrDefault(a, 0) == -1) {
                cnt--;
            }

            //arr匹配的对应个数+1
            record.put(a, record.getOrDefault(a, 0) + 1);

            if (record.getOrDefault(b, 0) == 1) {
                cnt--;
            } else if (record.getOrDefault(b, 0) == 0) {
                cnt++;
            }
            //
            record.put(b, record.getOrDefault(b, 0) - 1);

            if (cnt == 0) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxChunksToSorted(new int[] {5,4,3,2,1}));
    }
}
