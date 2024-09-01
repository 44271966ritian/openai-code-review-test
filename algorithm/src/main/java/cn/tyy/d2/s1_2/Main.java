package cn.tyy.d2.s1_2;

import cn.tyy.d1.ListNode;

//TODO 206. 反转链表 不使用额外空间 双指针法
public class Main {
}

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;

    }
}