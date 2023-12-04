import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/pascals-triangle/
 * <p>
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 */
public class LeetCode118_generate {

    public static void main(String[] args) {
        List<List<Integer>> generate = generateDp(5);
        generate.forEach(System.out::println);
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        if (numRows == 0) {
            return ans;
        }

        for (int i = 0; i < numRows; i++) {
            ans.add(new ArrayList<>());
            ans.get(i).add(1);
        }
        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j < i; j++) {
                ans.get(i).add(ans.get(i - 1).get(j - 1) + ans.get(i - 1).get(j));
            }
            //  添加最后一行1
            ans.get(i).add(1);
        }
        return ans;
    }

    public static List<List<Integer>> generateDp(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        int[][] dp = new int[numRows][numRows + 1];
        if (numRows == 0) {
            return ans;
        }
        for (int i = 0; i < numRows; i++) {
            ans.add(new ArrayList<>());
            dp[i][0] = 1;
            ans.get(i).add(1);
        }
        for (int i = 1; i < numRows; i++) {
            for (int j = 1; j < i; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                ans.get(i).add(dp[i][j]);
            }
            dp[i][i] = 1;
            ans.get(i).add(1);
        }
        return ans;
    }

}