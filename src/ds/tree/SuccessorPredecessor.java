package ds.tree;

import java.util.ArrayList;

/**
 * https://leetcode.com/problems/inorder-successor-in-bst/description/
 * or
 * https://www.codingninjas.com/studio/problems/predecessor-and-successor-in-bst_893049
 *
 * LeetCode question :
 * Given the root of a binary search tree and a node p in it, return the in-order successor of that node in the BST. If the given node has no in-order successor in the tree, return null.
 *
 * The successor of a node p is the node with the smallest key greater than p.val.
 *
 * Input: root = [2,1,3], p = 1
 * Output: 2
 * Explanation: 1's in-order successor node is 2. Note that both p and the return value is of TreeNode type.
 *
 *
 *
 */
public class SuccessorPredecessor {
    public TreeNode successor(TreeNode root, TreeNode p){
        int key = p.val;
        if(root == null) return null;
        TreeNode successor = null;
        while (root!=null){
            if(key < root.val){
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return successor;
    }

    public TreeNode predecessor(TreeNode root, TreeNode p){
        int key = p.val;
        if(root == null) return null;
        TreeNode predecessor = null;
        while (root!=null){
            if(key <= root.val){
                root = root.left;
            } else{
                predecessor = root;
                root = root.right;
            }
        }
        return predecessor;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.createHeightBalancedBST(new int[]{0,1,2,3,4,5,6,7,8,9,10,11,12,13,14}, 0, 14);
        bst.printTree(root);
        int k = bst.selectRandomElement(root);
        System.out.println("find Successor & Predecessor of "+ k);
        System.out.println("=========================================");


        TreeNode key = new TreeNode(k);
        SuccessorPredecessor sp = new SuccessorPredecessor();

        TreeNode successorResp = sp.successor(root, key);
        Integer successor = successorResp == null ? null : successorResp.val;
        TreeNode predecessorResp = sp.predecessor(root, key);
        Integer predecessor = predecessorResp == null ? null : predecessorResp.val;


        System.out.println("successor : "+ successor);
        System.out.println("predecessor : "+ predecessor);
    }

}
