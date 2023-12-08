/**
 * https://leetcode.cn/problems/single-number/?envType=study-plan-v2&envId=top-interview-150
 * <p>
 * 136. 只出现一次的数字
 * <p>
 * 给你一个 非空 整数数组 nums ，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * <p>
 * 你必须设计并实现线性时间复杂度的算法来解决此问题，且该算法只使用常量额外空间。
 */
public class LeetCode136_singleNumber {

    public static void main(String[] args) {
        int d = 0;
        int a = 2;
        int b = 2;
        int c = 1;
        System.out.println(d ^ a ^ b ^ c);
    }

    public static int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];

        }
        return ans;
    }

}
