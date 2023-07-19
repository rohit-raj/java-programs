package ds.tree;

/**
 * https://leetcode.com/problems/subtree-of-another-tree/
 */
public class SubtreeOfAnotherTree {

    public static boolean isSameTree(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;

        if(root1 == null || root2 == null) return false;

        if(root1.val != root2.val) return false;

        return isSameTree(root1.right, root2.right) && isSameTree(root1.left, root2.left);
    }


    public static boolean isSubTree(TreeNode root, TreeNode subRoot){
        if (root == null) return false;

        if (isSameTree(root, subRoot))
            return true;

        return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
    }


    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.createTreeByLevelOrder(new Integer[]{3,4,5,1,2});
        bt.printTree(root);

        TreeNode subRoot = bt.createTreeByLevelOrder(new Integer[]{4,1,2});
        System.out.println("isSubTree :: "+isSubTree(root, subRoot));
    }
}
