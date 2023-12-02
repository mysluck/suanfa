

/**
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/?envType=study-plan-v2&envId=top-interview-150
 * <p>
 * K 个一组翻转链表
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换
 */
public class LeetCode25_reverseKGroup {

    //
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        node.next.next.next.next.next = new ListNode(6);
        node.next.next.next.next.next.next = new ListNode(7);
        node.next.next.next.next.next.next.next = new ListNode(8);
        ListNode listNode = reverseKGroup(node, 3);
        while (listNode != null) {
            System.out.print(listNode.val + "  ");
            listNode = listNode.next;
        }


    }

    /**
     * 1、获取第k个的node 判断是否为null null 直接返回
     * 否则
     * 2、start ->end 节点反转 捕获end节点+1位置为lastStart 然后反转后的尾节点指向lastStart
     *
     * @param start
     * @param k
     * @return
     */
    public static ListNode reverseKGroup(ListNode start, int k) {
        ListNode head = null;
        ListNode end = getKGroup(start, k);
        if (end == null) {
            return start;
        }
        head = end;

        reverse(start, end);
        ListNode lastend = start;
        while (lastend.next != null) {
            start = lastend.next;
            end = getKGroup(start, k);
            if (end == null) {
                return head;
            }
            reverse(start, end);
            lastend.next = end;
            lastend = start;
        }
        return head;
    }

    /**
     * start end 反转
     * 反转后的end指向end.next
     *
     * @param start
     * @param end
     * @return
     */
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

    public static ListNode getKGroup(ListNode head, int k) {
        while (--k != 0 && head != null) {
            head = head.next;
        }
        return head;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


}
