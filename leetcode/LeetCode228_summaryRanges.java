import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/summary-ranges/?envType=study-plan-v2&envId=top-interview-150
 * <p>
 * 228. 汇总区间
 * <p>
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 * <p>
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * <p>
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * <p>
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 */
public class LeetCode228_summaryRanges {

    public static void main(String[] args) {
        int[] nums = {-2147483648, -2147483647, 2147483647};
        List<String> list = summaryRanges(nums);
        System.out.println(list);
    }

    public static List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return ans;
        }
        int index = 1;
        int N = nums.length;
        int preIndex = 0;

        while (index < N) {
            if (nums[index] > nums[index - 1] + 1) {
                if (preIndex == index - 1) {
                    ans.add(nums[preIndex] + "");
                } else {
                    ans.add(nums[preIndex] + "->" + nums[index - 1]);
                }
                preIndex = index;
            }
            index++;
        }
        if (preIndex == index - 1) {
            ans.add(nums[preIndex] + "");
        } else {
            ans.add(nums[preIndex] + "->" + nums[index - 1]);
        }
        return ans;
    }

}
