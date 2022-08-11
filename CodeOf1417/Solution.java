package CodeOf1417;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linsvert
 * leetcode 每日一题 【1417.重新格式化字符串】
 * @url https://leetcode.cn/problems/reformat-the-string/
 * @tag 模拟题
 */
public class Solution {
    public String reformat(String s) {
        char[] c = s.toCharArray();
        List<Character> c1 = new ArrayList<>();
        List<Character> c2 = new ArrayList<>();
        int diff = 0;
        for (char value : c) {
            if (value >= '0' && value <= '9') {
                diff++;
                c1.add(value);
            } else {
                c2.add(value);
                diff--;
            }
        }
        if (Math.abs(diff) > 1) {
            return "";
        }
        char[] nc = new char[c.length];
        int k = 0;
        if (diff < 0) {
            List<Character> t = c1;
            c1 = c2;
            c2 = t;
        }
        for (int i = 0; i < nc.length; i += 2) {
            nc[i] = c1.get(k);
            k++;
        }
        k = 0;
        for (int i = 1; i < nc.length; i += 2) {
            nc[i] = c2.get(k);
            k++;
        }

        return new String(nc);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reformat("abcd123"));
    }
}
