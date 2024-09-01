package cn.tyy.d3.s1_3;

import cn.tyy.d1.ListNode;

//TODO 19. 删除链表的倒数第 N 个结点
//  一趟循环解决 双指针
public class Main {
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        //哨兵节点比较方便删除头节点
        ListNode p = new ListNode(1);
        p.next = head;
        ListNode s = p,f = p;
        n++;
        while (f!=null&&n>0){
            f = f.next;
            n--;
        }
        while (f!=null&&s!=null){
            f = f.next;
            s = s.next;
        }
        s.next = s.next.next;
        return p.next;

    }
}

