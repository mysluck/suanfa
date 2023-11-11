/**
 * * URL:https://leetcode.cn/problems/integer-to-roman/description/
 * 整数转罗马数字
 */
public class LeetCode12_intToRoman {

    public static void main(String[] args) {
        System.out.println(intToRoman(1104));
        System.out.println(intToRoman2(1104));
    }

    /**
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     *
     * @param num
     * @return
     */
    public static String intToRoman(int num) {
        StringBuilder ans = new StringBuilder();
        if (num == 0) {
            return ans.toString();
        }
        int[] numArr = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] strArr = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        for (int i = numArr.length - 1; i >= 0; i--) {
            while (num >= numArr[i]) {
                ans.append(strArr[i]);
                num = num - numArr[i];
            }
        }
        return ans.toString();
    }

    public static String intToRoman2(int num) {
        StringBuilder ans = new StringBuilder();
        if (num == 0) {
            return ans.toString();
        }
        String[][] strArr = {
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"},
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"},
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"},
                {"", "M", "MM", "MMM"}
        };

        ans.append(strArr[3][num / 1000]).append(strArr[2][num % 1000 / 100]).append(strArr[1][num % 100 / 10]).append(strArr[0][num % 10]);
        return ans.toString();
    }

}
