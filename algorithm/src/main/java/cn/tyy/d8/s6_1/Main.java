package cn.tyy.d8.s6_1;

import cn.tyy.d8.s3_1.TreeNode;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        if (!s1.empty()||!s2.empty()){

        }
    }
}

//102. 二叉树的层序遍历
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Queue<TreeNode> s1 = new LinkedList<>();
        Queue<TreeNode> s2 = new LinkedList<>();

        s1.add(root);

        while (s1.size()>0||s2.size()>0){
            List<Integer> list = new ArrayList<>();
            while (s1.size()>0){
                TreeNode pop = s1.poll();
                list.add(pop.val);
                if(pop.left!=null)
                s2.add(pop.left);
                if(pop.right!=null)
                s2.add(pop.right);

            }
            if(!list.isEmpty())
            res.add(list);
            list = new ArrayList<>();
            while (s2.size()>0){
                TreeNode pop = s2.poll();
                list.add(pop.val);
                if(pop.left!=null)
                s1.add(pop.left);
                if(pop.right!=null)
                s1.add(pop.right);

            }
            if(!list.isEmpty())
            res.add(list);
        }
        
        return res;

    }

}