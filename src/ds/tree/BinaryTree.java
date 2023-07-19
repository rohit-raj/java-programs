package ds.tree;

import java.util.*;
import static ds.tree.PrintTree.print;

public class BinaryTree {
    //public TreeNode root;

    TreeNode insert(TreeNode root, int item){
        TreeNode node = new TreeNode(item);
        if(root == null){
            root = node;
            return root;
        }
        TreeNode curr = root;
        TreeNode parent;
        while (true) {
            parent = curr;
            if(item < curr.data) {
                curr = curr.left;
                if(curr == null){
                    parent.left = node;
                    return root;
                }
            } else {
                curr = curr.right;
                if(curr == null){
                    parent.right = node;
                    return root;
                }
            }
        }
    }

    public TreeNode createRandomTree() {
        Random random = new Random();
        int size = random.nextInt(10);
        System.out.println("size : "+ size);
        int min = -30, max = 30;
        TreeNode root = null;
        for(int j = 0; j < size; j++) {
            int x = random.nextInt((max - min) + 1) + min;
            root = insert(root, x);
        }
        return root;
    }

    public TreeNode createSpecificTree(int[] items){
        int size = items.length;
        System.out.println("size : "+ size);
        TreeNode root = null;
        for(int j = 0; j < size; j++) {
            root = insert(root, items[j]);
        }
        return root;
    }

    public TreeNode createTreeByLevelOrder(Integer[] items){
        int size = items.length;
        System.out.println("size : "+ size);

        TreeNode root = new TreeNode(items[0]);
        Queue<TreeNode> q = new LinkedList<>();
        boolean isLeft = true;

        TreeNode curr = null;
        q.add(root);

        for (int i = 1; i < size; i++) {
            TreeNode node = null;
            if (items[i] != null) {
                node = new TreeNode(items[i]);
                q.add(node);
            }

            if (isLeft) {
                curr = q.poll();
                curr.left = node;
                isLeft = false;
            } else {
                curr.right = node;
                isLeft = true;
            }
        }
        return root;
    }

    public TreeNode largeTree(){
        Integer[] items = {
                0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,
                20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,
                40,41,42,43,44,45,46,47,38,39,50,51,52,53,54,55,56,57,58,59,60,61,62
        };
        return createTreeByLevelOrder(items);
    }

    public void printTree(TreeNode root){
        print(root);
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        int[] items = {-10,-3,0,5,9};
        TreeNode root = bt.createSpecificTree(items);
        bt.printTree(root);
        System.out.println();
    }

}
