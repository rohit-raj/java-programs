package ds.tree;

import java.util.*;

public class Traversal {

    /**
     * In order : Left Node Right
     * Pre order : Node Left Right
     * Post order : Left Right Node
     */


    /**
     * Inorder
     */
    public List<Integer> inOrderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        recursiveInOrder(root, ans);
        return ans;
    }

    public void recursiveInOrder(TreeNode root, List<Integer> ans){
        if(root == null) return;
        recursiveInOrder(root.left, ans);
        ans.add(root.data);
        recursiveInOrder(root.right, ans);
    }

    public List<Integer> iterativeInorder(TreeNode originalRoot){
        TreeNode root = originalRoot;
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Stack<TreeNode> stack = new Stack<>();

        while (true){
            if(root !=null){
                stack.push(root);
                root = root.left;
            } else {
                if (stack.isEmpty()) break;
                root = stack.peek();
                ans.add(root.data);
                stack.pop();
                root = root.right;
            }
        }
        return ans;
    }

    /**
     * Preorder
     */
    public List<Integer> preOrderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        recursivePreOrder(root, ans);
        return ans;
    }

    public void recursivePreOrder(TreeNode root, List<Integer> ans){
        if(root == null) return;
        ans.add(root.data);
        recursivePreOrder(root.left, ans);
        recursivePreOrder(root.right, ans);
    }

    public List<Integer> iterativePreorder(TreeNode originalRoot){
        TreeNode root = originalRoot;
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode topNode = stack.peek();
            ans.add(topNode.data);
            stack.pop();
            if(topNode.right != null){
                stack.push(topNode.right);
            }
            if(topNode.left != null){
                stack.push(topNode.left);
            }
        }
        return ans;
    }


    /**
     * Postorder
     */
    public List<Integer> postOrderTraversal(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        recursivePostorder(root, ans);
        return ans;
    }

    public void recursivePostorder(TreeNode root, List<Integer> ans){
        if(root == null) return;
        recursivePostorder(root.left, ans);
        recursivePostorder(root.right, ans);
        ans.add(root.data);
    }

    public List<Integer> iterativePostorder(TreeNode originalRoot){
        TreeNode root = originalRoot;
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;

        Stack<TreeNode> stack = new Stack<>();

        while (root !=null || !stack.isEmpty()){
            if(root !=null){
                stack.push(root);
                root = root.left;
            } else {
                TreeNode temp = stack.peek().right;
                if(temp == null){
                    temp = stack.peek();
                    stack.pop();
                    ans.add(temp.data);
                    while (!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.peek();
                        stack.pop();
                        ans.add(temp.data);
                    }
                } else {
                    root = temp;
                }
            }
        }
        return ans;
    }


    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root == null) return ans;

        queue.offer(root);
        while (!queue.isEmpty()){
            List<Integer> subList = new ArrayList<>();
            int level = queue.size();
            for(int i=0;i<level;i++){
                if(queue.peek().left !=null)queue.offer(queue.peek().left);
                if(queue.peek().right !=null)queue.offer(queue.peek().right);
                subList.add(queue.poll().data);
            }
            ans.add(subList);
        }
        return ans;
    }


    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.createRandomTree();

        bt.printTree(root);

        Traversal tv = new Traversal();
        System.out.println("inOrderTraversal : "+ tv.inOrderTraversal(root));
        System.out.println("iterativeInorder : "+ tv.iterativeInorder(root));

        System.out.println("preOrderTraversal : "+ tv.preOrderTraversal(root));
        System.out.println("iterativePreorder : "+ tv.iterativePreorder(root));

        System.out.println("postOrderTraversal : "+ tv.postOrderTraversal(root));
        System.out.println("iterativePostorder : "+ tv.iterativePostorder(root));


    }
}
