package cn.tyy.d3.s1_1;

import cn.tyy.d1.ListNode;

import java.util.ArrayList;
import java.util.List;

//TODO 19. 删除链表的倒数第 N 个结点
//  容器
public class Main {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode listNode = new Solution().removeNthFromEnd(n1, 1);
        System.out.println("listNode = " + listNode);
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList();
        while (head!=null){
            list.add(head);
            head = head.next;
        }
        int i = list.size()-n; //下标为i的节点
        if(i==0){
            //删除首节点
            return list.size()==1?null:list.get(1);//存在只有一个节点但是被删除的情况，要单独判断
        }
        ListNode p = list.get(i - 1);
        p.next = p.next.next;
        list.get(i).next = null;
        return list.get(0);

    }
}
