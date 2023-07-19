package blind75;

import java.util.ArrayList;
import java.util.List;

import ds.tree.BinaryTree;
import ds.tree.TreeNode;

public class LevelOrderTraversal {

    public List<List<Integer>> levelOrderTraversal(TreeNode originalRoot){
        TreeNode root = originalRoot;
        List<List<Integer>> res = new ArrayList<>();
        traverseLevelOrder(root, res, 0);
        return res;
    }

    public void traverseLevelOrder(TreeNode root, List<List<Integer>> res, int level){
        if(root == null) return;
        if(level == res.size()) {
            res.add(new ArrayList<>());
        }

        res.get(level).add(root.data);
        traverseLevelOrder(root.left, res, level+1);
        traverseLevelOrder(root.right, res, level+1);
    }

    public static void main(String[] args) {
        LevelOrderTraversal traversal = new LevelOrderTraversal();
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.createRandomTree();
        bt.printTree(root);

        System.out.println("levelOrderTraversal : "+ traversal.levelOrderTraversal(root));

    }
}
