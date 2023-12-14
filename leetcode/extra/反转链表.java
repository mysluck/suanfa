package extra;

// 1 2 3 4 5 6 7 -》 3 === 3 2 1 6 5 4 7
public class 反转链表 {
    public static void main(String[] args) {

    }


    public static ListNode getKGroupEnd(ListNode start, int k) {
        while (--k != 0 && start != null) {
            start = start.next;
        }
        return start;
    }


    public static void reverse(ListNode start, ListNode end) {
        end = end.next;
        ListNode pre = null;
        ListNode cur = start;
        ListNode next = null;
        while (cur != end) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        start.next = end;
    }


    // 不要提交这个类
    public static class ListNode {
        public int val;
        public ListNode next;
    }

}
