package ds.tree;

/**
 * https://leetcode.com/problems/symmetric-tree/
 */
public class SymmetricTree {
    public static boolean isSymmetricOptimal(TreeNode root){
        if(root == null) return true;
        return helperOptimal(root, root);
    }

    static boolean helperOptimal(TreeNode leftTree, TreeNode rightTree){
        if(leftTree == null && rightTree == null)
            return true;

        if(leftTree!=null && rightTree!=null && leftTree.data == rightTree.data){
            boolean b1 = helperOptimal(leftTree.left, rightTree.right);
            boolean b2 = helperOptimal(leftTree.right, rightTree.left);
            return b1 && b2;
        }
        return false;
    }

    public static boolean isSymmetric(TreeNode root){
        if(root == null) return true;
        return helper(root.left, root.right);
    }

    public static boolean helper(TreeNode root1, TreeNode root2){
        if (root1 == null || root2 == null)
            return root1 == root2;
        return (root1.data == root2.data) && helper(root1.left, root2.right) && helper(root1.right, root2.left);
    }


    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.createTreeByLevelOrder(new Integer[]{1,2,2,null,3,null,3});
        bt.printTree(root);
        System.out.println("isSymmetricOptimal : "+isSymmetricOptimal(root));
        System.out.println("isSymmetricOther : "+isSymmetric(root));
    }
}
