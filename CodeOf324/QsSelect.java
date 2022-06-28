package CodeOf324;

import java.util.Arrays;

/**
 * @author linsvert
 */
public class QsSelect {
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
            System.out.println(Arrays.toString(nums));
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
     * 三中类别分布分布
     * @param nums nums
     */
    int[] nums;
    public void threeWayPartition(int[] nums2) {
        nums = nums2;
        //[1,1,2,2,3,3]
        int mid = nums.length >> 1;
        int midValue = findK(nums, mid);
        int i = 0;
        int j=0;
        int k = nums.length - 1;
        while (j < k) {
            if (nums[j] > midValue) {
                //比 midValue 大
                swap(j, k);
                k--;
            } else if (nums[j] < midValue) {
                //比 midValue 小
                //i 被标记了 并且 j
                swap(i, j);
                i++;
                j++;
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

    public static void main(String[] args) {
        QsSelect q = new QsSelect();
        int[] nums = {1,2,1,2,3,3};
        System.out.println("Start:");
        System.out.println(Arrays.toString(nums));
        System.out.println("Sort:");
       q.threeWayPartition(nums);
        System.out.println("End:");
        System.out.println(Arrays.toString(nums));
    }
}
