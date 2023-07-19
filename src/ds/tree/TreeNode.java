package ds.tree;
import ds.tree.PrintTree.*;

public class TreeNode implements PrintableNode {
    public int data;
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int item) {
        this.data = item;
        this.val = item;
        this.left = null;
        this.right = null;
    }

    @Override
    public PrintableNode getLeft() {
        return this.left;
    }

    @Override
    public PrintableNode getRight() {
        return this.right;
    }

    @Override
    public String getData() {
        return this.data+"";
    }
}
