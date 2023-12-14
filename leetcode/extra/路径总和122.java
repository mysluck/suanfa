package extra;

/**
 * https://leetcode.cn/problems/path-sum/
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 */
public class 路径总和122 {
    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
//        isSum = false;
//        process(root, targetSum, 0);
//        return isSum;

        return process(root, targetSum);
    }

    public static boolean isSum = false;

    public void process(TreeNode root, int targetSum, int preSum) {
        if (root.left == null && root.right == null) {
            if (root.val + preSum == targetSum) {
                isSum = true;
            }
            return;
        }
        preSum = preSum + root.val;
        if (root.left != null) {
            process(root.left, targetSum, preSum);
        }
        if (root.right != null) {
            process(root.right, targetSum, preSum);
        }

    }

    public boolean process(TreeNode root, int sum) {
        if (root.left == null && root.right == null) {
            return root.val == sum;
        }
        boolean left = false;
        boolean right = false;
        if (root.left != null) {
            left = process(root.left, sum - root.val);
        }
        if (root.right != null) {
            right = process(root.right, sum - root.val);
        }
        return left || right;
    }
}