package ds.tree;

/**
 * https://leetcode.com/problems/invert-binary-tree/
 */
public class InvertTree {

    public static TreeNode invertTree(TreeNode root){
        if(root == null) return null;

        TreeNode temp = root.right;
        root.right = invertTree(root.left);
        root.left = invertTree(temp);
        return root;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.createRandomTree();

        Traversal ts = new Traversal();
        System.out.println("items : "+ ts.levelOrder(root));

        TreeNode inverted = invertTree(root);
        bt.printTree(inverted);

        System.out.println("invertedItems : "+ ts.levelOrder(inverted));
    }
}
