package ds.linkedlist;

public class DoublyLinkedList {
    Node head;
    Node tail;
    static class Node {
        int data;
        Node left;
        Node right;
        Node(int item){
            data = item;
            left = null;
            right = null;
        }
    }

    void insertAtLast(int item){
        Node n = new Node(item);

        if(head == null){
            head = n;
            return;
        }
        Node curr = head;
        while(curr.right != null){
            curr = curr.right;
        }
        curr.right = n;
        n.left = curr;
        tail = n;
    }

    void deleteAtPosition(int position){
        if(position <= 0){
            System.out.println("\nIncorrect position");
            return;
        }

        if(position == 1){
            head = head.right;
            head.left = null;
            return;
        }

        Node curr = head.right;
        Node prev = head;
        int count = 1;
        while(curr.right != null){
            count++;
            if(count == position){
                prev.right = curr.right;
                curr.right.left = prev;
            }
            prev = curr;
            curr = curr.right;
        }
    }

    static void printFromHead(Node head){
        System.out.println();
        Node curr = head;
        while(curr != null){
            System.out.print(curr.data + " -> ");
            curr = curr.right;
        }
        System.out.println("Null");
    }

    static void printFromTail(Node tail){
        System.out.println();
        Node curr = tail;
        while(curr != null){
            System.out.print(curr.data + " -> ");
            curr = curr.left;
        }
        System.out.println("Null");
    }

    public Node reverse(Node head){
        if(head == null || head.right == null) return head;

        Node temp = null;
        Node curr = head;

        while (curr != null ){
            temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            curr = curr.left;
        }
        if(temp != null )
            head = temp.left;
        return head;

    }

    public static void main(String[] args) {
        int inp [] = {10,9,8,7,6,5,4,3,2,1};

        DoublyLinkedList dLL = new DoublyLinkedList();
        for(int i=0; i<inp.length; i++){
            dLL.insertAtLast(inp[i]);
        }

        printFromHead(dLL.head);
        printFromTail(dLL.tail);

        dLL.deleteAtPosition(5);
        printFromHead(dLL.head);
        printFromTail(dLL.tail);


    }
}
