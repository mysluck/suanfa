package extra;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * <p>
 * 有效 二叉搜索树定义如下：
 * <p>
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 */
public class 验证二叉搜索树 {
    public boolean isBalanced(TreeNode root) {
        return process(root).isBalanced;
    }

    public Info process(TreeNode root) {
        if (root == null) {
            return new Info(true, 0);
        }
        Info left = process(root.left);
        Info right = process(root.right);
        int height = Math.max(left.height, right.height) + 1;
        boolean isBan = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) < 2;
        return new Info(isBan, height);
    }

    public static class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean i, int h) {
            isBalanced = i;
            height = h;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
