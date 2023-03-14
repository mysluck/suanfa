import java.util.Stack;

/**
 * 20. 有效的括号
 * 难度
 * 简单
 * <p>
 * 3790
 * <p>
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "()"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "()[]{}"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：s = "(]"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由括号 '()[]{}' 组成
 */
public class LeetCode20 {
    public static void main(String[] args) {
        String s = "([(])";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        if (s == null || s.length() < 2) {
            return false;
        }
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (c == '{' || c == '(' || c == '[') {
                stack.add(c == '{' ? '}' : c == '(' ? ')' : ']');
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if (c != stack.pop()) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
