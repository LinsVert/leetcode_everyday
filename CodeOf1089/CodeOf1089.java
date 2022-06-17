package CodeOf1089;

import java.util.Arrays;

/**
 * @author linsvert
 * leetcode 每日一题 【1089.复写0】
 * @url https://leetcode.cn/problems/duplicate-zeros/
 * @tag 双指针
 */
public class CodeOf1089 {
    /**
     * 简单遍历 每次换0之后 循环替换 暴力
     * @param arr
     */
    public void duplicateZeros(int[] arr) {
        int[] copy = Arrays.copyOf(arr, arr.length);
        int i = 0;
        while (i < arr.length) {
            int j = i + 1;
            if (copy[i] == 0 && i < arr.length - 1) {
                arr[i + 1] = 0;
                for (;j < arr.length - 1;j++) {
                    arr[j + 1] = copy[j];
                }
                copy = Arrays.copyOf(arr, arr.length);
                i += 2;
            } else {
                i ++;
            }
        }

    }

    /**
     * 双指针 todo
     * @param arr
     */
    public void duplicateZeros2(int[] arr) {
        //[1,0,2,3,0,4,5,0]
        //j = 1, i= 1;j=3,i=2;j=4,i=3;j=6,i=4;j=7,i=5;j=9;i=6
        int i = 0,j = 0, n = arr.length;
        //寻找被截断的位置 因为快慢指针 i j 之差就是被补充0的长度
        while (j < n) {
            if (arr[j] == 0) {
                j ++;
            }
            j++;
            i++;
        }
        //往前走一位 防止j越界

    }

    public static void main(String[] args) {
        CodeOf1089 c = new CodeOf1089();
        int[] arr = {1,0,2,3,0,4,5,0};
        c.duplicateZeros2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
