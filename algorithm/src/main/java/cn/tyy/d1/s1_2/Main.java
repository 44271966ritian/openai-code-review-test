package cn.tyy.d1.s1_2;


import cn.tyy.d1.ListNode;

//TODO 链表相交 不使用集合
public class Main {

}

class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        //不使用集合

        //先计算长度
        int la = length(headA);

        int lb = length(headB);


        //将长的链表前端剪掉
        if (la > lb) {

            for (int i = 0; i < la - lb; i++) {
                headA = headA.next;
            }
        } else {
            for (int i = 0; i < lb - la; i++) {
                headB = headB.next;
            }
        }


        while (headA != null && headB != null) {

            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return null;
    }

    public int length(ListNode head) {
        int len = 0;
        while (head != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}