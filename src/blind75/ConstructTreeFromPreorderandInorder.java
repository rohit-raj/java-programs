package blind75;

import ds.tree.BinaryTree;
import ds.tree.Traversal;
import ds.tree.TreeNode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructTreeFromPreorderandInorder {

    public static TreeNode construct(int[] preorder, int[] inorder){
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            inMap.put(inorder[i], i);
        }

        return construct(preorder, 0, preorder.length-1, 0, inorder.length-1, inMap);
    }

    public static TreeNode construct(int[] preorder, int preStart, int preEnd,
                                     int inStart, int inEnd, Map<Integer, Integer> inMap){
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preorder[preStart]); // first preorder element is root
        int inRootPosition = inMap.get(preorder[preStart]);// find the position of root in inorder list
        int numsLeft = inRootPosition - inStart; // elements before root in indorder list

        // pass the next numLeft element from root in preOrder list, preStart is the root position and
        // pass all starting elements till inRootLeft which is root position in inorder list
        root.left = construct(preorder, preStart+1, preStart+numsLeft, inStart, inRootPosition-1, inMap);

        // pass the rest end part of preorder list till end
        // pass all the elements after root in inorder list
        root.right = construct(preorder, preStart+numsLeft+1, preEnd, inRootPosition+1, inEnd, inMap);

        return root;
    }

    private static int i = 0;
    private static int p = 0;

    public static TreeNode buildTreeOptimal(int[] preorder, int[] inorder) {
        return build(preorder, inorder, Integer.MIN_VALUE, "start");
    }

    private static TreeNode build(int[] preorder, int[] inorder, int stop, String value) {
        if (p >= preorder.length) {
            return null;
        }
        if (inorder[i] == stop) {
            ++i;
//            System.out.println(value +" : update i to : "+ i+" :: stop : "+ stop+" : inorder[i] : "+inorder[i-1]);
            return null;
        }

        TreeNode node = new TreeNode(preorder[p++]);
        System.out.println(value +" : root : "+ node.val+ " : i :: "+ i+" :: stop : "+ stop);
        TreeNode left = build(preorder, inorder, node.val, "left");
        System.out.println("root : "+ node.val+ " : left : "+ (left!=null?left.val : " null"));
        node.left = left;

        TreeNode right = build(preorder, inorder, stop, "right");
        System.out.println("root : "+ node.val+ " : right : "+ (right!=null?right.val : " null"));
        node.right = right;
        System.out.println();
        return node;
    }


    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};

        TreeNode root = construct(preorder, inorder); //Easy and efficient
//        TreeNode root = buildTreeOptimal(preorder, inorder); // optimal in context to running the code

        BinaryTree bt = new BinaryTree();
        bt.printTree(root);
        Traversal ts = new Traversal();
        List<List<Integer>> list = ts.levelOrder(root);

        System.out.println("list : "+list);
    }
}
