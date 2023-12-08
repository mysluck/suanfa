import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-preorder-traversal/
 * <p>
 * 144. 二叉树的前序遍历
 * <p>
 * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class LeetCode144_preorderTraversal {

    public static void main(String[] args) {

    }

    public static void preorderTraversal(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.val);
        preorderTraversal(root.left, ans);
        preorderTraversal(root.right, ans);
    }

    /**
     * 前序遍历
     *
     * @param head
     */
    public static void preOrderRecur(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
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
