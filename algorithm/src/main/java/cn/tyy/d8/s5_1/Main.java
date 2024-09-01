package cn.tyy.d8.s5_1;

import cn.tyy.d8.s3_1.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Main {
}

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(root,list);
        return list;
    }

    public void postOrder(TreeNode node,List<Integer> list){
        if(node == null){
            return;
        }
        postOrder(node.left,list);
        postOrder(node.right,list);
        list.add(node.val);
    }
}
