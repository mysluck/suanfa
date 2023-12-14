package extra;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/path-sum-ii/
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 */
public class 路径总和113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        int preSum = 0;
        List<Integer> tmpList = new ArrayList<>();
        process(root, preSum, targetSum, tmpList, ans);
        return ans;
    }

    private void process(TreeNode root, int preSum, int targetSum, List<Integer> tmpList, List<List<Integer>> ans) {
        if (root.left == null && root.right == null) {
            if (root.val + preSum == targetSum) {
                List<Integer> copy = copy(tmpList);
                copy.add(root.val);
                ans.add(copy);
            }
            return;
        }
        preSum += root.val;
        tmpList.add(root.val);
        if (root.left != null) {
            process(root.left, preSum, targetSum, tmpList, ans);
        }
        if (root.right != null) {
            process(root.right, preSum, targetSum, tmpList, ans);
        }
        tmpList.remove(tmpList.size() - 1);
    }

    public List<Integer> copy(List<Integer> integers) {
        List<Integer> copy = new ArrayList<>();
        for (int i = 0; i < integers.size(); i++) {
            copy.add(integers.get(i));
        }
        return copy;
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }
}
