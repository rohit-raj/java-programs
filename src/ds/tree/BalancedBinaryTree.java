package ds.tree;

public class BalancedBinaryTree {
    public static int heightOfTree(TreeNode root){
        if (root == null) return 0;
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);
        return 1+Math.max(leftHeight, rightHeight);
    }

    public static boolean checkBalancedBrute(TreeNode root){
        if(root == null) return true;
        int leftHeight = heightOfTree(root.left);
        int rightHeight = heightOfTree(root.right);

        if(Math.abs(rightHeight-leftHeight)>1) return false;

        boolean left = checkBalancedBrute(root.left);
        boolean right = checkBalancedBrute(root.right);

        if(!left || !right) return false;
        return true;
    }

    public static int checkHeightAndBalanced(TreeNode root){
        if (root == null) return 0;

        int leftHeight = checkHeightAndBalanced(root.left);
        if(leftHeight == -1) return -1;

        int rightHeight = checkHeightAndBalanced(root.right);
        if(rightHeight == -1) return -1;

        if(Math.abs(rightHeight-leftHeight)>1) return -1;

        return 1+Math.max(leftHeight, rightHeight);
    }

    public static boolean checkBalanceOptimal(TreeNode root){
        return checkHeightAndBalanced(root)!=-1;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.createRandomTree();

        bt.printTree(root);

        System.out.println("checkBalancedBrute :: "+ checkBalancedBrute(root));
        System.out.println("checkBalanceOptimal :: "+ checkBalanceOptimal(root));
    }
}
