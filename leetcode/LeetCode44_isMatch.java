/**
 * * URL: https://leetcode.cn/problems/wildcard-matching/description/
 * 44. 通配符匹配
 */
public class LeetCode44_isMatch {

    public static void main(String[] args) {
        String s = "abaaac";
        String p = "ab?aac";
        boolean match = isMatch(s, p);
        System.out.println(match);
    }

    public static boolean isMatch(String s, String p) {
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        return process1(sArray, pArray, 0, 0);
    }

    private boolean process11(char[] s, char[] p, int s1, int p1) {
        if (s1 == s.length) {
            if (p1 == p.length) {
                return true;
            } else {
                return p[p1] == '*' && process1(s, p, s1, p1 + 1);
            }
        }
        if (p1 == p.length) {
            return s1 == s.length;
        }
        //p[p1] 为 * ？ 字母
        if (p[p1] != '？' && p[p1] != '*') {
            return s[s1] == p[p1] && process1(s, p, s1 + 1, p1 + 1);
        } else {
            if (p[p1] == '？') {
                return process1(s, p, s1 + 1, p1 + 1);
            } else {
                //s1-s.length
                for (int i = 0; i < s.length - s1; i++) {
                    if (process1(s, p, s1 + i, p1 + 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }


    // s[si....] 能否被 p[pi....] 匹配出来
    public static boolean process1(char[] s, char[] p, int si, int pi) {
        if (si == s.length) { // s -> ""
            if (pi == p.length) { // p -> ""
                return true;
            } else {
                // p -> "..."
                // p[pi] == '*' && p[pi+1...] -> "
                return p[pi] == '*' && process1(s, p, si, pi + 1);
            }
        }
        if (pi == p.length) { // p -> "" s
            return si == s.length;
        }
        // s从si出发.... p从pi出发...
        // s[si] -> 小写字母
        // p[pi] -> 小写、?、*
        if (p[pi] != '?' && p[pi] != '*') {
            return s[si] == p[pi] && process1(s, p, si + 1, pi + 1);
        }
        // si.. pi.. pi ? *
        if (p[pi] == '?') {
            return process1(s, p, si + 1, pi + 1);
        }
        for (int len = 0; len <= s.length - si; len++) {
            if (process1(s, p, si + len, pi + 1)) {
                return true;
            }
        }
        return false;
    }


}
