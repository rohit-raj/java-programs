package blind75;

import ds.tree.BinaryTree;
import ds.tree.TreeNode;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 */
public class LowestCommonAncestorBST {
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B){
        if(root ==null) return null;
        if(root.val > A.val && root.val > B.val){
            return lowestCommonAncestor(root.left, A, B);
        } else if(root.val < A.val && root.val < B.val){
            return lowestCommonAncestor(root.right, A, B);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.createTreeByLevelOrder(new Integer[]{6,2,8,0,4,7,9,null,null,3,5});
        bt.printTree(root);
        TreeNode A = root.left;
        TreeNode B = root.right;
        System.out.println("\n\nNode A : "+ A.val+" : Node B : "+B.val);
        TreeNode ans = lowestCommonAncestor(root, A, B);
        System.out.println("\nLCA is : " + ans.val);
    }
}
