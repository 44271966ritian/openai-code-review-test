package cn.tyy.d1.s1_1;

import cn.tyy.d1.ListNode;

import java.util.ArrayList;
import java.util.List;

//TODO  链表相交 集合解法

public class Main {
    public static void main(String[] args) {

    }



}


class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //集合存储

        List<ListNode> list1 = new ArrayList<>();
        List<ListNode> list2 = new ArrayList<>();

        while (headA!=null){

            list1.add(headA);
            headA = headA.next;
        }

        while (headB!=null){

            list2.add(headB);
            headB = headB.next;
        }

        for (ListNode listNode : list1) {
            for (ListNode node : list2) {

                if (listNode == node){
                    return listNode;
                }
            }
        }

        return null;
    }
}