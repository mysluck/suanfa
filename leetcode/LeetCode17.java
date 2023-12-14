import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * 难度
 * 中等
 * <p>
 * 2353
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = '23'
 * 输出：['ad','ae','af','bd','be','bf','cd','ce','cf']
 * 示例 2：
 * <p>
 * 输入：digits = ''
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：digits = '2'
 * 输出：['a','b','c']
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class LeetCode17 {
    static char[][] phone = {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'},
    };

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        char[] chars = digits.toCharArray();
//逻辑 深度遍历 放到集合中 临时用path【】保存
        //当前path
        char[] path = new char[digits.length()];
        process(chars, 0, path, ans);
        return ans;
    }

    public static void process(char[] digitChars, int index, char[] path, List<String> ans) {
        if (index == digitChars.length) {
            ans.add(String.valueOf(path));
        } else {
            char[] cands = phone[digitChars[index] - '2'];
            for (char c : cands) {
                path[index] = c;
                process(digitChars, index + 1, path, ans);
            }
        }

    }

    public static void main(String[] args) {

//        String digitChars = "23";
//        char[] chars = digitChars.toCharArray();
//        for (int i = 0; i < chars.length; i++) {
//            System.out.println(chars[i]);
//        }
        List<String> strings = letterCombinations("23");

        strings.forEach(System.out::println);
    }


    public static List<String> method(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        char[] chars = s.toCharArray();
        char[] path = new char[chars.length];
        process1(chars, 0, path, ans);
        return ans;
    }

    private static void process1(char[] chars, int index, char[] path, List<String> ans) {
        if (index == chars.length) {
            ans.add(String.valueOf(path));
        } else {
            char[] chars1 = phone[chars[index] - '2'];
            for (int i = 0; i < chars1.length; i++) {
                path[index] = chars1[i];
                process1(chars, index + 1, path, ans);
            }
        }
    }
}
