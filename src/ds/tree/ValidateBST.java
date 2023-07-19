package ds.tree;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBST {

    public boolean isValidBST(TreeNode root){
        return isBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean isBST(TreeNode root, long maxVal, long minVal){
        if(root == null) return true;
        if(root.val >= maxVal || root.val <= minVal) return false;
        boolean left = isBST(root.left, root.val, minVal);
        boolean right = isBST(root.right, maxVal, root.val);
        return left && right;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        BinaryTree bt = new BinaryTree();
//        TreeNode root = bst.createSpecificBst(new Integer[]{9,-19,4});//,null,null,0,13,null,null,6,20});
        TreeNode root = bt.createTreeByLevelOrder(new Integer[]{1,null,1});
        bst.printTree(root);

        ValidateBST vt = new ValidateBST();
        System.out.println("isValid : "+ vt.isValidBST(root));
    }
}
