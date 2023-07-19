package ds.tree;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class ConstructTreeFromPostorderandInorder {
    public static int i=0;
    public static int p=0;

    public static TreeNode buildTree(int[] inorder, int[] postorder){
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int j = 0; j < inorder.length; j++) {
            inOrderMap.put(inorder[j], j);
        }
        return buildTree(0, inorder.length-1, postorder, postorder.length-1, 0, inOrderMap);
    }

    public static TreeNode buildTree(int inStart, int inEnd, int[] postorder, int posStart, int posEnd, Map<Integer, Integer> inOrderMap){
        if(posEnd > posStart || inStart > inEnd) return null;

        TreeNode root = new TreeNode(postorder[posStart]);
        int inRoot = inOrderMap.get(root.val);
        int numsLeft = inEnd - inRoot;

        root.right = buildTree(inRoot+1, inEnd, postorder, posStart-1, posStart-numsLeft, inOrderMap);
        root.left = buildTree(inStart, inRoot-1, postorder, posStart-numsLeft-1, posEnd, inOrderMap);

        return root;

    }

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        TreeNode root = buildTree(inorder, postorder);

        BinaryTree bt = new BinaryTree();
        bt.printTree(root);
        Traversal ts = new Traversal();
        List<List<Integer>> list = ts.levelOrder(root);

        System.out.println("list : "+list);
    }
}
