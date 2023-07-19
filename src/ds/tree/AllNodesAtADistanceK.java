package ds.tree;

import java.util.*;

/**
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 * Higher space consumption
 */
public class AllNodesAtADistanceK {


    public static HashMap<TreeNode, TreeNode> markParentsBFS(TreeNode root){
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode parent = queue.poll();
            if(parent.left != null){
                parentMap.put(parent.left, parent);
                queue.offer(parent.left);
            }
            if(parent.right != null){
                parentMap.put(parent.right, parent);
                queue.offer(parent.right);
            }
        }
        return parentMap;
    }

    public static void markParentsDFS(TreeNode root, HashMap<TreeNode, TreeNode> parentMap){
        if(root == null){
            return;
        }
        if(root.left != null){
            parentMap.put(root.left, root);
        }
        if(root.right != null){
            parentMap.put(root.right, root);
        }
        markParentsDFS(root.left, parentMap);
        markParentsDFS(root.right, parentMap);
    }


    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if(root == null)return ans;

//        HashMap<TreeNode, TreeNode> parentMap = markParentsBFS(root);
        HashMap<TreeNode, TreeNode> parentMap = new HashMap<>();
        markParentsDFS(root, parentMap);

//        for (TreeNode node : parentMap.keySet()){
//            System.out.println(" key : "+ node.data + " parent : "+ parentMap.get(node).data);
//        }

//        System.out.println("\n\n");
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();

        queue.offer(target);
        visited.put(target, true);

        int level = 0;
        while (!queue.isEmpty()){
            int size = queue.size();
            if(level == k)
                break;
            level++;
            while (size-- > 0){
                TreeNode node = queue.poll();
                if(node.left != null && !visited.containsKey(node.left)){
                    visited.put(node.left, true);
                    queue.offer(node.left);
                }

                if(node.right != null && !visited.containsKey(node.right)){
                    visited.put(node.right, true);
                    queue.offer(node.right);
                }

                if(parentMap.containsKey(node) && !visited.containsKey(parentMap.get(node))) {
                    visited.put(parentMap.get(node), true);
                    queue.offer(parentMap.get(node));
                }
            }
        }

        while (!queue.isEmpty()) {
            ans.add(queue.poll().data);
        }

        return ans;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.createTreeByLevelOrder(new Integer[]{3,5,1,6,2,0,8,null,null,7,4});
        TreeNode target = root.left;
        bt.printTree(root);

        long startTime = System.nanoTime();
        List<Integer> ans = distanceK(root, target, 2);
        long endTime   = System.nanoTime();
        double totalTime = endTime-startTime;
        System.out.println("items : "+ ans+ " execution time : "+totalTime);//201963

    }
}
