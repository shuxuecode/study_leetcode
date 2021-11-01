package leetcode999;

import org.junit.jupiter.api.Test;

/**
 * @date 2021/11/1
 */
public class N1721 {
    class ListNode {
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

    // 执行用时：1 ms, 在所有 Java 提交中击败了100.00% 的用户
    // 内存消耗：53 MB, 在所有 Java 提交中击败了91.28% 的用户
    public ListNode swapNodes(ListNode head, int k) {
        ListNode cur = head;
        // 记录 链表正数第 k 个节点
        ListNode left = null;

        for (int i = 1; i <= k; i++) {
            left = cur;

            cur = cur.next;
        }

        // 记录 倒数第 k 个节点
        ListNode right = head;
        while (cur != null) {
            cur = cur.next;
            right = right.next;
        }
        // 交换
        int temp = left.val;
        left.val = right.val;
        right.val = temp;

        return head;
    }


    @Test
    void t() {

        ListNode node5 = new ListNode(5, null);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode listNode = swapNodes(node1, 2);

        print(listNode);
    }

    @Test
    void t2() {
        ListNode node1 = new ListNode(1, null);
        ListNode listNode = swapNodes(node1, 1);
        print(listNode);
    }

    @Test
    void t3() {
        ListNode node2 = new ListNode(2, null);
        ListNode node1 = new ListNode(1, node2);
        ListNode listNode = swapNodes(node1, 1);
        print(listNode);
    }

    @Test
    void t4() {
        ListNode node3 = new ListNode(3, null);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode listNode = swapNodes(node1, 2);

        print(listNode);
    }


    public void print(ListNode head) {
        System.out.println();
        while (head != null) {
            System.out.print(head.val);
            System.out.print(" , ");

            head = head.next;
        }
        System.out.println();
    }
}
