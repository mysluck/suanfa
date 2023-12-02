package 体系学习班;

import java.util.List;

//获取多叉树最大值 相邻上下级不可重复选择
public class 多叉树最大值 {

    public static class Node {
        public int value;
        public List<Node> nodes;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {

    }

    public static int getMax(Node root) {
        if (root == null) {
            return 0;
        }
        Info info = process(root);
        return Math.max(info.no, info.yes);
    }

    private static Info process(Node root) {
        if (root == null) {
            return new Info(0, 0);
        }
        int no = 0;
        int yes = root.value;
        for (Node next : root.nodes) {
            Info nextInfo = process(next);
            no = Math.max(nextInfo.no, nextInfo.yes);
            yes += nextInfo.no;
        }
        return new Info(yes, no);
    }

    public static class Info {
        private int yes;
        private int no;

        public Info(int yes, int no) {
            this.yes = yes;
            this.no = no;
        }
    }

}
