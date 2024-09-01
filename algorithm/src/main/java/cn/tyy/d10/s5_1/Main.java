package cn.tyy.d10.s5_1;

import cn.tyy.d8.s3_1.TreeNode;

public class Main {
}
//104. 二叉树的最大深度
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftDept = maxDepth(root.left);
        int rightDept = maxDepth(root.right);

        return 1+Math.max(leftDept,rightDept);
    }
}
