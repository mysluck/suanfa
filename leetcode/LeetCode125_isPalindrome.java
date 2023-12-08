/**
 * https://leetcode.cn/problems/valid-palindrome/
 * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，短语正着读和反着读都一样。则可以认为该短语是一个 回文串 。
 * <p>
 * 字母和数字都属于字母数字字符。
 * <p>
 * 给你一个字符串 s，如果它是 回文串 ，返回 true ；否则，返回 false 。
 */
public class LeetCode125_isPalindrome {

    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
        String s = ".,";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        s = s.toLowerCase();
        int N = s.length();
        char[] chars = s.toCharArray();
        int L = 0;
        int R = N - 1;
        while (L < R) {
            while (!((chars[L] >= 'a' && chars[L] <= 'z') || (chars[L] >= '0' && chars[L] <= '9'))) {
                if (L < R) {
                    L++;
                }
                return true;
            }
            while (!((chars[R] >= 'a' && chars[R] <= 'z') || (chars[R] >= '0' && chars[R] <= '9'))) {
                if (L < R) {
                    R--;
                }
                return true;
            }
            if (chars[L] != chars[R]) {
                return false;
            }
            L++;
            R--;
        }
        return true;
    }

}
