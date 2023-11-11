import java.util.ArrayList;
import java.util.List;

/**
 * * URL:https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 * <p>
 * 17. 电话号码的字母组合
 */
public class LeetCode17_letterCombinations {

    public static void main(String[] args) {
        List<String> strings = letterCombinations("23");
        System.out.println(strings);
    }

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        char[][] arr = {
                {},
                {},
                {'a', 'b', 'c'},
                {'d', 'e', 'f'},
                {'g', 'h', 'i'},
                {'j', 'k', 'l'},
                {'m', 'n', 'o'},
                {'p', 'q', 'r', 's'},
                {'t', 'u', 'v'},
                {'w', 'x', 'y', 'z'}
        };
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        char[] chars = digits.toCharArray();
        char[] path = new char[chars.length];
        process1(ans, chars, 0, path, arr);
        ans.forEach(System.out::println);
        return ans;
    }


    /**
     * 深度优先遍历（递归）2 a b c 3 d e f
     *
     * @param ans   收集答案
     * @param chars 2 3
     * @param index char2 当前的位置
     * @param path  到index位置下收集的数据 ad ae af
     */
    public static void process(List<String> ans, char[] chars, int index, char[] path, char[][] phone) {
        if (index == chars.length - 1) {
            //数字
            char[] nums = phone[chars[index] - '0'];
            for (int i = 0; i < nums.length; i++) {
                path[index] = nums[i];
                ans.add(String.valueOf(path));
            }
        } else {
            char[] nums = phone[chars[index] - '0'];
            for (int i = 0; i < nums.length; i++) {
                path[index] = nums[i];
                process(ans, chars, index + 1, path, phone);
            }
        }
    }

    public static void process1(List<String> ans, char[] chars, int index, char[] path, char[][] phone) {
        if (index == chars.length) {
            ans.add(String.valueOf(path));
        } else {
            char[] nums = phone[chars[index] - '0'];
            for (int i = 0; i < nums.length; i++) {
                path[index] = nums[i];
                process1(ans, chars, index + 1, path, phone);
            }
        }
    }

}
