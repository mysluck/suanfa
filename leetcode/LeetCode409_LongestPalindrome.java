import java.util.HashMap;
import java.util.Map;

/**
 * URL:https://leetcode.cn/problems/longest-palindrome/description/
 * 409. 最长回文串
 * <p>
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 */
public class LeetCode409_LongestPalindrome {

    public static void main(String[] args) {
        String s = "ababa";
        System.out.println(longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {
        int ans = 0;
        if (s == null || "".equals(s)) {
            return ans;
        }
        if (s.length() == 1) {
            return 1;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] chars = s.toCharArray();
        for (Character c : chars) {
            if (map.containsKey(c)) {
                map.remove(c);
                ans += 2;
            } else {
                map.put(c, 1);
            }
        }
        if (!map.isEmpty()) {
            ans += 1;
        }
        return ans;
    }

}
