package cn.tyy.d2.s1_1;

import cn.tyy.d1.ListNode;

import java.util.ArrayList;
import java.util.List;

//TODO 206. 反转链表 使用集合
public class Main {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next=n2;
        n2.next=n3;
        n3.next=n4;
        n4.next=n5;


    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        List<ListNode> list = new ArrayList<>();
        ListNode p = head;
        while (p!=null){
            list.add(p);
            p=p.next;
        }
        ListNode res = list.get(0);
        res.next = null;
        for (int i = 1; i <list.size(); i++) {
            ListNode temp = list.get(i);
            temp.next = res;
            res = temp;
        }

        return res;
    }


}

