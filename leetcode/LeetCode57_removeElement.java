import java.util.Arrays;

/**
 * https://leetcode.cn/problems/remove-element/?envType=study-plan-v2&envId=top-interview-150
 * <p>
 * 27. 移除元素
 * <p>
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class LeetCode57_removeElement {

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 4, 2};
        int i = removeElement1(arr, 2);
        System.out.println(i);
        Arrays.stream(arr).forEach(System.out::println);
    }

    public static int removeElement(int[] nums, int val) {
        int L = 0;
        int R = nums.length;
        while (L < R) {
            if (nums[L] == val) {
                nums[L] = nums[R - 1];
                R--;
            } else {
                L++;
            }
        }
        return R;
    }

    public static int removeElement1(int[] nums, int val) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            if (nums[left] == val) {
                nums[left] = nums[right - 1];
                right--;
            } else {
                left++;
            }
        }
        return left;
    }

}
