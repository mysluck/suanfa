/**
 * https://leetcode.cn/problems/majority-element/?envType=study-plan-v2&envId=top-interview-150
 * <p>
 * 169. 多数元素
 * <p>
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class LeetCode169_majorityElement {

    public static void main(String[] args) {

    }

    public static int majorityElement(int[] nums) {
        int count = 0;
        Integer value = null;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                value = nums[i];
            }
            count += value == nums[i] ? 1 : -1;

        }
        return value;
    }


}
