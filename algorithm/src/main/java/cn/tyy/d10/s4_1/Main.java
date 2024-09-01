package cn.tyy.d10.s4_1;

import cn.tyy.d8.s3_1.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TreeNode root = TreeNode.createTree();
        ArrayList<Integer> list1 = new ArrayList<>();
//        new Solution().lastOrder1(list1,root);
//        for (Integer i : list1) {
//            System.out.println("i = " + i);
//        }
        boolean symmetric = new Solution().isSymmetric(root);
        System.out.println("symmetric = " + symmetric);
    }
}

//101. 对称二叉树

class Solution {
    public boolean isSymmetric(TreeNode root) {
        //要比较的不是两个节点，而是两棵树，左右两棵树
        //所以对该树的左右两个字数分别 左右中 和 右左中 遍历
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        lastOrder1(list1,root.left);
        lastOrder2(list2,root.right);

        if(list1.size() != list2.size())
            return false;
        for (int i = 0; i < list1.size(); i++) {
            if(list1.get(i) != list2.get(i))
                return false;
        }
        return true;
    }

    public void lastOrder1(List<Integer> list,TreeNode root){
        if(root == null){
            list.add(-101);
            return;
        }
        lastOrder1(list,root.left);
        lastOrder1(list,root.right);
        list.add(root.val);
    }
    public void lastOrder2(List<Integer> list,TreeNode root){
        if(root == null){
            list.add(-101);
            return;
        }
        lastOrder2(list,root.right);
        lastOrder2(list,root.left);
        list.add(root.val);
    }
}
