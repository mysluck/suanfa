package 新手班;

public class 链表相加 {
    public static void main(String[] args) {
        ListNode node = new ListNode(9);
        node.next = new ListNode(9);
//        node.next.next = new ListNode(3);

        ListNode node1 = new ListNode(9);
//        node1.next = new ListNode(1);
        ListNode listNode = addTwoNumbers(node, node1);
        ListNode.print(listNode);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int length = getLength(l1);
        int length1 = getLength(l2);
        ListNode l = length > length1 ? l1 : l2;
        ListNode s = l == l1 ? l2 : l1;
        ListNode add = add(l, s);
        return add;
    }


    public static ListNode add(ListNode l, ListNode s) {
        int carry = 0;
        ListNode head = l;
        ListNode last = l;
        while (s != null) {
            int val = l.val;
            int sVal = s.val;
            int cur = val + sVal + carry;
            l.val = cur % 10;
            carry = cur / 10;
            last=l;
            s = s.next;
            l = l.next;
        }
        while (l != null) {
            int val = l.val;
            int cur = val + carry;
            l.val = cur % 10;
            carry = cur / 10;
            last=l;
            l = l.next;
        }
        if (carry != 0) {
            last.next = new ListNode(1);
        }
        return head;
    }

    public static int getLength(ListNode node) {
        if (node == null) {
            return 0;
        }
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
}
