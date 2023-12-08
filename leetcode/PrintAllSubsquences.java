import java.util.ArrayList;
import java.util.List;

/**
 * 打印所有子序列
 */
public class PrintAllSubsquences {
    public static void main(String[] args) {
        String s = "abc";
        List<String> solution = solution(s);
        System.out.println(solution);
    }

    public static List<String> solution(String str) {
        List<String> ans = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return ans;
        }
        String path = "";

        f(str, path, 0, ans);
        return ans;
    }

    private static void f(String str, String path, int index, List<String> ans) {
        if (index == str.length()) {
            ans.add(path);
        } else {
            char[] chars = str.toCharArray();
            f(str, path, index + 1, ans);
            f(str, path + String.valueOf(chars[index]), index + 1, ans);

        }
    }
}
