package ds.tree;

public class RecoverBinarySearchTree {

    private TreeNode first;
    private TreeNode prev;
    private TreeNode last;

    public void recoverTree(TreeNode root){
        inOrderTraversal(root);
        swapTheNodes(first, last);
        new BinarySearchTree().printTree(root);
    }

    public void inOrderTraversal(TreeNode root){
        if (root==null) return;

        inOrderTraversal(root.left);

        if(prev!=null && root.val < prev.val){
            if(first == null){
                first = prev;
            }
            last = root;
        }
        prev = root;
        inOrderTraversal(root.right);
    }

    public void swapTheNodes(TreeNode first, TreeNode last){
        first.val = first.val ^ last.val;
        last.val = first.val ^ last.val;
        first.val = first.val ^ last.val;
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        Integer[] items = {1,3,null,null,2};
        TreeNode root = bst.createSpecificBst(items);
        bst.printTree(root);

        System.out.println("===========================");

        ValidateBST vt = new ValidateBST();
        System.out.println("valid bst : "+ vt.isValidBST(root));

        RecoverBinarySearchTree recover = new RecoverBinarySearchTree();
        recover.recoverTree(root);
//        bst.printTree(root);
        System.out.println("after replacement is valid bst : "+ vt.isValidBST(root));
//        bst.printTree(root);

    }
}
