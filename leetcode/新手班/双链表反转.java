package 新手班;


public class 双链表反转 {

    static class Node {
        int value;
        Node next;
        Node last;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        print(node);
        Node reverse = reverse(node);
        print(reverse);
    }

    public static Node reverse(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static void print(Node head) {
        while (head != null) {
            System.out.print(head.value + " ");
            head=head.next;
        }
        System.out.println();
    }
}
