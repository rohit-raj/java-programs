package ds.tree;

import java.util.*;

/**
 * https://www.codingninjas.com/studio/problems/top-view-of-binary-tree_799401
 */
public class TopView {

    static class Pair{
        int index;
        TreeNode node;
        Pair(int _index, TreeNode _node){
            index = _index;
            node = _node;
        }
    }

    static ArrayList<Integer> getTopView(TreeNode root){
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(0, root));

        while (!queue.isEmpty()){
            Pair it = queue.remove();
            int index = it.index;
            TreeNode temp = it.node;
            map.computeIfAbsent(index, k -> temp.data);
            if(temp.left !=null)
                queue.add(new Pair(index-1, temp.left));
            if(temp.right !=null)
                queue.add(new Pair(index+1, temp.right));
        }
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        Integer[] items = {1,2,3,null,4,5,null,null,7,6,null,null,8,9,null,null,null,null,null};
        TreeNode root = bt.createTreeByLevelOrder(items);
        bt.printTree(root);
        System.out.println("getTopView : "+ getTopView(root));

        //result for {1,2,3,null,4,5,null,null,7,6,null,null,8,9,null,null,null,null,null};
        // is [9,2,1,3,8], draw and check the reason why
    }
}
