package problem.two;

/**
 * 动态规划可以解决矩阵乘法
 * 1.两个链表同时结束
 * 2.一个长一个短
 * 3.结束了还有进位
 * 4.即使是第一次计算也要考虑进位
 * 5.1和2不必分开考虑
 * 6.考虑不用十进制
 * Created by will.wang on 2015/4/15.
 */
public class Main {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        ListNode l3 = new ListNode(9);
//        l2.next = l3;

        ListNode result = addTwoNumbers(l1, l2);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;

        ListNode first = l1;
        ListNode second = l2;

        ListNode result = null;
        ListNode preNode = null;
        while (first != null && second != null) {
            int var1 = first.val;
            int var2 = second.val;
            int sum = var1 + var2 + carry;

            carry = sum > 9 ? sum / 10 : 0;
            sum = sum - carry * 10;

            ListNode nodeTmp = new ListNode(sum);
            if(result == null) {
                result = nodeTmp;
            }

            if(preNode == null) {
                preNode = nodeTmp;
            } else {
                preNode.next = nodeTmp;
                preNode = preNode.next;
            }

            first = first.next;
            second = second.next;
        }

        ListNode nodeH = first == null ? second : first;

        while(nodeH != null) {
            int var1 = nodeH.val;
            int sum = var1 + carry;

            carry = sum > 9 ? sum / 10 : 0;
            sum = sum - carry * 10;

            ListNode nodeTmp = new ListNode(sum);
            if(result == null) {
                result = nodeTmp;
            }

            if(preNode == null) {
                preNode = nodeTmp;
            } else {
                preNode.next = nodeTmp;
                preNode = preNode.next;

            }

            nodeH = nodeH.next;
        }

        if(carry != 0) {
            ListNode node = new ListNode(carry);
            if(result == null) {
                result = node;
            }
            if(preNode == null) {
                preNode = node;
            } else {
                preNode.next = node;
                preNode = preNode.next;
            }
        }

        return result;

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;

        int value = (l1.val + l2.val) % 10;
        int carry = (l1.val + l2.val) / 10;
        ListNode head = new ListNode(value);
        ListNode tail = head;
        l1 = l1.next;
        l2 = l2.next;
        while (!(l1 == null && l2 == null && carry == 0)) {
            int temValue = carry;
            if (l1 != null) {
                temValue += l1.val;
            }
            if (l2 != null) {
                temValue += l2.val;
            }
            value = (temValue) % 10;
            carry = (temValue) / 10;
            ListNode node = new ListNode(value);
            tail.next = node;
            tail = node;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        return head;
    }

class Solution2 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode nh = new ListNode(0);
            ListNode l = nh;
            int carry = 0;
            while ( l1 != null || l2 != null ) {
                int n = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
                carry = n / 10;
                n = n % 10;
                l.next = new ListNode(n);
                l = l.next;
                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
            }
            if ( carry > 0 ) {
                l.next = new ListNode(carry);
            }
            return nh.next;
        }
    }
}


