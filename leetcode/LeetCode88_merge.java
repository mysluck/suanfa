import java.util.Arrays;

/**
 * https://leetcode.cn/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 * 88. 合并两个有序数组
 */
public class LeetCode88_merge {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};int m=3;
        int[] nums2 = {2,5,6};int n=3;
//        int[] nums1 = {1};int m = 1;
//        int[] nums2 = {};
//        int n = 0;
        merge(nums1, m, nums2, n);
        Arrays.stream(nums1).forEach(System.out::println);
    }

    //思路 短数组从最后有效位置遍历对比swap
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n - 1;
        while (n > 0 && m > 0) {
            if (nums2[n - 1] > nums1[m - 1]) {
                nums1[index--] = nums2[--n];
            } else {
                nums1[index--] = nums1[--m];
            }
        }
        while (m > 0) {
            nums1[index--] = nums1[--m];
        }
        while (n > 0) {
            nums1[index--] = nums2[--n];
        }
    }


    public static void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
}
