package ds.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode.com/problems/binary-search-tree-iterator/
 */
public class BstIterator {
    private Stack<TreeNode> stack = new Stack<>();

    public BstIterator(TreeNode root) {
        pushAll(root);
    }

    public int next() {
        TreeNode node = stack.pop();
        pushAll(node.right);
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public void pushAll(TreeNode root){
        while (root!=null){
            stack.add(root);
            root = root.left;
        }
    }

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.createSpecificBst(new Integer[]{7, 3, 15, null, null, 9, 20});
        bst.printTree(root);
        System.out.println("================================");

        BstIterator it = new BstIterator(root);

//        it.printStack();
//        System.out.println("list.size() : "+ it.list.size());

        System.out.println(it.hasNext());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.next());
        System.out.println(it.hasNext());

    }
}
