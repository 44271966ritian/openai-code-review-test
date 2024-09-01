package cn.tyy.d1.s2_1;

import cn.tyy.d1.ListNode;

//TODO　环形链表II　快慢指针
public class Main {
}

class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head,fast = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            //如果有环，fast和slow就会相遇
            if (slow == fast) {
                while (head != slow){
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
        }
        //如果没有环，退出while循环返回null
        return null;
    }
}