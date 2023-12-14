import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/problems/word-break/description/?envType=study-plan-v2&envId=top-interview-150
 * 动态规划
 * 139. 单词拆分
 * <p>
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。请你判断是否可以利用字典中出现的单词拼接出 s 。
 * <p>
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 */
public class LeetCode139_wordBreak {

    public static void main(String[] args) {
        String s = "leetcode";
        List<String> list = new ArrayList<>();
        list.add("leet");
        list.add("code");

        System.out.println(wordBreak(s, list));
        System.out.println(wordBreak2(s, list));
    }


    public static boolean wordBreak(String s, List<String> wordDict) {
        return process(s, 0, new HashSet<>(wordDict)) != 0;
    }

    /**
     * @param s        字符串
     * @param index    index坐标 【index，end】是否可以满足
     * @param wordDict
     * @return 满足的个数
     */
    public static int process(String s, int index, Set<String> wordDict) {
        //说明匹配到最后
        if (index == s.length()) {
            return 1;
        }
        int ways = 0;
        for (int end = index; end < s.length(); end++) {
            String pre = s.substring(index, end + 1);
            if (wordDict.contains(pre)) {
                ways += process(s, end + 1, wordDict);
            }
        }
        return ways;
    }


    /**
     * 动态规划
     *
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak2(String s, List<String> wordDict) {
        int N = s.length();
        int[] dp = new int[N + 1];
        //说明匹配到最后
        dp[N] = 1;
        for (int index = N - 1; index >= 0; index--) {
            int ways = 0;
            for (int end = index; end < s.length(); end++) {
                String pre = s.substring(index, end + 1);
                if (wordDict.contains(pre)) {
                    ways += dp[end + 1];
                }
            }
            dp[index] = ways;
        }
        return dp[0] != 0;
    }

}
