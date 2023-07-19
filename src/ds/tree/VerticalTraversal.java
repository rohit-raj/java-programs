package ds.tree;

import java.util.*;

public class VerticalTraversal {

    static Map<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map;

    private static void setVerticesByDfs(TreeNode root, int row, int col){
        if(root ==null){
            return;
        }
        if(!map.containsKey(row)){
            map.put(row, new TreeMap<>());
        }
        if(!map.get(row).containsKey(col)){
            map.get(row).put(col, new PriorityQueue<>());
        }

        map.get(row).get(col).add(root.data);

        setVerticesByDfs(root.left, row-1, col+1);
        setVerticesByDfs(root.right, row+1, col+1);
    }

    public static List<List<Integer>> verticalTraversal(TreeNode root){
        map = new TreeMap<>();
        setVerticesByDfs(root, 0,0);

//        System.out.println("map : "+ map);

        List<List<Integer>> ans = new ArrayList < > ();

        for (TreeMap<Integer, PriorityQueue<Integer>> tree : map.values()){
            ans.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : tree.values()){
                while (!nodes.isEmpty()){
                    ans.get(ans.size()-1).add(nodes.poll());
                }
            }
        }
//        System.out.println("ans : "+ ans);
        return ans;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(10);


        bt.printTree(root);

        System.out.println("verticalTraversal : "+verticalTraversal(root));
        //[[4], [2, 5], [1, 9, 10, 6], [3], [10]]
    }
}
