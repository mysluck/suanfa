/**
 * 7. 整数反转
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * <p>
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * <p>
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 123
 * 输出：321
 * 示例 2：
 * <p>
 * 输入：x = -123
 * 输出：-321
 * 示例 3：
 * <p>
 * 输入：x = 120
 * 输出：21
 * 示例 4：
 * <p>
 * 输入：x = 0
 * 输出：0
 *  
 * <p>
 * 提示：
 * <p>
 * -231 <= x <= 231 - 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LeetCode7 {
    //解题思路
    //1 负数比正数大1 所以转负数 获取系统最小值 minvalue，需要判断溢出 如果value<
    public static int reverse(int x) {
        int minValue = Integer.MIN_VALUE;
        int val1 = minValue / 10;
        int val2 = minValue % 10;
        //是否是正数？true:负数 false：正数
        boolean b = ((x >>> 31) & 1) == 1;
        int tmp = b ? x : -x;
        int ans = 0;
        while (tmp != 0) {
            if (ans < val1 || (ans == val1 && tmp < val2)) {
                return 0;
            }
            int cur = tmp % 10;
            ans = ans * 10 + cur;
            tmp = tmp / 10;
        }
        return b ? ans : -ans;
    }

    public static void main(String[] args) {
        int x = 1534236469;
        System.out.println(reverse(x));
    }
}
