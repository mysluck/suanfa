/**
 * * https://leetcode.cn/problems/search-in-rotated-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 * 33. 搜索旋转排序数组
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 */
public class LeetCode34_searchRange {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3};
        int sea = 2;
        int[] ints = searchRange(arr, sea);
        System.out.println(ints);
    }

    //二分查找 查询>=x最左 <=x最右
    public static int[] searchRange(int[] nums, int target) {
        return new int[]{left(nums, target), right(nums, target)};
    }


    //二分查找 查询=x最左
    public static int left(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int ans = -1;
        int L = 0;
        int R = nums.length - 1;
        while (L <= R) {
            int M = L + ((R - L) >> 1);
            if (target == nums[M]) {
                ans = M;
                R = M - 1;
            } else if (target <= nums[M]) {
                R = M - 1;
            } else {
                L = M + 1;
            }

        }
        return ans;
    }

    // =x最右
    public static int right(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int ans = -1;
        int L = 0;
        int R = nums.length - 1;
        while (L <= R) {
            int M = L + ((R - L) >> 1);
            if (target == nums[M]) {
                ans = M;
                L = M + 1;
            } else if (target >= nums[M]) {
                L = M + 1;
            } else {
                R = M - 1;
            }

        }
        return ans;
    }


}
