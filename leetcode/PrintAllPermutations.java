import java.util.ArrayList;
import java.util.List;

/**
 * 字符全排列
 * abc
 */
public class PrintAllPermutations {

    public static void main(String[] args) {
        String s = "abc";
        List<String> solution = solution1(s);
        System.out.println(solution);
    }

    public static List<String> solution(String str) {
        List<String> ans = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return ans;
        }
        List<Character> rest = new ArrayList<>();
        String path = "";
        char[] s = str.toCharArray();
        for (int i = 0; i < s.length; i++) {
            rest.add(s[i]);
        }
        f(rest, path, ans);
        return ans;
    }

    private static void f(List<Character> rest, String path, List<String> ans) {
        if (rest.isEmpty()) {
            ans.add(path);
        } else {
            int N = rest.size();
            for (int i = 0; i < N; i++) {
                char cur = rest.get(i);
                rest.remove(i);
                f(rest, path + cur, ans);
                rest.add(i, cur);
            }
        }
    }

    public static List<String> solution1(String s) {
        List<String> ans = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return ans;
        }
        char[] chars = s.toCharArray();
        List<Character> rest = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            rest.add(chars[i]);
        }
        String path = "";
        p(rest, path, ans);
        return ans;
    }

    private static void p(List<Character> rest, String path, List<String> ans) {
        if (rest.isEmpty()) {
            ans.add(path);
        } else {
            for (int i = 0; i < rest.size(); i++) {
                char cur = rest.get(i);
                rest.remove(i);
                p(rest, path + String.valueOf(cur), ans);
                rest.add(i, cur);
            }
        }
    }
}
