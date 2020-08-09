package com.company.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class NTreePreorder {

    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        pre(root, list);
        return list;
    }

    private void pre(Node root, List<Integer> list){
        if(null == root){
            return;
        }
        list.add(root.val);
        for(Node node : root.children){
            pre(node, list);
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
    }
}
