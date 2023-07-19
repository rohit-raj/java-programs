package blind75;

import ds.tree.BinaryTree;
import ds.tree.TreeNode;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 */
public class MaximumPathSum {

    public static int getMaxSum(TreeNode root, int[] max){
        if(root == null) return 0;

        int leftSum = Math.max(0, getMaxSum(root.left, max));
        int rightSum = Math.max(0, getMaxSum(root.right, max));

        max[0] = Math.max(max[0], root.data+leftSum+rightSum);
        System.out.println("root : "+ root.data+" :: left: "+ leftSum+ " :: right: "+ rightSum+ " max : "+ max[0]);
        return root.data + Math.max(leftSum, rightSum);
    }

    static int maxPathSum(TreeNode root) {
        int[] max = {Integer.MIN_VALUE};
        getMaxSum(root, max);
        return max[0];
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int[] items = {14, 3, 32, 30,19, 14, 48, 36, 33};
        TreeNode root = bt.createSpecificTree(items);

        bt.printTree(root);
        System.out.println("maxPathSum : "+ maxPathSum(root));

    }
}
