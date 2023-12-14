

/**
 *
 */
public class LeetCode001_ {
    public class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }


    public boolean solution(Node root) {
        return process(root).isBalanced;

    }

    public Info process(Node root) {
        if (root == null) {
            return new Info(true, 0);
        }
        Info left = process(root.left);
        Info right = process(root.right);
        int height = Math.max(left.height, right.height) + 1;
        boolean isBan = left.isBalanced && right.isBalanced && Math.abs(left.height - right.height) < 2;
        if (root.left == null && root.right != null) {
            isBan = false;
        }
        return new Info(isBan, height);
    }

    public class Info {
        public boolean isBalanced;
        public int height;

        public Info(boolean i, int h) {
            isBalanced = i;
            height = h;
        }
    }


}
