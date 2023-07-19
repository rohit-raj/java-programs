package ds.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SerializeAndDeserialize {
    public static String serializeBetter(TreeNode root){
        StringBuilder data = new StringBuilder();

        if(root == null) return data.toString();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode node = queue.poll();

            if(node==null){
                data.append("#,");
                continue;
            }
            data.append(node.val);
            data.append(",");
            queue.add(node.left);
            queue.add(node.right);
        }
        return data.toString();
    }

    public static TreeNode deSerializeBetter(String data){
        if (data.equals("")) return null;

        Queue<TreeNode> queue = new LinkedList<>();
        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.add(root);
        for (int i = 1; i < values.length; i++) {
            TreeNode node = queue.poll();
            if(!values[i].equals("#")){
                TreeNode left = new TreeNode(Integer.parseInt(values[i]));
                node.left = left;
                queue.add(left);
            }
            if(!values[++i].equals("#")){
                TreeNode right = new TreeNode(Integer.parseInt(values[i]));
                node.right = right;
                queue.add(right);
            }
        }
        return root;
    }

    public static String serializeOptimal(TreeNode root){
        StringBuilder sb = new StringBuilder();
        add(root, sb);
        return sb.toString();
    }

    public static void add(TreeNode root, StringBuilder sb){
        if(root!=null){
            sb.appendCodePoint(root.val+1000);
            add(root.left, sb);
            add(root.right, sb);
        }else {
            sb.appendCodePoint(2048);
        }
    }

    static int x;
    static String str;
    public static TreeNode deSerializeOptimal(String data){
        str = data;
        x = 0;
        return construct();
    }

    public static TreeNode construct(){
        if(x>=str.length()){
            return null;
        }
        final int cp = str.codePointAt(x++);
        if(cp == 2048){
            return null;
        }
        TreeNode root = new TreeNode(cp-1000);
        root.left = construct();
        root.right = construct();
        return root;
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.createTreeByLevelOrder(new Integer[]{-12,-27,25,null,null,7,null});
        bt.printTree(root);

        String data = serializeOptimal(root);
        System.out.println("serialized Data : "+ data);

        TreeNode deSerialized = deSerializeOptimal(data);
        bt.printTree(deSerialized);

    }
}
