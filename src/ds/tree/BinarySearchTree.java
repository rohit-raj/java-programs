package ds.tree;

import java.util.List;
import java.util.Random;

import static ds.tree.PrintTree.print;

/**
 *
 */
public class BinarySearchTree {

    /**
     * Binary Search Tree
     * Height Balanced Tree
     * https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
     */
    public TreeNode createHeightBalancedBST(int[] items, int low, int high){
        if (low > high) return null;

        int mid = low + (high-low)/2;
        TreeNode root = new TreeNode(items[mid]);
        root.left = createHeightBalancedBST(items, low, mid-1);
        root.right = createHeightBalancedBST(items, mid+1, high);
        return root;
    }

    public void printTree(TreeNode root){
        print(root);
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

    public TreeNode createRandomBST(){
        Random random = new Random();
        int size = random.nextInt(10);
        System.out.println("size : "+ size);
        int min = -30, max = 30;
        TreeNode root = null;
        for(int j = 0; j < size; j++) {
            int x = random.nextInt((max - min) + 1) + min;
            root = createBST(root, x);
        }
        return root;
    }

    public TreeNode createSpecificBst(Integer[] items){
        BinaryTree bt = new BinaryTree();
        return bt.createTreeByLevelOrder(items);
    }

    public int selectRandomElement(TreeNode root){
        if(root == null) return 0;

        Traversal ts = new Traversal();
        List<Integer> items = ts.inOrderTraversal(root);


        Random random = new Random();
        int index = random.nextInt(items.size());

        return items.get(index);

    }

    public int selectRandomElementIndex(TreeNode root){
        if(root == null) return 0;

        Traversal ts = new Traversal();
        List<Integer> items = ts.inOrderTraversal(root);


        Random random = new Random();
        return random.nextInt(items.size());
    }

    public static void main(String[] args) {
        int[] items = {-10,-3,0,5,9};
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.createRandomBST();
        bst.printTree(root);
        Traversal ts = new Traversal();
        System.out.println("preOrder : "+ ts.preOrderTraversal(root));
        System.out.println("inOrder : "+ ts.inOrderTraversal(root));
        System.out.println("postOrder : "+ ts.postOrderTraversal(root));
    }
}
