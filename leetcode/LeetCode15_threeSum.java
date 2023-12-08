import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
     * * URL: https://leetcode.cn/problems/3sum/
 * 三数之和
 */
public class LeetCode15_threeSum {

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> lists = threeSum(arr);
        System.out.println(lists);
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);

        if (nums[0] * 3 > 0) {
            return ans;
        }
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            int cur = nums[i];
            //从i+1 到length-1 位置找到累加和=0-cur的数据
            if (i == 0 || nums[i] != nums[i - 1]) {
                List<List<Integer>> tmp = twoSum(nums, i + 1, cur);
                if (tmp.size() != 0) {
                    ans.addAll(tmp);
                }
            }
        }

        return ans;
    }


    private static List<List<Integer>> twoSum(int[] nums, int begin, int cur) {
        int target = 0 - cur;
        List<List<Integer>> ans = new ArrayList<>();
        int L = begin;
        int R = nums.length - 1;
        while (L < R) {
            int curNum = nums[L] + nums[R];
            if (curNum > target) {
                R--;
            } else if (curNum < target) {
                L++;
            } else {
                if (begin == L || nums[L - 1] != nums[L]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[L]);
                    temp.add(nums[R]);
                    temp.add(cur);
                    ans.add(temp);
                }
                R--;
                L++;
            }

        }
        return ans;
    }
}
