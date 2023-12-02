import java.util.ArrayList;
import java.util.List;

/**
 * * URL: https://leetcode.cn/problems/permutations/?envType=study-plan-v2&envId=top-interview-150
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class LeetCode46_permute {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> permute = permute(arr);
        System.out.println(permute);
        List<List<Integer>> permute1 = permute(arr);
        System.out.println(permute1);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numList.add(nums[i]);
        }
        List<Integer> path = new ArrayList<>();
        f(ans, numList, path);
        return ans;
    }

    private static void f(List<List<Integer>> ans, List<Integer> numList, List<Integer> path) {
        if (numList.isEmpty()) {
            ans.add(path);
        } else {
            for (Integer n : numList) {
                ArrayList<Integer> curPath = new ArrayList<>(path);
                curPath.add(n);
                List<Integer> list = cloneAndExp(numList, n);
                f(ans, list, curPath);
            }
        }
    }


    public static List<Integer> cloneAndExp(List<Integer> numList, int num) {
        List<Integer> clone = new ArrayList<>();
        for (Integer n : numList) {
            if (num != n) {
                clone.add(n);
            }
        }
        return clone;
    }


    public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        f1(ans, nums, 0);
        return ans;
    }

    private static void f1(List<List<Integer>> ans, int[] nums, int index) {
        if (index == nums.length - 1) {
            List<Integer> cur = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                cur.add(nums[i]);
            }
            ans.add(cur);
        } else {
            for (int i = index; i < nums.length; i++) {
                swap(nums, i, index);
                f1(ans, nums, index + 1);
                swap(nums, i, index);
            }
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
