/**
 * * URL: https://leetcode.cn/problems/jump-game/?envType=study-plan-v2&envId=top-interview-150
 * 55. 跳跃游戏
 */
public class LeetCode55_canJump {

    public static void main(String[] args) {

    }

    public static boolean canJump(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int max = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
            } else {
                return false;
            }
        }
        return true;

    }


}
