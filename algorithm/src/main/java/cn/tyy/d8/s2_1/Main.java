package cn.tyy.d8.s2_1;

import cn.tyy.d1.ListNode;

public class Main {
}

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }

        ListNode pre = null;
        ListNode cur = head;

        while (cur!=null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }
}
