package CodeOf324;

import java.util.Arrays;

/**
 * @author linsvert
 * leetcode 每日一题 【324.摆动排序II】
 * @url https://leetcode.cn/problems/wiggle-sort-ii/
 * @tag dfs 递归 遍历
 */
public class CodeOf324 {
    /**
     * 双指针，O(nlogn) 时间复杂度, O(n) 空间
     * @param nums nums
     */
    public void wiggleSort(int[] nums) {
        int[] clone = nums.clone();
        Arrays.sort(clone);
        int n = nums.length;
        int left = (n - 1) / 2;
        int right = n - 1;
        //双指针 交替放下对应下标排序的值
        for (int i = 0; i < n; i ++) {
            if (i % 2 == 0) {
                //偶数下标放置 小的
                nums[i] = clone[left];
                left--;
            } else {
                nums[i] = clone[right];
                right--;
            }
        }
    }

    int[] nums;
    /**
     * O(n) 时间复杂度 O(1)空间复杂度
     * @param nums2 nums
     */
    public void wiggleSort2(int[] nums2) {
        nums = nums2;
        //进行选择排序后 分类成 [a,a,a,b,b,b,c,c,c]的结构
        threeWayPartition();

    }

    /**
     * 三分类基本代码 拓展版本为 数学公式奇偶标记
     */
    public void threeWayPartition() {
        int mid = 1 + nums.length >> 1;
        int midValue = findK(nums, mid);
        int i = 0;
        int j=0;
        int k = nums.length - 1;
        while (j <= k) {
            if (nums[getIndex(j)] > midValue) {
                //如果这个数比中间值大 需要把大的值优先放到前面
                swap(getIndex(j), getIndex(i));
                i++;
                j++;
            } else if (nums[getIndex(j)] < midValue) {
                //小的 后置
                swap(getIndex(k), getIndex(j));
                k--;
            }  else {
                //相等的时候不交换
                j++;
            }
        }
    }



    public void swap(int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public int partition(int[] nums, int begin, int end) {
        int pivot = nums[begin];
        while (begin < end) {
            while (begin < end && nums[end] >= pivot) {
                end --;
            }
            nums[begin] = nums[end];
            while (begin < end && nums[begin] <= pivot) {
                begin ++;
            }
            nums[end] = nums[begin];
        }
        nums[begin] = pivot;
        return begin;
    }
    public int findK(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int pivotIndex = 0;
        while (left <= right) {
            //第k小
            pivotIndex = partition(nums, left, right);
            if (pivotIndex == n - k) {
                break;
            }
            if (pivotIndex > n - k) {
                right = pivotIndex;
            } else {
                left = pivotIndex + 1;
            }
        }
        return nums[pivotIndex];
    }

    /**
     * 获取奇偶下标记
     * @param i
     * @return
     */
    private int getIndex(int i) {
        return (1 + 2 * i) % (nums.length | 1);
    }
}
