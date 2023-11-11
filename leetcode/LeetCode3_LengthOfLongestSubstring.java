import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * <p>
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LeetCode3_LengthOfLongestSubstring {
    public static void main(String[] args) {
        String s="abaccdca";
        int i = lengthOfLongestSubstring(s);
        System.out.println(i);
    }
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        //字符上次出现的位置
        Map<Character, Integer> charMap = new HashMap<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            charMap.put(aChar, -1);
        }
        int ans = 0;
        //上个字符 到上一次推不动的位置
        int preIndex = -1;
        //当前字符 到上一次推不动的位置
//        charMap
        for (int i = 0; i < chars.length; i++) {
            //当前 字符推不动的index（上次出现字符的位置和前一个index推不动的位置 取最大值 即当前节点推不动的位置）
            preIndex = Math.max(charMap.get(chars[i]), preIndex);
            charMap.put(chars[i], i);
            ans = Math.max(i - preIndex, ans);
//            System.out.println(ans);
        }

        return ans;
    }
}
