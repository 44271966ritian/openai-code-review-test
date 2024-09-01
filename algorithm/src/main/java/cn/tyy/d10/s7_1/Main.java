package cn.tyy.d10.s7_1;

import cn.tyy.d8.s3_1.TreeNode;

public class Main {
}

//111. 二叉树的最小深度
class Solution {
    public int minDepth(TreeNode root) {
        if(root == null){
            return 0;
        }

        int left = minDepth(root.left);
        int right = minDepth(root.right);

        if(root.left == null && root.right != null){
            return right + 1;
        }
        if(root.left != null && root.right == null){
            return left + 1;
        }

        return Math.min(left,right) + 1;
    }
}