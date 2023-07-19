package ds.tree;

import java.util.*;

/**
 * https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
 *
 * Below is the most optimal way to solve
 */
public class AllNodesAtADistanceK2 {

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        pathLength(root, target, map);

        List<Integer> res = new ArrayList<>();
        dfs(root, k, map, res, 0);
        return res;
    }

    private static void dfs(TreeNode curr, int k, Map<Integer, Integer> map, List<Integer> res, int l) {
        if (curr == null) return;
        if (map.containsKey(curr.val)) l = map.get(curr.val);
        if (l == k) res.add(curr.val);
        dfs(curr.left, k, map, res, l + 1);
        dfs(curr.right, k, map, res, l + 1);
    }

    private static int pathLength(TreeNode curr, TreeNode target, Map<Integer, Integer> map) {
        if (curr == null) return -1;
        if (curr == target) {
            map.put(curr.val, 0);
            return 1;
        }

        int left = pathLength(curr.left, target, map);
        if (left > 0) {
            map.put(curr.val, left);
            return left + 1;
        }

        int right = pathLength(curr.right, target, map);
        if (right > 0) {
            map.put(curr.val, right);
            return right + 1;
        }

        return -1;
    }


    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        TreeNode root = bt.largeTree();
        bt.printTree(root);

        TreeNode target = root.right.left.left.right;
        int dist = 7;

        System.out.println("\ntarget Node: "+ target.val+" : distance : "+dist);
        System.out.println("=================================\n");
        long startTime = System.nanoTime();
        List<Integer> ans = distanceK(root, target, dist);
        long endTime   = System.nanoTime();
        double totalTime = endTime-startTime;
        System.out.println("items : "+ ans+ " execution time : "+totalTime);//201963

    }
}
