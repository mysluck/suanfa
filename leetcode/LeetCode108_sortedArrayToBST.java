/**
 * https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/?envType=study-plan-v2&envId=top-interview-150
 * <p>
 * 108. 将有序数组转换为二叉搜索树
 */
public class LeetCode108_sortedArrayToBST {

    public static void main(String[] args) {
        int[] arr = {-10, -3, 0, 5, 9};
        TreeNode treeNode = sortedArrayToBST(arr);
        System.out.println(treeNode);

    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        return process(nums, 0, nums.length-1);
    }

    public static TreeNode process(int[] nums, int L, int R) {
        if (L > R) {
            return null;
        }
        if (L == R) {
            return new TreeNode(nums[L]);
        }
        int mid = L + ((R - L) >> 1);
        TreeNode root = new TreeNode(nums[mid]);
        root.left = process(nums, L, mid - 1);
        root.right = process(nums, mid + 1, R);
        return root;
    }

    public static class TreeNode {
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
