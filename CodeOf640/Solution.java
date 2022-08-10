package CodeOf640;

import java.util.LinkedList;
import java.util.List;

/**
 * @author linsvert
 * leetcode 每日一题 【640.求解方程】
 * @url https://leetcode.cn/problems/solve-the-equation/
 * @tag 模拟题
 */
public class Solution {
    int x = 0;
    int sum = 0;
    public String solveEquation(String equation) {
        //输入: equation = "2x+25-3+x=6+x-2"
        //输出: "x=2"

        List<String> left = new LinkedList<>();
        List<String> right = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        boolean is = true;
        for (int i = 0; i < equation.length(); i++) {
            char n = equation.charAt(i);
            if (n == '=') {
                left.add(sb.toString());
                sb = new StringBuilder();
                is = false;
                continue;
            }
            if ((n == '-' || n == '+') && sb.toString().length() > 0) {
                if (is) {
                    left.add(sb.toString());
                } else {
                    right.add(sb.toString());
                }
                sb = new StringBuilder();
                sb.append(n);
            } else {
                sb.append(n);
            }
        }
        right.add(sb.toString());
        calc(left, 1);
        calc(right, -1);
        if (x == 0 && sum == 0) {
            return "Infinite solutions";
        } else if (x == 0) {
            return "No solution";
        }
        return "x=" + sum / x;
    }
    public void calc(List<String> c, int is) {
        for (String s : c) {
            int n = s.length();
            int f = 1;
            int num;
            if (s.charAt(0) != '-' && s.charAt(0) != '+') {
                s = "+" + s;
                n++;
            }
            if (s.charAt(0) == '-') {
                f = -1;
            }
            if (s.charAt(n - 1) == 'x') {
                String t = s.substring(1, n - 1);
                if ("".equals(t)) {
                    t = "1";
                }
                num = Integer.parseInt(t);
                x += is * f * num;
            } else {
                num = Integer.parseInt(s.substring(1));
                sum += -1 * is * f * num;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.solveEquation("x+5-3+x=6+x-2"));
        System.out.println(solution.solveEquation("-3x=-3"));
    }
}
