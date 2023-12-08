/**
 * https://leetcode.cn/problems/is-subsequence/?envType=study-plan-v2&envId=top-interview-150
 * <p>
 * 392. 判断子序列
 * <p>
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 */
public class LeetCode392_isSubsequence {

    public static void main(String[] args) {
        String s = "abc";
        String t = "abewqqac";
        System.out.println(isSubsequence(s, t));
    }


    public static boolean isSubsequence(String s, String t) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (s.length() > t.length()) {
            return false;
        }
        int N = s.length();
        int L = 0, R = 0;
        int M = t.length();

        while (L < N && R < M) {
            if (s.charAt(L) == t.charAt(R)) {
                L++;
            }
            R++;
        }
        return L == N ;
    }


}
