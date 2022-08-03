package CodeOf899;

import java.util.Arrays;

/**
 * @author linsvert
 * leetcode 每日一题 【899.有序队列】
 * @url https://leetcode.cn/problems/orderly-queue/
 * @tag 排序 最小表示法
 */
public class Solution {
    public String orderlyQueue(String s, int k) {
        char[] chars = s.toCharArray();
        if (k > 1) {
            //对于 chars[i + p] > chars[j + p] 说明 在 i ~ i + p 区间内没有比 j + p 更小的字符串了
            int i = 0;
            int j = 1;
            int p = 0;
            int n = chars.length;
            while (i < n && j < n && p < n) {
                // (i + p) % n 相当于把它数组变成一个循环队列
                char a = chars[(i + p) % n];
                char b = chars[(j + p) % n];
                if (a == b) {
                    p++;
                } else {
                    if (a > b) {
                        i += p + 1;
                    } else {
                        j += p + 1;
                    }
                    //i j 相同 j++
                    if (i == j) {
                        j++;
                    }
                    //重置p 起点
                    p = 0;
                }
            }
            //取 i, j 最小的那个
            i = Math.min(i, j);
            return s.substring(i) + s.substring(0, i);
        } else {
            //k > 1 说明字符能够任意排序
            Arrays.sort(chars);
            return String.valueOf(chars);
        }
    }
}
