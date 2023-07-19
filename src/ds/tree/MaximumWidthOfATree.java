package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/maximum-width-of-binary-tree/
 */
public class MaximumWidthOfATree {
    static class Pair{
        TreeNode node;
        int index;
        public Pair(int _index, TreeNode _node){
            index = _index;
            node = _node;
        }
    }

    public static int findMaxWidth(TreeNode root){
        int ans =0;
        if (root == null) return ans;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(0, root));

        while (!queue.isEmpty()){
            int size = queue.size();
            int first = 0, last = 0;
            for (int i=0;i<size;i++){
                Pair p = queue.poll();
                int index = p.index;
                TreeNode node = p.node;

                if(i==0) first = index;
                if(i==size-1)last = index;

                if(node.left !=null)
                    queue.add(new Pair(index*2+1, node.left));
                if(node.right!=null)
                    queue.add(new Pair(index*2+2, node.right));
            }
            ans = Math.max(ans, (last-first+1));
        }
        return ans;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.createTreeByLevelOrder(new Integer[]{1,3,2,5,null,null,9,6,null,7});
        bt.printTree(root);

        System.out.println("findMaxWidth :: "+findMaxWidth(root));
    }


}