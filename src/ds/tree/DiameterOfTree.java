package ds.tree;

public class DiameterOfTree {

    public static int heightOfTree(TreeNode root, int[] max){
        if(root == null) return 0;
        int leftHeight = heightOfTree(root.left, max);
        int rightHeight = heightOfTree(root.right, max);

        max[0] = Math.max(max[0], leftHeight+rightHeight);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static int diameterBrute(TreeNode root){
        int[] max = new int[1];
        heightOfTree(root, max);
        return max[0];
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.createRandomTree();
        bt.printTree(root);
        System.out.println("diameterBrute :"+diameterBrute(root));
    }
}
