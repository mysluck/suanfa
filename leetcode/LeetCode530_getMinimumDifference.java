/**
 * https://leetcode.cn/problems/minimum-absolute-difference-in-bst/description/?envType=study-plan-v2&envId=top-interview-150
 * <p>
 * 530. 二叉搜索树的最小绝对差
 * <p>
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * <p>
 * 差值是一个正数，其数值等于两值之差的绝对值。
 */
public class LeetCode530_getMinimumDifference {

    public static void main(String[] args) {

    }

    static int ans;
    static int pre;

    public static int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        f(root);
        return ans;
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    private static void f(TreeNode root) {
        if (root == null) {
            return;
        }
        f(root.left);
        if (pre == -1) {
            pre = root.val;
        } else {
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        f(root.right);

    }


}
