package ds.tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/two-sum-iv-input-is-a-bst/
 */

public class TwoSumInBst {

    //Brute Starts
    private final List<Integer> inOrderList = new ArrayList<>();

    public void inOrder(TreeNode root){
        if(root == null) return;
        inOrder(root.left);
        inOrderList.add(root.val);
        inOrder(root.right);
    }

    public boolean findTargetBrute(TreeNode root, int k){
        inOrder(root);
        if (inOrderList.size()<2) return false;

        int i=0,j=inOrderList.size()-1;
        while (i<j){
            if(inOrderList.get(i) + inOrderList.get(j) == k) return true;
            else if(inOrderList.get(i) + inOrderList.get(j) > k){
                j--;
            } else{
                i++;
            }
        }
        return false;
    }

    //Brute Ends

    // Optimal with not optimal memory Starts
    public boolean findTargetOptimal(TreeNode root, int key){
        return helper(root, root, key);
    }

    public boolean helper(TreeNode root, TreeNode current, int key){
        if(current == null) return false;
        if(findInTree(root, current, key-current.val)) return true;

        return helper(root, current.left, key) || helper(root, current.right, key);
    }

    public boolean findInTree(TreeNode root, TreeNode current, int key){
        if(root == null) return false;

        if(root.val > key){
            return findInTree(root.left, current, key);
        } else if(root.val < key){
            return findInTree(root.right, current, key);
        } else {
            return key!=current.val;
        }
    }

    // Optimal with not optimal space ends

    // using hashset start optimal memory but
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> numsSeen = new HashSet<>();
        return findTargetHelper(root, k, numsSeen);
    }


    private boolean findTargetHelper(TreeNode root, int k, HashSet<Integer> numsSeen) {
        if (root == null) {
            return false;
        }

        if (numsSeen.contains(k - root.val)) {
            return true;
        }

        numsSeen.add(root.val);

        return findTargetHelper(root.left, k, numsSeen) || findTargetHelper(root.right, k, numsSeen);
    }
    //using hashset ends

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        int[] input = new int[]{2};
        TreeNode root = bst.createHeightBalancedBST(input, 0, input.length-1);
        bst.printTree(root);
        int k1 = bst.selectRandomElement(root);
        int k2 = bst.selectRandomElement(root);
        int sum = 2;
        System.out.println("find pairs("+k1+","+k2+") for sum "+ sum);
        System.out.println("=========================================");

        TwoSumInBst tw = new TwoSumInBst();
        System.out.println(tw.findTargetBrute(root, sum));
        System.out.println(tw.findTargetOptimal(root, sum));
    }
}
