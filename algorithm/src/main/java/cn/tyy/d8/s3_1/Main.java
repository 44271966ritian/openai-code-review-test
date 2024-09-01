package cn.tyy.d8.s3_1;

//144. 二叉树的前序遍历

import java.util.ArrayList;
import java.util.List;

public class Main {
}

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preOrder(root,res);
        return res;
    }

    public void preOrder(TreeNode node,List<Integer> list){
        if(node == null){
            return;
        }
        list.add(node.val);
        preOrder(node.left,list);
        preOrder(node.right,list);
    }
}
