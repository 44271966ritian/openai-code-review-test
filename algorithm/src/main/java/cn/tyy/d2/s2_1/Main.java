package cn.tyy.d2.s2_1;

import cn.tyy.d1.ListNode;

import java.util.List;
//TODO 24. 两两交换链表中的节点 递归 pre记录前导节点，交换两个节点，pre指向temp
public class Main {
}

class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode res = head.next;
        cx(null,head);
        return res;
    }
    public void cx(ListNode pre, ListNode head){
        if(head ==null||head.next==null){
            return;
        }
        ListNode temp = head.next;
        head.next = head.next.next;
        temp.next = head;


        if(pre!=null){
            pre.next = temp;
        }
        pre = head;
        cx(head,head.next);
    }
}
