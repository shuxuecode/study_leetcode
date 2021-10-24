package leetcode200;

import com.sun.org.apache.regexp.internal.REUtil;
import org.junit.jupiter.api.Test;

public class N237 {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    ListNode head = null;

    public void deleteNode(ListNode node) {

        if (head.val == node.val) {
            head = head.next;
            return;
        }

        ListNode cur = head;

        while (cur.next != null) {
            if (cur.next.val == node.val) {
                cur.next = cur.next.next;
                return;
            }

            cur = cur.next;
        }

//         todo
//        node.val = node.next.val;
//        node.next = node.next.next;
    }


    @Test
    void t() {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        head = node1;

        deleteNode(node3);

        print(head);
    }


    public void print(ListNode node) {
        while (node != null) {
            System.out.println(node.val);

            node = node.next;
        }
    }
}
