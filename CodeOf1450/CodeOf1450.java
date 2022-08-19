package CodeOf1450;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linsvert
 * leetcode 每日一题 【1450.在既定时间内做作业的学生人数】
 * @url https://leetcode.cn/problems/number-of-students-doing-homework-at-a-given-time/
 * @tag
 */
public class CodeOf1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int cnt = 0;
        List<Integer> r = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] == queryTime) {
                cnt++;
            } else if (startTime[i] < queryTime) {
                r.add(i);
            }
        }
        for (int i : r) {
            if (endTime[i] >= queryTime) {
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        CodeOf1450 codeOf1450 = new CodeOf1450();
        System.out.println(codeOf1450.busyStudent(new int[] {1,2,3}, new int[] {3,2,7}, 4));
    }
}
