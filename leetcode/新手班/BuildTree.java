package 新手班;

//https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
//105. 从前序与中序遍历序列构造二叉树
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }

        return process(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode process(int[] pr, int L1, int R1, int[] in, int L2, int R2) {
        if (L1 > R1) {
            return null;
        }
        TreeNode head = new TreeNode(pr[L1]);
        //先找头节点
        if (L1 == R1) {
            return head;
        }
        int find = L2;
        while (in[find] != pr[L1]) {
            find++;
        }

        head.left = process(pr, L1 + 1, L1 + find - L2, in, L2, find - 1);
        head.right = process(pr, L1 + find - L2 + 1, R1, in, find + 1, R2);
        return head;
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
