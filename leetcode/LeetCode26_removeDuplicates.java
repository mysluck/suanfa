import java.util.Arrays;

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array/description/ * <p>
 * 26. 删除有序数组中的重复项
 */
public class LeetCode26_removeDuplicates {

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 2, 2, 2, 3, 3, 4, 5};
//        int i = removeDuplicates(arr);
        int i = removeDuplicates1(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    /**
     * 双指针优化
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        int L = 0;
        int R = L + 1;
        int end = nums.length;
        while (R < end) {
            if (nums[L] == nums[R]) {
                R++;
            } else {
                nums[L + 1] = nums[R];
                L++;
            }
        }
        return L;
    }

    public static int removeDuplicates1(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[ans]) {
                nums[++ans] = nums[i];
            }
        }

        return ans + 1;
    }
}