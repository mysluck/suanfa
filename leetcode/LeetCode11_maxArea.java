/**
 * * https://leetcode.cn/problems/container-with-most-water/
 * <p>
 * 11. 盛最多水的容器
 */
public class LeetCode11_maxArea {

    public static void main(String[] args) {

        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(arr));
    }

    public static int maxArea(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int ans = 0;
        int L = 0;
        int R = height.length - 1;
        while (L <= R) {
            int lHeight = height[L];
            int rHeight = height[R];
            int shortHeight = Math.min(lHeight, rHeight);
            //左边短 true 左边长 false
            ans = Math.max(ans, (R - L) * shortHeight);
            if (lHeight <= rHeight) {
                L++;
            } else {
                R--;
            }
        }
        return ans;
    }
}
