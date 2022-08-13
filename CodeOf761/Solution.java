package CodeOf761;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author linsvert
 * leetcode 每日一题 【761.特殊的二进制序列】
 * @url https://leetcode.cn/problems/special-binary-string/
 * @tag
 */
public class Solution {
    public String makeLargestSpecial(String s) {
        if (s.length() == 0) {
            return s;
        }
        List<String> list = new ArrayList<>();
        char[] chars = s.toCharArray();
        for (int i = 0,j=0,k=0;i < s.length();i++) {
            k += chars[i] == '1' ? 1 : -1;
            if (k == 0) {
                //k = 0 一定有10结构
                list.add("1" + makeLargestSpecial(s.substring(j + 1, i)) + "0");
                j = i + 1;
            }
        }
        list.sort((a, b) -> (a + b).compareTo(b + a));
        StringBuilder sb = new StringBuilder();
        for (String ss : list) {
            sb.append(ss);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.makeLargestSpecial("11011000"));
    }
}
