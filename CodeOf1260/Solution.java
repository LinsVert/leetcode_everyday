package CodeOf1260;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        //len = n
        //k 次
        //一般地
        //grid[i][j] => grid[i][j + k]
        //存在 j + k > grid[0].length
        //grid[i + 1][k - n - 1] 如果 i + 1 > grid.length - 1 grid[0][k - n - 1]
        //再一般地
        //k = k % (m * n) => 限制k 循环多次
        //(j + k) / n-1 <= 1 grid[i][j + k]
        //(j + k) / n-1 = t; (j + k) % n = l:
        //(i + t) / m-1 <= 1 grid[i + t][l]
        //(i + t) = y grid[y][l];
        int m = grid.length;
        int n = grid[0].length;
        k = k % (m * n);
        List<List<Integer>> r = new LinkedList<>();
        int[][] record = new int[m][n];
        for (int i = 0; i < m; i ++) {
            for (int j = 0; j < n;j++) {
                int t = (j + k) / n;
                int l = (j + k) % n;
                int z = (i + t) / m;
                int y = (i + t) % m;
                if (t < 1) {
                    record[i][j + k] = grid[i][j];
                } else if (z < 1) {
                    record[i + t][l] = grid[i][j];
                } else {
                    record[y][l] = grid[i][j];
                }
            }
        }
        for (int i = 0; i < m; i ++) {
            r.add(new LinkedList<>());
            for (int j = 0; j < n;j++) {
                r.get(i).add(record[i][j]);
            }
        }
        return r;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] s = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        int k = 1;
        var r = solution.shiftGrid(s, k);
        System.out.println(r);
    }
}
