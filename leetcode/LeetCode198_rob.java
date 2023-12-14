/**
 * https://leetcode.cn/problems/house-robber/description/?envType=study-plan-v2&envId=top-interview-150
 * <p>
 * 198. 打家劫舍
 * <p>
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * <p>
 * 动态规划
 */
public class LeetCode198_rob {

    public static void main(String[] args) {
        int[] arr = {2, 1, 1, 2};
        System.out.println(rob(arr));
    }

    //正确案例
    public static int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        int N = nums.length;
        for (int i = 2; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[N];

    }


    /**
     * 错误案例
     *
     * @param nums
     * @return
     */
    public static int rob1(int[] nums) {
        int[] dp = new int[nums.length];
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int N = nums.length;
        if (N == 1) {
            return nums[0];
        }
        dp[0] = nums[0];
        dp[1] = nums[1];
        int ans = Integer.MIN_VALUE;
        if (N == 2) {
            ans = Math.max(dp[0], dp[1]);
        }
        for (int i = 2; i < N; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
            ans = Math.max(dp[i], ans);
        }
        return ans;
    }

}
