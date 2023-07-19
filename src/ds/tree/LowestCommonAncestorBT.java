package ds.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 */
public class LowestCommonAncestorBT {

    public static boolean getPath(TreeNode root, int item, List<TreeNode>ans){
        if(root == null) return false;
        ans.add(root);
        if (root.val == item) return true;

        if(getPath(root.left, item, ans) || getPath(root.right, item, ans)) return true;

        ans.remove(ans.size()-1);
        return false;
    }

    public static TreeNode lowestCommonAncestorBrute(TreeNode root, TreeNode A, TreeNode B){
        System.out.println("Node A : "+ A.val+ " : Node B : "+B.val);
        List<TreeNode> path_to_A = new ArrayList<>();
        List<TreeNode> path_to_B = new ArrayList<>();

        getPath(root, A.val, path_to_A);
        getPath(root, B.val, path_to_B);

//        System.out.println("path_to_A : "+ path_to_A.size());
//        System.out.println("path_to_B : "+ path_to_B.size());
        int i=0;
        int maxSize = Math.min(path_to_A.size(), path_to_B.size());
        for(;i<maxSize;i++){
            if(path_to_A.get(i).val != path_to_B.get(i).val){
                return path_to_A.get(i-1);
            }
        }
        return path_to_A.get(i-1);
    }

    public static TreeNode lowestCommonAncestorOptimal(TreeNode root, TreeNode A, TreeNode B){
        if(root==null || root==A || root == B){
            return root;
        }
        TreeNode left = lowestCommonAncestorOptimal(root.left, A, B);
        TreeNode right = lowestCommonAncestorOptimal(root.right, A, B);
        if(left == null) {
            return right;
        } else if(right == null){
            return left;
        } else {
            return root;
        }
    }


    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.createTreeByLevelOrder(new Integer[]{1,2,3,null, null, 4,5,8,null, 6,7});
        bt.printTree(root);

        TreeNode A = root.right.right.right;
        TreeNode B = root.right.left.left;
        TreeNode ans = lowestCommonAncestorBrute(root, A, B);
        TreeNode ans2 = lowestCommonAncestorOptimal(root, A, B);
        System.out.println("Brute LCA is : " + ans.val);
        System.out.println("Optimal LCA is : " + ans2.val);
    }
}
