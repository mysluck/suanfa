/**
 * * URL: https://leetcode.cn/problems/trapping-rain-water/?envType=study-plan-v2&envId=top-interview-150
 * 42. 接雨水
 */
public class LeetCode42_trap {

    public static void main(String[] args) {

    }

    public static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        int L = 1;
        int R = height.length - 2;

        int leftHeight = height[0];
        int rightHeight = height[height.length - 1];
        int water = 0;
        while (L <= R) {
            if (leftHeight < rightHeight) {
                water += Math.max(0, leftHeight - height[L]);
                leftHeight = Math.max(leftHeight, height[L++]);
            } else {
                water += Math.max(0, rightHeight - height[R]);
                rightHeight = Math.max(rightHeight, height[R--]);
            }
        }
        return water;
    }

}
