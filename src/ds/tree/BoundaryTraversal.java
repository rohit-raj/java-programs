package ds.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/boundary-of-binary-tree/
 */
public class BoundaryTraversal {
    public static boolean isLeafNode(TreeNode root){
        return (root.left == null) && (root.right == null);
    }

    public static void getLeft(TreeNode root, List<Integer> ans){
        TreeNode curr = root.left;
        while (curr != null){
            if(!isLeafNode(curr)) ans.add(curr.data);
            if(curr.left == null) curr = curr.right;
            else curr = curr.left;
        }
    }

    public static void getLeaf(TreeNode root, List<Integer> ans){
        if (isLeafNode(root)) {
            ans.add(root.data);
            return;
        }
        if (root.left != null) getLeaf(root.left, ans);
        if (root.right != null) getLeaf(root.right, ans);
    }

    public static void getRight(TreeNode root, List<Integer> ans){
        TreeNode curr = root.right;
        List<Integer> items = new ArrayList<>();
        while (curr!=null){
            if(!isLeafNode(curr)) items.add(curr.data);
            if(curr.right != null) curr = curr.right;
            else curr = curr.left;
        }
        for (int i=items.size()-1;i>=0;i--){
            ans.add(items.get(i));
        }
    }

    static public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> elements = new ArrayList<>();
        if (root == null) return elements;

        //left -> leaf -> right(reverse)

        if (!isLeafNode(root))
            elements.add(root.data);
        getLeft(root, elements);
        getLeaf(root, elements);
        getRight(root, elements);

        return elements;
    }
    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.createRandomTree();
        bt.printTree(root);
        long startTime = System.nanoTime();
        List<Integer> ans = boundaryOfBinaryTree(root);
        long endTime   = System.nanoTime();
        double totalTime = endTime-startTime;
        System.out.println("items : "+ ans+ " execution time : "+totalTime);
    }
}
