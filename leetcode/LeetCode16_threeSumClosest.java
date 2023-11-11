import java.util.Arrays;

/**
 * * URL: https://leetcode.cn/problems/3sum/
 * 三数之和
 */
public class LeetCode16_threeSumClosest {

    public static void main(String[] args) {
        int[] arr = {-1, 2, 1, -4};
        int result = threeSumClosest(arr, 1);
        System.out.println(result);
    }

    public static int threeSumClosest(int[] nums, int target) {
        int ans = Integer.MAX_VALUE;
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        int length = nums.length;
        for (int i = 0; i < length - 2; i++) {
            int cur = nums[i];
            int L = i + 1;
            int R = length - 1;
            while (L < R) {
                int twoSum = nums[L] + nums[R];
                int threeSum = cur + twoSum;
                if (Math.abs(threeSum - target) < Math.abs(ans - target)) {
                    ans = threeSum;
                }
                if (threeSum > target) {
                    R--;
                } else if (threeSum < target) {
                    L++;
                } else {
                    return target;
                }
            }
        }
        return ans;
    }


    /**
     * 从begin开始获取2数之和最接近target的数
     *
     * @param nums
     * @param begin
     * @param target
     * @return
     */
//    public static int getTwoSumCLose(int[] nums, int begin, int thisNum, int target) {
//        int ans = Integer.MAX_VALUE;
//        int L = begin;
//        int R = nums.length;
//        while (L < R) {
//            int cur = nums[L] + nums[R];
//            if (cur > target) {
//                ans = Math.min(ans, target - cur);
//            }
//        }
//
//    }

}
