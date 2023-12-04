

/**
 * https://leetcode.cn/problems/remove-duplicates-from-sorted-array-ii/?envType=study-plan-v2&envId=top-interview-150
 * <p>
 * 80. 删除有序数组中的重复项 II
 * <p>
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class LeetCode80_removeDuplicates {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 2, 2, 2, 3, 4, 5, 5, 5, 5};
        int i = removeDuplicates(arr);
        System.out.println(i);
        for (int j = 0; j <arr.length ; j++) {
            System.out.print(arr[j]+" ");
        }
    }

    /**
     * 1 从下标位置2开始 0 1即使相等 也可以往下走
     * 2 设置2快慢指针slow fast
     * 3 slow=slow-1=slow-2？
     *
     * @param nums
     * @return
     */
    public static int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        int N = nums.length;
        if (N < 2) {
            return N;
        }
        int slow = 2;
        int fast = 2;
        while (fast < N) {
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

}
