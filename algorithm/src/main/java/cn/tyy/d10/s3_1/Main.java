package cn.tyy.d10.s3_1;

import cn.tyy.d8.s3_1.TreeNode;

public class Main {
}
//226. 翻转二叉树
class Solution {
    public TreeNode invertTree(TreeNode root) {
        //对于每一棵子树，交换左右子树
        swap(root);
        return root;
    }
    public void swap(TreeNode root){
        if(root == null){
            return;
        }
        swap(root.left);
        swap(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
