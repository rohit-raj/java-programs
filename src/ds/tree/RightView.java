package ds.tree;

import java.util.ArrayList;
import java.util.List;

public class RightView extends BinaryTree {

    static void rightViewHelper(TreeNode root, int level, List<Integer> nodes){
        if(root == null) return ;
        if(level == nodes.size()){
            nodes.add(root.data);
        }
        rightViewHelper(root.right, level+1, nodes);
        rightViewHelper(root.left, level+1, nodes);
    }

    static void printRightView(TreeNode root) {
        if(root == null) return ;
        int level = 0;
        List<Integer> nodes = new ArrayList<>();
        rightViewHelper(root, level, nodes);
        System.out.println(nodes);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.createRandomTree();
        bt.printTree(root);
        printRightView(root);
    }

}
