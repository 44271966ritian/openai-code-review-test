package cn.tyy.d9.s1_1;

import java.security.PublicKey;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListNode head = ListNode.getList();
        ListNode.print(head);
        head = new Solution().reverseLinkList(head);
        System.out.println();
        ListNode.print(head);
    }
}

class Solution{
    public ListNode reverseLinkList(ListNode head){
        if(head == null){
            return null;
        }
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null){
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }

        return pre;
    }
}

class ListNode{
    public int val;
    public ListNode next;

    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(){}

    public static ListNode getList(){
        System.out.println("请输入所需要链表的节点数:");
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if(num<=0){
            System.out.println("长度小于1，不符合");
            return null;
        }
        int i = 1;
        System.out.println("请输入第"+i+"个节点的值:");
        int headVal = scanner.nextInt();
        ListNode head = new ListNode(headVal);
        ListNode p = head;
        i++;
        while (i<=num){
            System.out.println("请输入第"+i+"个节点的值:");
            int val = scanner.nextInt();
            ListNode listNode = new ListNode(val);
            p.next = listNode;
            p = p.next;
            i++;
        }

        return head;
    }

    public static void print(ListNode head){
        while (head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }

}
