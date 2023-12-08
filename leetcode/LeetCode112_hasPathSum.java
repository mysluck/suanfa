/**
 * https://leetcode.cn/problems/path-sum/?envType=study-plan-v2&envId=top-interview-150
 * <p>
 * 112. 路径总和
 * <p>
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 */
public class LeetCode112_hasPathSum {

    public static void main(String[] args) {

    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        return f(root, targetSum);
    }

    public static boolean f(TreeNode treeNode, int targetSum) {
        if (treeNode == null) {
            return false;
        }
        if (treeNode.left == null && treeNode.right == null) {
            return targetSum == treeNode.val;
        }
        return f(treeNode.left, targetSum - treeNode.val) || f(treeNode.right, targetSum - treeNode.val);

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
