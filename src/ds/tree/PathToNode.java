package ds.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.codingninjas.com/studio/problems/all-root-to-leaf-paths-in-binary-tree._983599
 */
public class PathToNode {
    public static boolean traverse(TreeNode root, int item, List<Integer> ans){
        if(root == null) return false;

        ans.add(root.data);

        if (root.data == item) return true;

        if(traverse(root.left, item, ans) || traverse(root.right, item, ans)) return true;

        ans.remove(ans.size()-1);
        return false;
    }

    public static List<Integer> path(TreeNode root, int item){
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        traverse(root, item, ans);
        return ans;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.createTreeByLevelOrder(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        bt.printTree(root);

        System.out.println("path : "+ path(root, 4));
    }
}
