package cn.tyy.d2.s1_3;

import cn.tyy.d1.ListNode;

//TODO 206. 反转链表 递归
public class Main {
}

class Solution {
    public ListNode reverseList(ListNode head) {
        return cx(null,head);
    }

    public ListNode cx(ListNode pre,ListNode cur){
        if(cur == null){
            return pre;
        }
        ListNode temp = cur.next;
        cur.next = pre;
        pre = cur;
        cur = temp;

        return cx(pre,cur);
    }
}