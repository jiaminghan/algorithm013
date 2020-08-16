package com.company.leetcode.mid;

import com.company.Utils;
import com.company.leetcode.TreeNode;

public class LowestCommonAncestor {

    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode left2 = new TreeNode(4);
        root.left = left;
        root.right = right;
        left.left = left2;
        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        TreeNode lca = lowestCommonAncestor.lowestCommonAncestor(root, left2, left);
        Utils.genericPrintln(lca.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(null == root || root == p || root == q){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        return root;
    }
}
