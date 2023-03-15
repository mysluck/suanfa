import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 难度
 * 中等
 * <p>
 * 3132
 * <p>
 * <p>
 * <p>
 * <p>
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：["((()))","(()())","(())()","()(())","()()()"]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：["()"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 8
 */
public class LeetCode22 {
    //解题思路 1：要确定左括号剩余几个 2：要确认左括号-右括号剩余几个 收集的结果放path【】中
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        char[] path = new char[n << 1];
        process(0, path, n, 0, ans);
        return ans;
    }

    public static void process(int index, char[] path, int leftCount, int leftDelRightCount, List<String> ans) {
        if (index == path.length) {
            ans.add(String.valueOf(path));
        }
        if (leftCount > 0) {
            path[index] = '(';
            process(index + 1, path, leftCount - 1, leftDelRightCount + 1, ans);
        }
        if (leftDelRightCount > 0) {
            path[index] = ')';
            process(index + 1, path, leftCount, leftDelRightCount - 1, ans);
        }
    }

    public static void main(String[] args) {
        List<String> strings = generateParenthesis(3);
        strings.forEach(System.out::println);
    }
}
