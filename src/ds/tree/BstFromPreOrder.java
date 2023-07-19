package ds.tree;

import algo.searching.BinarySearch;

/**
 *
 */
public class BstFromPreOrder {
    public TreeNode bstFromPreOrder(int[] items){
        TreeNode root = null;
        for(int item : items){
            root = createBST(root, item);
        }
        return root;
    }
    public TreeNode createBST(TreeNode root, int item){
        if(root == null){
            root = new TreeNode(item);
            return root;
        } else if(item < root.val){
            root.left = createBST(root.left, item);
        } else {
            root.right = createBST(root.right, item);
        }
        return root;
    }


    public static void main(String[] args) {
        BstFromPreOrder bst = new BstFromPreOrder();
        TreeNode root = bst.bstFromPreOrder(new int[]{8,5,1,7,10,12});

        BinarySearchTree bstree = new BinarySearchTree();
        bstree.printTree(root);
    }
}
