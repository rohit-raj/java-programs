package ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
 */
public class ZigZagLevelOrderTraversal {

    static List<List<Integer>> zigZagLevelOrder(TreeNode root){
        List<List<Integer>> ans = new LinkedList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        boolean isEven = true;

        q.add(root);
        while (!q.isEmpty()){
            int size = q.size();
            LinkedList<Integer> subAns = new LinkedList<>();
            for (int i=0;i<size;i++) {
                TreeNode top = q.poll();

                if(top.left != null){
                    q.add(top.left);
                }

                if(top.right != null){
                    q.add(top.right);
                }

                if(isEven){
                    subAns.add(top.data);
                } else {
                    subAns.addFirst(top.data);
                }
            }
            ans.add(subAns);
            isEven = !isEven;
        }
        return ans;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.createRandomTree();

        Traversal ts = new Traversal();
        System.out.println("items : "+ ts.levelOrder(root));

        long startTime = System.nanoTime();
        List<List<Integer>> ans = zigZagLevelOrder(root);
        long endTime   = System.nanoTime();
        double totalTime = endTime-startTime;
        System.out.println(totalTime);
        System.out.println("zig zag items : "+ ans);
    }

}
