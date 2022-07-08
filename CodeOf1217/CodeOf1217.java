package CodeOf1217;

/**
 * @author linsvert
 * leetcode 每日一题 【1217.玩筹码】
 * @url https://leetcode.cn/problems/minimum-cost-to-move-chips-to-the-same-position/
 * @tag 找规律
 */
public class CodeOf1217 {
    public int minCostToMoveChips(int[] position) {
        int even = 0;
        int odd = 0;
        for (int k : position) {
            int mod = k % 2;
            even += mod == 1 ? 0 : 1;
            odd += mod;
        }
        return Math.min(even, odd);
    }

    public static void main(String[] args) {
        CodeOf1217 codeOf1217 = new CodeOf1217();
        int[] position = {1,1000};
        System.out.println(codeOf1217.minCostToMoveChips(position));
    }
}
