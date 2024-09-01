package cn.tyy.d3.s2_1;

import cn.tyy.d1.ListNode;

//TODO 面试题 02.07. 链表相交
//  复习
public class Main {
}
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        int l1 = len(headA);
        int l2 = len(headB);
        if(l1>l2){
            int n = l1-l2;
            while (n>0){
                n--;
                headA = headA.next;
            }
        }else {
            int n = l2-l1;
            while (n>0){
                n--;
                headB = headB.next;
            }
        }

        while (headA!=null&&headB!=null){
            if(headA==headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;


    }
    public int len(ListNode head){
        int len = 0;
        while (head!=null){
            head = head.next;
            len++;
        }
        return len;
    }
}
