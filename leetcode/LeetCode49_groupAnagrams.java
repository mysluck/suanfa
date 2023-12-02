import java.util.*;

/**
 * https://leetcode.cn/problems/group-anagrams/?envType=study-plan-v2&envId=top-interview-150
 * 49. 字母异位词分组
 * <p>
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
 */
public class LeetCode49_groupAnagrams {

    public static void main(String[] args) {

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return ans;
        }
        Map<String, List<String>> sortMap = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (!sortMap.containsKey(key)) {
                sortMap.put(key, new ArrayList<String>());
            }
            sortMap.get(key).add(s);
        }
        for (List<String> list : sortMap.values()) {
            ans.add(list);

        }
        return ans;
    }
}
