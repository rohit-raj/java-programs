package ds.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 */
public class KthSmallestElementInBST {
    public static int kthSmallestElementBetter(TreeNode root, int k){
        List<Integer> list = new ArrayList<>();
        traverseBetter(root, k, list);
        return list.get(k-1);

    }


    public static void traverseBetter(TreeNode root, int k, List<Integer> list){
        if(root == null) return;
        if(list.size() < k) {
            traverseBetter(root.left, k, list);
            list.add(root.val);
            traverseBetter(root.right, k, list);
        }
    }

    public static int kthSmallestElementOptimal(TreeNode root, int k){
        int[] count = {k};
        TreeNode ans = traverse2(root, count);
        return ans.val;

    }

    public static TreeNode traverse2(TreeNode root, int[] count){
        if(root == null) return null;
        TreeNode left = traverse2(root.left, count);
        if(left!= null) return left;

        count[0]--;
        if(count[0] == 0) return root;
        return traverse2(root.right, count);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.createRandomBST();
        bst.printTree(root);
        Traversal ts = new Traversal();
//        System.out.println("inOrder : "+ ts.inOrderTraversal(root));

        int k = bst.selectRandomElementIndex(root)+1;
        System.out.println("k : "+ k);

        System.out.println("element at "+ k+" in BST :: "+ kthSmallestElementBetter(root, k));
        System.out.println("element at "+ k+" in BST :: "+ kthSmallestElementOptimal(root, k));
    }
}
