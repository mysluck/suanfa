/**
 * https://leetcode.cn/problems/sqrtx/description/?envType=study-plan-v2&envId=top-interview-150
 * <p>
 * 69. x 的平方根
 */
public class LeetCode69_mySqrt {

    public static void main(String[] args) {
//        int L = 2;
//        int R = 4;
//        int mid = L + ((R - L) >> 1);
//        System.out.println(mid);

        int a = 45;
        System.out.println(mySqrt(a));

    }

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int L = 0;
        int R = x;
        int ans = 0;
        while (L <= R) {
            int mid = L + ((R - L) >> 1);
            if (mid * mid <= x) {
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return ans;
    }
}
