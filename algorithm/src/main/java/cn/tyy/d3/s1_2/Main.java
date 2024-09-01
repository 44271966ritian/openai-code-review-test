package cn.tyy.d3.s1_2;

import cn.tyy.d1.ListNode;

//TODO 19. 删除链表的倒数第 N 个结点
//  不使用集合 两趟扫描
public class Main {
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = getLen(head);
        //倒数第n个，顺数第len-n+1个,删除节点需要找前一个节点
        int i = len-n;
        //哨兵节点，指向头节点
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode p = node;
        while (p!=null&&i>0){
            p = p.next;
            i--;
        }
        p.next = p.next.next;
        return node.next;
    }

    public int getLen(ListNode head){
        int len = 0;
        while (head!=null){
            head = head.next;
            len++;
        }
        return len;
    }
}
