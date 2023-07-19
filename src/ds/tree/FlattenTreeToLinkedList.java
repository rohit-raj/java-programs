package ds.tree;

import ds.linkedlist.SinglyLinkedList;

import java.util.*;

/**
 * https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenTreeToLinkedList {
    //Flatten using Preorder
    public static void flattenUsingStack(TreeNode root){
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode node = stack.pop();

            if(node.right !=null) stack.push(node.right);
            if(node.left != null) stack.push(node.left);

            if(!stack.isEmpty())
                node.right = stack.pop();

            node.left = null;
        }
    }

    static TreeNode prev = null;
    public static void flattenRecursive(TreeNode root){
        if(root == null) return;

        flattenRecursive(root.right);
        flattenRecursive(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }

    public static void flattenRecursive2(TreeNode root){
        flattenTree(root);
    }

    public static TreeNode flattenTree(TreeNode node) {
        if(node == null) return null;

        TreeNode leftTail = flattenTree(node.left);
        if(leftTail != null){
            leftTail.right = node.right;
            node.right = node.left;
            node.left = null;
        }

        TreeNode rightTail = flattenTree(node.right);

        if(rightTail != null){
            return rightTail;
        }

        if(leftTail != null){
            return leftTail;
        }

        return node;
    }



    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        TreeNode root = bt.createTreeByLevelOrder(new Integer[]{1,2,5,3,4,null,6});
        bt.printTree(root);
        flattenUsingStack(root);

        print(root);
    }

    public static void print(TreeNode root){
        TreeNode n = root;
        while (n != null){
            System.out.print(n.data + " => ");
            n = n.right;
        }
        System.out.println("Null");
    }
}
