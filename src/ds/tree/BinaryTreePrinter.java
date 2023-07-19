package ds.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Not Working
class Node1 {
    int data;
    Node1 left, right;

    Node1(int data) {
        this.data = data;
        left = right = null;
    }
}

public class BinaryTreePrinter {
    // Helper function to print binary tree diagram in level order
    private static void printBinaryTree(Node1 root) {
        if (root == null)
            return;

        List<List<String>> levels = new ArrayList<>();
        Queue<Node1> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<String> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node1 current = queue.poll();
                level.add(Integer.toString(current.data));

                if (current.left != null)
                    queue.add(current.left);

                if (current.right != null)
                    queue.add(current.right);
            }

            levels.add(level);
        }

        int depth = levels.size();
        int maxWidth = (int) Math.pow(2, depth - 1) * 4;
//        System.out.println("depth :: "+depth);

        for (int i = 0; i < depth; i++) {
            List<String> level = levels.get(i);
            int levelWidth = (int) Math.pow(2, i - 1) * 4;
            int spacing = maxWidth / level.size();

            for (int j = 0; j < level.size(); j++) {
                String value = level.get(j);
                System.out.println("value :: "+value);

                if (j > 0) {
                    System.out.print(getSpacing(spacing).length());
                    System.out.print(getConnector(i, j, level));
                }

//                if (value.equals("-1"))
//                    System.out.print(getSpacing(spacing));
//                else
                String x = getSpacing(spacing - 1) + value + getSpacing(spacing - 1);
//                System.out.print(getSpacing(spacing - 1) + value + getSpacing(spacing - 1));
            }

            System.out.println();
        }
    }

    private static String getSpacing(int count) {
        StringBuilder spacing = new StringBuilder();

        for (int i = 0; i < count; i++) {
            spacing.append(" ");
        }

        return spacing.toString();
    }

    private static String getConnector(int level, int index, List<String> levelNode1s) {
        StringBuilder connector = new StringBuilder();

        if (level > 0) {
            int spacing = (int) Math.pow(2, level - 1) * 4 - 2;
            int connectSpacing = (int) Math.pow(2, level) * 4 - 1;

            if (index % 2 == 0 && !levelNode1s.get(index - 1).equals("-1")) {
                for (int i = 0; i < spacing; i++) {
                    connector.append(" ");
                }

                connector.append("/");
            } else if (index % 2 != 0 && index < levelNode1s.size() - 1 && !levelNode1s.get(index + 1).equals("-1")) {
                for (int i = 0; i < spacing; i++) {
                    connector.append(" ");
                }

                connector.append("\\");
            } else {
                for (int i = 0; i < connectSpacing; i++) {
                    connector.append(" ");
                }
            }
        }

//        System.out.println("connector.toString() :: "+connector.toString());

        return connector.toString();
    }

    // Example usage
    public static void main(String[] args) {
        // Create a sample binary tree
        Node1 root = new Node1(1);
        root.left = new Node1(2);
        root.right = new Node1(3);
//        root.left.left = new Node1(4);
//        root.left.right = new Node1(5);
//        root.right.left = new Node1(6);
//        root.right.right = new Node1(7);

        // Print the binary tree diagram
        printBinaryTree(root);
    }
}
/*
           1
         /   \
        /     \
       /       \
      /         \
     2           3
   /   \       /   \
  4     5     6     7
 / \   / \   / \   / \
09 10 11 12 13 14 15 16


     1
   /   \
  2     3
 / \   / \
4   5 6   7


 */