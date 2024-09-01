package cn.tyy.d8.s4_1;
//94. 二叉树的中序遍历
import cn.tyy.d8.s3_1.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Main {
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return list;
    }
    public void inorder(TreeNode node,List<Integer> list){
        if(node==null){
            return;
        }
        inorder(node.left,list);
        list.add(node.val);
        inorder(node.right,list);
    }
}
