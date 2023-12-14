package extra;

import java.util.Comparator;
import java.util.PriorityQueue;

public class 合并K个队列 {
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null) {
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new ListNodeComparator());
        for (ListNode n : lists) {
            if (n != null) {
                queue.add(n);
            }
        }
        if (queue.isEmpty()) {
            return null;
        }
        //先获取头节点
        ListNode head = queue.poll();
        ListNode pre = head;
        if (pre.next != null) {
            queue.add(pre.next);
        }
        while (!queue.isEmpty()) {
            ListNode cur = queue.poll();
            pre.next = cur;
            pre = cur;
            if (cur.next != null) {
                queue.add(cur.next);
            }

        }
        return head;

    }

    static class ListNodeComparator implements Comparator<ListNode> {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val;
        }
    }
}
