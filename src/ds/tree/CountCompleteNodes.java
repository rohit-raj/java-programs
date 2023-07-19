package ds.tree;

import java.util.List;

/**
 * https://leetcode.com/problems/count-complete-tree-nodes/
 */
public class CountCompleteNodes {
    public static void iterateBrute(TreeNode root, int[] ans){
        if (root==null){
            return;
        }
        ans[0]++;
        iterateBrute(root.left, ans);
        iterateBrute(root.right, ans);
    }

    public static int countBrute(TreeNode root){
        int[] ans = new int[1];
        iterateBrute(root, ans);
        return ans[0];
    }



    public static int countOptimal(TreeNode root){
        if(root==null) return 0;

        int leftHeight = getLeftHeight(root);
        int rightHeight= getRightHeight(root);

        if(leftHeight == rightHeight) return ((2<<leftHeight)-1);
        else
            return countOptimal(root.left)+countOptimal(root.right)+1;
    }

    public static int getLeftHeight(TreeNode root){
        int count =0;
        while (root.left!=null){
            count++;
            root = root.left;
        }
        return count;
    }

    public static int getRightHeight(TreeNode root){
        int count =0;
        while (root.right!=null){
            count++;
            root = root.right;
        }
        return count;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.createTreeByLevelOrder(new Integer[]{1,2,3,4,5,6,7,8,9,10,11});
        bt.printTree(root);

        System.out.println("=================================\n");
        long t1 = System.nanoTime();
        int ans = countBrute(root);//Brute
        long t2   = System.nanoTime();
        double totalTime = t2-t1;
        System.out.println("count : "+ ans+ " execution time : "+totalTime);

        t1 = System.nanoTime();
        ans = countOptimal(root);//Optimal
        t2   = System.nanoTime();
        totalTime = t2-t1;
        System.out.println("count : "+ ans+ " execution time : "+totalTime);

    }
}
