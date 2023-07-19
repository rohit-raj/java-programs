package ds.tree;

import algo.searching.BinarySearch;
import ds.linkedlist.Node;
import ds.linkedlist.SinglyLinkedList;

public class ConvertLinkedListToBST {
    public static SinglyLinkedList sll;

    public static TreeNode convertTree(Node head){
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.data);

        Node prev = findMid(head);
        System.out.println("prev : "+prev.data);
        Node mid = prev.next;

        int midItem = mid.data;

        Node right = mid.next;
        prev.next = null;

        sll.printByHead(head);
        sll.print(right);
        TreeNode root = new TreeNode(midItem);
        root.left = convertTree(head);
        root.right = convertTree(right);
        return root;
    }

    public static Node findMid(Node head){
        if (head == null) return null;
        Node prev= null;
        Node fast = head;
        Node slow = head;
        while (fast!=null && fast.next !=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        return prev;
    }

    public static void main(String[] args) {
        sll = new SinglyLinkedList();
        Node head = sll.createListFromItems(new int[]{-10,-3});
//        sll.print(head);
        System.out.println("===========================");

        TreeNode root = convertTree(head);
        BinaryTree bt = new BinaryTree();
        bt.printTree(root);
    }
}
