import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * https://leetcode.cn/problems/palindrome-partitioning/
 * <p>
 * 131. 分割回文串
 * <p>
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 */
public class LeetCode131_partition {

    public static void main(String[] args) {
        String s = "aabb";
        List<List<String>> partition = partition(s);
        partition.forEach(System.out::println);
    }

    /**
     * 1 dp[L][R]获取L-R位置是否是回文
     * 2 判断0-1 1-结尾 0-2 2到结尾递归遍历 数据插入ans中
     *
     * @param s
     * @return
     */
    public static List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        boolean[][] dp = getDp(s);
        System.out.println(dp);
        LinkedList<String> path = new LinkedList<>();
        p(s, 0, dp, path, ans);

        return ans;
    }

    private static void p(String s, int index, boolean[][] dp, LinkedList<String> path, List<List<String>> ans) {
        //结束
        if (index == s.length()) {
            ans.add(copy(path));
        } else {
            for (int end = index; end < s.length(); end++) {
                if (dp[index][end]) {
                    path.add(s.substring(index, end + 1));
                    p(s, end + 1, dp, path, ans);
                    path.pollLast();
                }
            }
        }
    }


    private static boolean[][] getDp(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length - 1; i++) {
            dp[i][i] = true;
            dp[i][i + 1] = chars[i] == chars[i + 1];
        }
        dp[length - 1][length - 1] = true;

        for (int i = 2; i < length; i++) {
            //行
            int row = 0;
            //列
            int col = i;
            while (row < length && col < length) {
                dp[row][col] = dp[row + 1][col - 1] && chars[col] == chars[row];
                col++;
                row++;
            }
        }
        return dp;
    }


    public static List<String> copy(List<String> path) {
        List<String> ans = new ArrayList<>();
        for (String p : path) {
            ans.add(p);
        }
        return ans;
    }
}
