/**
 * * URL:https://leetcode.cn/problems/search-in-rotated-sorted-array/?envType=study-plan-v2&envId=top-interview-150
 * 33. 搜索旋转排序数组
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
