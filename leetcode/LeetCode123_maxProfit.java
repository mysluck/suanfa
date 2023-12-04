/**
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/?envType=study-plan-v2&envId=top-interview-150
 * <p>
 * 123. 买卖股票的最佳时机 III
 * <p>
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class LeetCode123_maxProfit {

    public static void main(String[] args) {
        int[] a = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(maxProfit(a));
    }

    /**
     * 1、获取第i天最大收益
     * <p>
     * 1.1 当前prices[i]-min
     * 1.2 第i-1最好收益
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }
        //最小值
        int min = prices[0];
        //到i-1的最好收益 +当前步骤为最好
        int bestNow = -prices[0];
        //到最好收益
        int curBest = 0;
        int ans = 0;

        for (int i = 1; i < prices.length; i++) {
            ans = Math.max(ans, bestNow + prices[i]);
            min = Math.min(prices[i], min);

            curBest = Math.max(curBest, prices[i] - min);

            bestNow = Math.max(bestNow, curBest - prices[i]);

        }
        return ans;
    }

}
