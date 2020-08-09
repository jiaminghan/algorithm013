package com.company.leetcode.mid;

import java.lang.reflect.Array;
import java.util.*;

public class LevelOrder {

    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        if(null == root){
            return result;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.addFirst(root);
        int levelNodeNum;
        Node curNode;
        List<Integer> innerList;
        while(!deque.isEmpty()){
            innerList = new ArrayList<>();
            levelNodeNum = deque.size();
            for(int num = 0; num < levelNodeNum; num++){
                curNode = deque.pollFirst();
                innerList.add(curNode.val);
                deque.addAll(curNode.children);
            }
            result.add(innerList);
        }
        return result;
    }

    public List<List<Integer>> levelOrder1(Node root) {
        List<Node> cur = Arrays.asList(root);
        List<Node> next;
        List<List<Integer>> result = new ArrayList<>();
        while(cur.size() > 0){
            List<Integer> list = new ArrayList<>();
            next = new ArrayList<>();
            for(Node node : cur){
                list.add(node.val);
                next.addAll(node.children);
            }
            cur = next;
            result.add(list);
        }
        return result;
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
}
