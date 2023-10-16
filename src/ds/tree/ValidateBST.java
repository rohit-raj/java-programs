package ds.tree;

/**
 * https://leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBST {

    public boolean isValidBST(TreeNode root) {
        return isBST(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public boolean isBST(TreeNode root, long maxVal, long minVal) {
        if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        boolean left = isBST(root.left, root.val, minVal);
        boolean right = isBST(root.right, maxVal, root.val);
        return left && right;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        BinaryTree bt = new BinaryTree();
//        TreeNode root = bst.createSpecificBst(new Integer[]{10, 5, 2, 1, 5, 15, 13, 14, 22});//,null,null,0,13,null,null,6,20});
        TreeNode root = bt.createTreeByLevelOrder(new Integer[]{10,5,15,2,5,13,22,1,null,null,null,null,14});
        /*TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.left.left = new TreeNode(1);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(13);
        root.right.left.right = new TreeNode(14);
        root.right.right = new TreeNode(22);*/

        bst.printTree(root);

        ValidateBST vt = new ValidateBST();
        System.out.println("isValid : " + vt.isValidBST(root));
    }
}
//    10,5,15,2,5,13,22,1,null,null,null,null,14
