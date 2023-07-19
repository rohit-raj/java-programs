package blind75;

import ds.tree.BinaryTree;
import ds.tree.TreeNode;

/**
 * https://leetcode.com/problems/maximum-depth-of-binary-tree/
 */
public class HeightOfTree {

    static int heightOfTree(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        return 1+Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.createRandomTree();
        bt.printTree(root);
        System.out.println("heightOfTree :"+heightOfTree(root));
    }
}
