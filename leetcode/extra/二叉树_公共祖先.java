package extra;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 返回A B树的公共祖先
 */
public class 二叉树_公共祖先 {

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int data) {
            this.value = data;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        Node node1 = lowestAncestor1(node, node.right.left, node.right.right);
        System.out.println(node1);
        Node node2 = lowestAncestor2(node, node.right.left, node.right.right);
        System.out.println(node2);
    }

    //map方式
    public static Node lowestAncestor1(Node head, Node o1, Node o2) {
        Map<Node, Node> parentMap = new HashMap<>();
        parentMap.put(head, null);
        initParent(head, parentMap);
        Set<Node> nodeSet = new HashSet<>();
        Node pNode = parentMap.get(o1);
        nodeSet.add(pNode);
        while (pNode != null) {
            pNode = parentMap.get(pNode);
            nodeSet.add(pNode);
        }
        Node n2 = o2;
        while (!nodeSet.contains(n2)) {
            n2 = parentMap.get(n2);
        }
        return n2;
    }

    public static void initParent(Node root, Map<Node, Node> parentMap) {
        if (root.left != null) {
            parentMap.put(root.left, root);
            initParent(root.left, parentMap);
        }
        if (root.right != null) {
            parentMap.put(root.right, root);
            initParent(root.right, parentMap);
        }

    }

    public static Node lowestAncestor2(Node head, Node o1, Node o2) {
        return process(head, o1, o2).node;
    }

    public static Info process(Node node, Node o1, Node o2) {
        if (node == null) {
            return new Info(false, false, null);
        }
        Info left = process(node.left, o1, o2);
        Info right = process(node.right, o1, o2);
        boolean findA = left.findA || right.findA || o1 == node;
        boolean findB = left.findB || right.findB || o2 == node;
        Node ans = null;
        if (left.node != null) {
            ans = left.node;
        } else if (right.node != null) {
            ans = right.node;
        } else if (findA && findB) {
            ans = node;
        }
        return new Info(findA, findB, ans);
    }

    public static class Info {
        private boolean findA;
        private boolean findB;
        private Node node;

        public Info(boolean findA, boolean findB, Node node) {
            this.findA = findA;
            this.findB = findB;
            this.node = node;
        }
    }
}