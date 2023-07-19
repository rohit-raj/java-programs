package ds.tree;

/**
 * https://leetcode.com/problems/delete-node-in-a-bst/
 */
public class DeleteNodeInBst {
    public static TreeNode deleteNode(TreeNode root, int key){
        if (root== null) return null;

        if(root.val == key){
            return connector(root);
        }

        TreeNode mainRoot = root;
        while (root!=null){
            if(root.val > key){
                if(root.left !=null && root.left.val == key){
                    root.left = connector(root.left);
                    break;
                } else {
                    root = root.left;
                }
            } else {
                if(root.right != null && root.right.val == key){
                    root.right = connector(root.right);
                    break;
                } else {
                    root = root.right;
                }
            }
        }
        return mainRoot;
    }

    public static TreeNode connector(TreeNode root){
        if(root.left ==null){
            return root.right;
        } else if (root.right == null){
            return root.left;
        } else {
            TreeNode rightChild = root.right;
            TreeNode lastRightChild = findLastRightChild(root.left);
            lastRightChild.right = rightChild;
            return root.left;
        }
    }

    public static TreeNode findLastRightChild(TreeNode root){
        if(root.right == null) return root;
        return findLastRightChild(root.right);
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.createRandomBST();
        bst.printTree(root);
        int key = bst.selectRandomElement(root);
        System.out.println("key : "+ key);
        System.out.println("=================================");

        root = deleteNode(root, key);
        bst.printTree(root);

    }
}
