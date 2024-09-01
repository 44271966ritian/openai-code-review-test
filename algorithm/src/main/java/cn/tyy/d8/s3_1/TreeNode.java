package cn.tyy.d8.s3_1;

import java.util.Scanner;

public class TreeNode {
     public int val;
     public TreeNode left;
     public TreeNode right;
     TreeNode() {}
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }

     public static TreeNode createTree(){
         Scanner in = new Scanner(System.in);
         int val = in.nextInt();
         TreeNode root = new TreeNode(val);
         if(val == -999)
             return null;
         root.left = createTree();
         root.right = createTree();

         return root;
     }
 }

