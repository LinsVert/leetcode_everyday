package CodeOf1282;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author linsvert
 * leetcode 每日一题 【1282.用户分组】
 * @url https://leetcode.cn/problems/group-the-people-given-the-group-size-they-belong-to/
 * @tag 模拟
 */
public class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Map<Integer, List<Integer>> group = new HashMap<>();
        for (int i = 0; i< groupSizes.length;i++) {
            group.putIfAbsent(groupSizes[i], new ArrayList<>());
            group.get(groupSizes[i]).add(i);
        }
        List<List<Integer>> r = new ArrayList<>();
        for (Integer g : group.keySet()) {
            List<Integer> t = group.get(g);
            for (int i = 0;i < t.size() / g;i ++) {
                int from = i * g;
                int to = (i + 1) * g;
                r.add(group.get(g).subList(from, to));
            }

        }
        return r;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.groupThePeople(new int[]{2,1,3,3,3,2}));
    }
}
