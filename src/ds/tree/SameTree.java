package ds.tree;

/**
 * https://leetcode.com/problems/same-tree/
 */
public class SameTree {
    static boolean checker(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;
        else if(root1 == null || root2 == null) return false;

        boolean currRes = false;
        if(root1.data == root2.data) currRes = true;
        if(!currRes) return false;

        boolean leftRes = checker(root1.left, root2.left);
        if(!leftRes) return false;

        boolean rightRes = checker(root1.right, root2.right);
        if (!rightRes) return false;

        return true;
    }

    static boolean isSameTree(TreeNode root1, TreeNode root2){
        return checker(root1, root2);
    }

    public static boolean isSameTree2(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null) return true;

        if(root1 == null || root2 == null) return false;

        if(root1.val != root2.val) return false;

        return isSameTree2(root1.left, root2.left) && isSameTree2(root1.right, root2.right);

    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Traversal ts = new Traversal();
        int[] items1 = {-84, -73, 88, 91};
        int[] items2 = {-84, -73, 88, 91};
        TreeNode root1 = bt.createSpecificTree(items1);
        TreeNode root2 = bt.createSpecificTree(items2);

        System.out.println("items1 : "+ ts.inOrderTraversal(root1));
        System.out.println("items2 : "+ ts.inOrderTraversal(root2));

        System.out.println("isSameTree : "+ isSameTree(root1, root2));
        System.out.println("isSameTree2 : "+ isSameTree2(root1, root2));

    }
}
