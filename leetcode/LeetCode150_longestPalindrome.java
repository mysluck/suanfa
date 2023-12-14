/**
 * https://leetcode.cn/problems/longest-palindromic-substring/?envType=study-plan-v2&envId=top-interview-150
 * <p>
 * <p>
 * 最长回文子串
 * <p>
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 */
public class LeetCode150_longestPalindrome {

    public static void main(String[] args) {
        String s = "aababaa";
        boolean hw = isHw(s);
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        if (s.length() < 2) {
            return s;
        }
        String ans = s.substring(0, 1);
        int N = s.length();
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (isHw(s.substring(i, j + 1)) && j - i + 1 > ans.length()) {
                    ans = s.substring(i, j + 1);
                }
            }

        }
        return ans;
    }

    public static boolean isHw(String s) {
        int N = s.length();
        int mid = N >> 1;
        for (int i = 0; i < mid; i++) {
            if (s.charAt(i) != s.charAt(N - i - 1)) {
                return false;
            }
        }
        return true;
    }

}
