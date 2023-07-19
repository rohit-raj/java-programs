package ds.tree;

/**
 * https://leetcode.com/problems/search-in-a-binary-search-tree/
 */
public class SearchInBst {
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root== null) return null;
        if(val < root.val){
            return searchBST(root.left, val);
        } else if(val > root.val){
            return searchBST(root.right, val);
        } else {
            return root;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.createRandomBST();
        bst.printTree(root);

        int val = bst.selectRandomElement(root);
        System.out.println("===========================");

        System.out.println("search "+ val+" in BST :: "+ searchBST(root, val));
    }

}
