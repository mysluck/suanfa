/**
 * https://leetcode.cn/problems/length-of-last-word/
 * <p>
 * 58. 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
 */
public class LeetCode58_lengthOfLastWord {

    public static void main(String[] args) {
        String s = "hello woerld  ";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0)
            return 0;
        int R = s.length() - 1;
        int ans = 0;
        for (int i = R; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (ans == 0) {
                    continue;
                }
                return ans;
            }
            ans++;
        }

        return ans;
    }

}
