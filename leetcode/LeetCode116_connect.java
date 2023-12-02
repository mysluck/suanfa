/**
 * https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/
 * <p>
 * 116. 填充每个节点的下一个右侧节点指针
 * <p>
 * 给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：
 * <p>
 * struct Node {
 * int val;
 * Node *left;
 * Node *right;
 * Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 * <p>
 * 初始状态下，所有 next 指针都被设置为 NULL。
 */
public class LeetCode116_connect {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
        Node connect = connect(root);
        System.out.println(connect);

    }

    public static Node connect(Node root) {
        if (root == null) {
            return root;
        }
        MyQueue myQueue = new MyQueue();
        myQueue.offer(root);
        while (!myQueue.isEmpty()) {
            Node pre = null;
            int size = myQueue.size;
            for (int i = 0; i < size; i++) {
                Node cur = myQueue.poll();
                if (cur.left != null) {
                    myQueue.offer(cur.left);
                }
                if (cur.right != null) {
                    myQueue.offer(cur.right);
                }
                if (pre != null) {
                    pre.next = cur;
                }
                pre = cur;
            }
        }
        return root;
    }


    public static class MyQueue {
        private Node head;
        private Node tail;
        private int size;

        public MyQueue() {
            this.head = null;
            this.tail = null;
            this.size = 0;
        }

        public boolean isEmpty() {
            return size == 0;
        }

        public void offer(Node cur) {
            if (size == 0) {
                head = cur;
                tail = cur;
            } else {
                tail.next = cur;
                tail = cur;
            }
            size++;
        }

        public Node poll() {
            if (size > 0) {
                size--;
                Node ans = head;
                head = head.next;
                ans.next = null;
                return ans;
            }
            return null;
        }


    }

    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

}
