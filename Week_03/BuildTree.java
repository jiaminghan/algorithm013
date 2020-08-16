package com.company.leetcode.mid;

import com.company.Utils;
import com.company.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class BuildTree {
    public static void main(String[] args){
        BuildTree b = new BuildTree();
        TreeNode root = b.buildTree(new int[]{2,1,3}, new int[]{1,2,3});
        Utils.genericPrintln(root.val);
        Utils.genericPrintln(root.left.val);
        Utils.genericPrintln(root.right.val);
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int index = 0; index < inorder.length; index++){
            map.put(inorder[index], index);
        }
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    private TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, Map<Integer, Integer> inOrderMap){
        if(preStart == preEnd){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inOrderIndexRoot = inOrderMap.get(preorder[preStart]);
        int leftChildSize = inOrderIndexRoot - inStart;
        root.left = buildTreeHelper(preorder, preStart+1, preStart+1+leftChildSize, inorder, inStart, inOrderIndexRoot, inOrderMap);
        root.right = buildTreeHelper(preorder, preStart+1+leftChildSize, preEnd,inorder, inOrderIndexRoot+1, inEnd, inOrderMap);
        return root;
    }
}
