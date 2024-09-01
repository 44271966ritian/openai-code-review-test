package cn.tyy.d10.s6_1;

import java.util.List;

public class Main {
}
//559. N 叉树的最大深度
class Solution {
    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        int res = 0;
        List<Node> children = root.children;
        for (Node child : children) {
            int depth = maxDepth(child);
            res = Math.max(res,depth);
        }

        return res+1;
    }
}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};